package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Aims {

    private static Scanner sc = new Scanner(System.in);
    private static Cart order = new Cart();
    private static Store store = new Store();
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
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void test(){}
    public static void showDetailsOfEachMediaType(Media media) {

        int maxLen = 20;
        if (media instanceof DigitalVideoDisc) {
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.printf("║ Title: %-"+ maxLen +"s \n", media.getTitle());
            System.out.printf("║ Director: %-"+ maxLen +"s \n", ((DigitalVideoDisc) media).getDirector());
            System.out.printf("║ Length: %-3d minutes \n", ((DigitalVideoDisc) media).getLength());
            System.out.printf("║ Cost: $%-5.2f \n", media.getCost());
            System.out.println("╚══════════════════════════════════════════════╝");

        } else if (media instanceof CompactDisc) {

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.printf("║ Title: %-"+ maxLen +"s \n", media.getTitle());
            System.out.printf("║ Artist: %-"+ maxLen +"s \n", ((CompactDisc) media).getArtist());
            for(Track t: ((CompactDisc) media).getTrack()){
                System.out.printf("║ Track: %-"+ maxLen +"s \n", t.getTitle());
                System.out.printf("║ Length: %-3d minutes \n", t.getLength());
            }
            System.out.printf("║ Cost: $%-5.2f \n", media.getCost());
            System.out.println("╚══════════════════════════════════════════════╝");
        } else if (media instanceof Book) {

            List<String> authors = ((Book) media).getAuthors();
            String authorsString = String.join(", ", authors);

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.printf("║ Title: %-"+ maxLen +"s \n", media.getTitle());
            System.out.printf("║ Authors: %-"+ maxLen +"s \n", authorsString);
            System.out.printf("║ Cost: $%-5.2f \n", media.getCost());
            System.out.println("╚══════════════════════════════════════════════╝");
        } else {
            System.out.println("Unknown media type");
        }
    }

    public static void addToCart(Media m) throws LimitExceededException {
        order.addMedia(m);
    }

    public static void playMedia(Media m) throws PlayerException {
        try {
        if (m instanceof DigitalVideoDisc) {
            System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            ((DigitalVideoDisc) m).play();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        } else if (m instanceof CompactDisc) {
            System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            ((CompactDisc) m).play();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        } else {
            System.out.println("This type of media does not have play mode");
        }

        } catch (PlayerException e) {
            handleException(e);
        }
    }

    public static boolean solveOptionOfMediaDetailsSelected(Media m) throws PlayerException, LimitExceededException {
        try {
            switch (readOption()) {

                case 1:
                    addToCart(m);
                    break;

                case 2:
                    playMedia(m);
                    break;

                case 0:
                    return true;

                default:
                    System.out.println("This option is not available");
                    return false;
            }
            }catch (PlayerException | LimitExceededException e) {
                handleException(e);
            }
        return false;
    }

    public static void showMediaDetails() throws PlayerException, LimitExceededException {

        sc.nextLine();
        System.out.println("Enter the title of the media: ");
        Media tmp = store.searchMedia(sc.nextLine());
        if(tmp!=null){
            showDetailsOfEachMediaType(tmp);

            boolean backToMenuStore = false;

            while (!backToMenuStore) {
                mediaDetailsMenu();
                backToMenuStore = solveOptionOfMediaDetailsSelected(tmp);
            }
        }
        else {
            System.out.println("The Media does not exist in the store");
        }

    }

    public static void addAMediaToCart() throws LimitExceededException {
        sc.nextLine();
        System.out.println("Enter the title of the media you want to add to the cart: ");
        Media tmp = store.searchMedia(sc.nextLine());
        if(tmp!=null){
            order.addMedia(tmp);
        }
        else {
            System.out.println("The Media does not exist in the store");
        }
        int count = 0;
        if(tmp instanceof DigitalVideoDisc){
            for(Media m : order.getItemsOrdered())
                if(m instanceof  DigitalVideoDisc) count++;

            System.out.println("The number of DVDs in the current cart: " + count +"\n");
        }
    }

    public static void playAMedia() throws PlayerException {
        sc.nextLine();
        System.out.println("Enter the title of the media you want to play: ");
        Media tmp = store.searchMedia(sc.nextLine());
        playMedia(tmp);
    }
    public static boolean solveOptionOfStoreMenuSelected() throws PlayerException, LimitExceededException {
        switch (readOption()){

            case 1:
                showMediaDetails();
                break;

            case 2:
                addAMediaToCart();
                break;

            case 3:
                playAMedia();
                break;

            case 4:
                seeCurrentCart();
                break;

            case 0:
                return true;

            default:
                System.out.println("This option is not available");
                return false;
        }
        return false;
    }

    public static void viewStore() throws PlayerException, LimitExceededException {

        boolean backToMenuMain = false;

        while (!backToMenuMain) {
            store.printStore();
            storeMenu();
            backToMenuMain = solveOptionOfStoreMenuSelected();
        }
    }

    public static void updateStoreMenu(){
        System.out.println("Update Store");
        System.out.println("--------------------------------");
        System.out.println("1. Add a Media");
        System.out.println("2. Remove a Media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }


    public static void addAMediaToStoreMenu(){
        System.out.println("What type of media do you want to add?");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void addABookToStore(){
        sc.nextLine();
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Cost: ");
        float cost = sc.nextFloat();
        List<String> authors = new ArrayList<>();
        sc.nextLine();
        System.out.println("Author (enter 'done' to finish): ");
        while (true) {

            String author = sc.nextLine();

            if (author.equalsIgnoreCase("done")) {
                break;
            }

            authors.add(author);
        }
        store.addMedia(new Book(title, "Book", cost, authors));
        System.out.println("Added Book to Store successfully");
    }
    public static void addADVDToStore(){
        System.out.println("------DVD------");
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Cost: ");
        float cost = sc.nextFloat();
        sc.nextLine();

        System.out.print("Director: ");
        String director = sc.nextLine();

        System.out.print("Length: ");
        int length = sc.nextInt();
        sc.nextLine();

        store.addMedia(new DigitalVideoDisc(title, "DVD", director, length, cost));
        System.out.println("Added DVD to Store successfully");
    }
    public static void addACDToStore(){
        sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Cost: ");
        float cost = sc.nextFloat();
        sc.nextLine();

        System.out.print("Artist: ");
        String artist = sc.nextLine();


        System.out.println("Enter Track Information for CD (Enter '0' to finish):");
        ArrayList<Track> tracks = new ArrayList<>();
        int trackNumber = 1;
        while (true) {
            System.out.print("Track " + trackNumber + " Title (Enter '0' to finish): ");
            String trackTitle = sc.nextLine();
            if (trackTitle.equals("0")) {
                break;
            }

            System.out.print("Track " + trackNumber + " Length: ");
            int trackLength = sc.nextInt();
            sc.nextLine();

            Track track = new Track(trackTitle, trackLength);
            tracks.add(track);
            trackNumber++;
        }

        store.addMedia(new CompactDisc(title, "CD", cost, artist, tracks));
        System.out.println("Added CD to Store successfully");
    }

    public static boolean solveOptionOfAddAMediaToStoreSelected(){
        switch (readOption()){

            case 1:
                addABookToStore();
                break;

            case 2:
                addADVDToStore();
                break;

            case 3:
                addACDToStore();
                break;

            case 0:
                return true;

            default:
                System.out.println("This option is not available");
                return false;
        }
        return false;
    }
    public static void addAMediaToStore(){

        boolean backToUpdateStoreMenu = false;

        while (!backToUpdateStoreMenu) {
            addAMediaToStoreMenu();
            backToUpdateStoreMenu = solveOptionOfAddAMediaToStoreSelected();
        }
    }
    public static void removeAMediaFromStore(){
        sc.nextLine();
        System.out.println("Enter the title of the media you want to remove: ");
        Media tmp = store.searchMedia(sc.nextLine());
        if(tmp!=null){
            store.removeMedia(tmp);
        }
        else {
            System.out.println("The Media does not exist in the store");
        }
    }
    public static boolean solveOptionOfUpdateStoreMenuSelected(){
        switch (readOption()){

            // 1. Add a Media
            case 1:
                addAMediaToStore();
                break;

            // 2. Remove a Media
            case 2:
                removeAMediaFromStore();
                break;

            // 0. Back
            case 0:
                return true;

            default:
                System.out.println("This option is not available");
                return false;
        }
        return false;
    }
    public static void updateStore(){

        boolean backToMenuMain = false;

        while (!backToMenuMain) {
            updateStoreMenu();
            backToMenuMain = solveOptionOfUpdateStoreMenuSelected();
        }

    }

    public static void filterMediaInCart(){

        sc.nextLine();
        System.out.println("Enter the title of the media you want to filter: ");
        String title = sc.nextLine();

        ObservableList<Media> itemsOrdered = order.getItemsOrdered();

        System.out.println("Ordered Items by Title:");
        int i = 0;

        String lowerCaseKeyword = title.toLowerCase();
        for (Media media : itemsOrdered){

            String lowerCaseTitle = media.getTitle().toLowerCase();
            if (lowerCaseTitle.contains(lowerCaseKeyword)){
                System.out.printf("#%d: %s. %.2f $\n", ++i, media.getTitle(), media.getCost());
            }

        }
    }

    public static void sortMediasInCart() {
        System.out.println("Sort by: \n1. Cost\n2. Title");
        switch (readOption()) {
            case 1:
                order.sortByCost();
                break;
            case 2:
                order.sortByTitle();
                break;
        }
    }

    public static void removeAMediaFromCart(){

        sc.nextLine();
        System.out.println("Enter the title of the media you want to remove: ");
        Media tmp = order.searchMedia(sc.nextLine());
        if(tmp!=null){
            order.removeMedia(tmp);        
        }
        else {
            System.out.println("The Media does not exist in the cart");
        }
    }

    public static void placeOrder(){
        if(order.getItemsOrdered().isEmpty()){
            System.out.println("Your order is empty");
        }
        else{
            System.out.println("Order is created);
        }
    }

    public static boolean solveOptionOfCartMenuSelected() throws PlayerException {
        switch (readOption()){

            // 1. Filter medias in cart
            case 1:
                filterMediaInCart();
                break;

            // 2. Sort medias in cart
            case 2:
                sortMediasInCart();
                break;

            // 3. Remove media from cart
            case 3:
                removeAMediaFromCart();
                break;

            // 4. Play a media
            case 4:
                playAMedia();
                break;

            // 5. Place order
            case 5:
                placeOrder();
                break;

            // 0. Back
            case 0:
                return true;

            default:
                System.out.println("This option is not available");
                return false;
        }
        return false;
    }

    public static void seeCurrentCart() throws PlayerException {

        order.printCart();
        boolean back= false;

        while (!back) {
            cartMenu();
            back = solveOptionOfCartMenuSelected();
        }


    }

    public static void solveOptionSelected() throws PlayerException, LimitExceededException {
        switch (readOption()){

            // 1. View store
            case 1:
                viewStore();
                break;

            // 2. Update store
            case 2:
                updateStore();
                break;

            // 3. See current cart
            case 3:
                seeCurrentCart();
                break;

            // 0. Exit
            case 0:
                System.out.println("Are you sure you want to exit the system?");
                if(sc.next().charAt(0) == 'y'){
                    System.exit(0);
                    sc.close();
                }
                else {
                    break;
                }
                break;

            default:
                System.out.println("This option is not available");
                break;
        }
    }

    public static int readOption(){
        return sc.nextInt();
    }

    public static void initData(){

        Book initBook = new Book("The Great Novel", "Book", 100.00f,
                Arrays.asList("John Doe", "Jane Smith"));

        Book initBook2 = new Book("OOP1", "Book", 100.00f,
                Arrays.asList("Tuan", "Dung"));

        Book initBook3 = new Book("OOP2", "Book", 100.00f,
                Arrays.asList("Dat", "Duong"));

        DigitalVideoDisc initDVD = new DigitalVideoDisc("Inception", "DVD",
                "Christopher Nolan", 0, 35.88f);

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Song 1", 3));
        tracks.add(new Track("Song 2", 4));
        CompactDisc initCD = new CompactDisc("The Best Hits", "CD", 90.00f,
                "Various Artists", tracks);

        store.addMedia(initBook);
        store.addMedia(initBook2);
        store.addMedia(initBook3);
        store.addMedia(initCD);
        store.addMedia(initDVD);
    }

    public static void main(String[] args) throws PlayerException, LimitExceededException {

            initData();
            while (true) {
                showMenu();
                solveOptionSelected();
            }
    }

    public static void handleException(Exception e) {
        String errorMessage = "An exception occurred: " + e.getMessage();
        System.out.println(errorMessage);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Frame");

            frame.setVisible(true);
            JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        });

    }
}