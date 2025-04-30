package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	
	    private String artist;
	    private List<Track> tracks = new ArrayList<>();

	    // Constructor with all fields
	    public CompactDisc(String title, String category, float cost, String artist) {
	        super(title, category, cost);
	        this.artist = artist;
	    }
	    
	    public CompactDisc(String title, String category, float cost) {
	    	super(title, category, cost);
	    }

	    // Getter
	    public String getArtist() {
	        return artist;
	    }

	    // Method to add a track
	    public void addTrack(Track track) {
	        if (track == null) {
	            System.out.println("Error: Cannot add null track.");
	            return;
	        }
	        if (tracks.contains(track)) {
	            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
	        } else {
	            tracks.add(track);
	            System.out.println("Track \"" + track.getTitle() + "\" added successfully.");
	        }
	    }

	    // Method to remove a track
	    public void removeTrack(Track track) {
	        if (track == null) {
	            System.out.println("Error: Cannot remove null track.");
	            return;
	        }
	        if (tracks.remove(track)) {
	            System.out.println("Track \"" + track.getTitle() + "\" removed successfully.");
	        } else {
	            System.out.println("Track \"" + track.getTitle() + "\" not found in the CD.");
	        }
	    }

	    // Method to calculate total length of the CD
	    public int getLength() {
	        int totalLength = 0;
	        for (Track track : tracks) {
	            totalLength += track.getLength();
	        }
	        return totalLength;
	    }
	
	// Method play() from Playable
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Total length: " + this.getLength());
        if (tracks.isEmpty()) {
            System.out.println("No tracks available to play.");
        } else {
            System.out.println("Playing tracks:");
            for (Track track : tracks) {
                track.play();
            }
        }
    }

}
