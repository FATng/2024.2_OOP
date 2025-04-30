package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import java.util.ArrayList;
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

    }

    public ArrayList<Media> getItemsInStore() {
        return new ArrayList<>(itemsInStore); // Return a copy to protect encapsulation
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
}