package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private Cart cart = new Cart();
    private Scanner scanner = new Scanner(System.in);

    // Method to add a Media item to the store
    public void addMedia(Media media) {
        if (itemsInStore.size() >= MAX_NUMBERS_IN_STORE) {
            System.out.println("The store is full. Can't add more media.");
            return;
        }
        if (media == null) {
            System.out.println("Error: Cannot add null media item.");
            return;
        }
        itemsInStore.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
    }

    // Method to remove a Media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty!");
            return;
        }
        if (media == null) {
            System.out.println("Error: Cannot remove null media item.");
            return;
        }
        if (itemsInStore.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Media not found in the store!");
        }
    }

    // Method to search for a media item by title
    public Media searchByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return null;
        }
        title = title.trim();
        for (Media media : itemsInStore) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Method to print all items in the store
    public void print() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty!");
            return;
        }
        System.out.println("********************STORE********************");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("*********************************************");
    }

    // Main method to run the console application
    public static void main(String[] args) {
        Store store = new Store();
        // Initialize store with some media items
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
        store.addMedia(new CompactDisc("Abbey Road", "Rock", 14.99f, "The Beatles"));

        store.runApplication();
    }

    // Method to run the menu-driven application
    private void runApplication() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: // View store
                    viewStore();
                    break;
                case 2: // Update store
                    updateStore();
                    break;
                case 3: // See current cart
                    seeCurrentCart();
                    break;
                case 0: // Exit
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private void viewStore() {
        print(); // Display all items in the store
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: // See a media’s details
                    seeMediaDetails();
                    break;
                case 2: // Add a media to cart
                    addMediaToCart();
                    break;
                case 3: // Play a media
                    playMedia();
                    break;
                case 4: // See current cart
                    seeCurrentCart();
                    break;
                case 0: // Back
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void seeMediaDetails() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = searchByTitle(title);

        if (media == null) {
            System.out.println("Media with title '" + title + "' not found.");
            return;
        }

        System.out.println(media.toString());
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: // Add to cart
                    cart.addMedia(media);
                    if (media instanceof DigitalVideoDisc) {
                        System.out.println("Number of DVDs in cart: " + cart.countDVDs());
                    }
                    System.out.println("Media added to cart.");
                    break;
                case 2: // Play (only for CD and DVD)
                    if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0: // Back
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addMediaToCart() {
        System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();
        Media media = searchByTitle(title);

        if (media == null) {
            System.out.println("Media with title '" + title + "' not found.");
            return;
        }

        cart.addMedia(media);
        if (media instanceof DigitalVideoDisc) {
            System.out.println("Number of DVDs in cart: " + cart.countDVDs());
        }
    }

    private void playMedia() {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = searchByTitle(title);

        if (media == null) {
            System.out.println("Media with title '" + title + "' not found.");
            return;
        }

        if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private void updateStore() {
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("Please choose a number: 1-2");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1: // Add a media
                System.out.println("Enter media type (DVD/CD):");
                String type = scanner.nextLine();
                System.out.println("Enter title:");
                String title = scanner.nextLine();
                System.out.println("Enter category:");
                String category = scanner.nextLine();
                System.out.println("Enter cost:");
                float cost = scanner.nextFloat();
                if (cost < 0) {
                    System.out.println("Cost cannot be negative.");
                    scanner.nextLine();
                    return;
                }
                scanner.nextLine(); // Clear buffer

                Media media;
                if (type.equalsIgnoreCase("DVD")) {
                    System.out.println("Enter length:");
                    int length = scanner.nextInt();
                    if (length < 0) {
                        System.out.println("Length cannot be negative.");
                        scanner.nextLine();
                        return;
                    }
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Enter director:");
                    String director = scanner.nextLine();
                    media = new DigitalVideoDisc(title, category, director, length, cost);
                } else if (type.equalsIgnoreCase("CD")) {
                    System.out.println("Enter artist:");
                    String artist = scanner.nextLine();
                    media = new CompactDisc(title, category, cost, artist);
                } else {
                    System.out.println("Unsupported media type.");
                    return;
                }
                addMedia(media);
                break;

            case 2: // Remove a media
                System.out.println("Enter the title of the media to remove:");
                title = scanner.nextLine();
                media = searchByTitle(title);
                if (media == null) {
                    System.out.println("Media with title '" + title + "' not found.");
                    return;
                }
                removeMedia(media);
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private void seeCurrentCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: // Filter media in cart
                    filterMediaInCart();
                    break;
                case 2: // Sort media in cart
                    sortMediaInCart();
                    break;
                case 3: // Remove media from cart
                    removeMediaFromCart();
                    break;
                case 4: // Play a media
                    playMediaFromCart();
                    break;
                case 5: // Place order
                    System.out.println("An order has been created.");
                    cart.emptyCart();
                    System.out.println("Cart has been emptied.");
                    break;
                case 0: // Back
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void filterMediaInCart() {
        System.out.println("Filter by: 1. ID  2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1: // Filter by ID
                System.out.println("Enter ID:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                cart.searchById(id);
                break;
            case 2: // Filter by title
                System.out.println("Enter title:");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void sortMediaInCart() {
        System.out.println("Sort by: 1. Title  2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1: // Sort by title
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                System.out.println("Cart sorted by title.");
                cart.print();
                break;
            case 2: // Sort by cost
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                System.out.println("Cart sorted by cost.");
                cart.print();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void removeMediaFromCart() {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = cart.searchByTitleReturnMedia(title);

        if (media == null) {
            System.out.println("Media with title '" + title + "' not found in cart.");
            return;
        }

        cart.removeMedia(media);
    }

    private void playMediaFromCart() {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = cart.searchByTitleReturnMedia(title);

        if (media == null) {
            System.out.println("Media with title '" + title + "' not found in cart.");
            return;
        }

        if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }
}