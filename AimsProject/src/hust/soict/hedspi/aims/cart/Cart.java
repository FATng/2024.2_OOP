package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Getter for itemsOrdered
    public ArrayList<Media> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered); // Return a copy to protect encapsulation
    }

    // Method to add a single Media item to the cart
    public int addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Can't add more media.");
            return 0;
        }
        if (media == null) {
            System.out.println("Error: Cannot add null media item.");
            return 0;
        }
        itemsOrdered.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added!");
        return 1;
    }

    // Method to add multiple Media items
    public int addMedia(Media... mediaItems) {
        int addedCount = 0;
        for (Media media : mediaItems) {
            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full. Can't add more media.");
                break;
            }
            if (media == null) {
                System.out.println("Error: Cannot add null media item.");
                continue;
            }
            itemsOrdered.add(media);
            addedCount++;
            System.out.println("The media \"" + media.getTitle() + "\" has been added!");
        }
        return addedCount;
    }

    // Method to add two Media items
    public int addMedia(Media media1, Media media2) {
        int addedCount = 0;
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED && media1 != null) {
            itemsOrdered.add(media1);
            addedCount++;
            System.out.println("The media \"" + media1.getTitle() + "\" has been added!");
        } else if (media1 != null) {
            System.out.println("The cart is full. Can't add media \"" + media1.getTitle() + "\".");
        } else {
            System.out.println("Error: Cannot add null media item.");
        }
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED && media2 != null) {
            itemsOrdered.add(media2);
            addedCount++;
            System.out.println("The media \"" + media2.getTitle() + "\" has been added!");
        } else if (media2 != null) {
            System.out.println("The cart is full. Can't add media \"" + media2.getTitle() + "\".");
        } else {
            System.out.println("Error: Cannot add null media item.");
        }
        return addedCount;
    }

    // Method to remove a Media item from the cart
    public int removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Your cart is empty!");
            return 0;
        }
        if (media == null) {
            System.out.println("Error: Cannot remove null media item.");
            return 0;
        }
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed media \"" + media.getTitle() + "\" successfully!");
            return 1;
        }
        System.out.println("No media match!");
        return 0;
    }

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
        float sum = 0.0f;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Method to search for a Media item by ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found media: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media with ID " + id + " found.");
        }
    }

    // Method to search for Media items by title (prints results)
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null && media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Matched media: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with title matching \"" + title + "\" found.");
        }
    }

    // Method to search for a Media item by title (returns Media object)
    public Media searchByTitleReturnMedia(String title) {
        if (title == null || title.trim().isEmpty()) {
            return null;
        }
        title = title.trim();
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Method to count DVDs in the cart
    public int countDVDs() {
        int dvdCount = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                dvdCount++;
            }
        }
        return dvdCount;
    }

    // Method to clear the cart
    public void emptyCart() {
        itemsOrdered.clear();
    }
}