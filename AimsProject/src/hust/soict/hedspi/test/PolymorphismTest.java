package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        List<Media> mediae = new ArrayList<Media>();

        // Create some media: cd, dvd, book
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", 19.99f, "The Beatles");
        cd.addTrack(new Track("Come Together", 260));
        cd.addTrack(new Track("Something", 183));

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Sci-Fi", 14.99f);

        // Add media to the list
        mediae.add(cd);
        mediae.add(dvd);

        // Iterate through the list and print information using toString()
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}