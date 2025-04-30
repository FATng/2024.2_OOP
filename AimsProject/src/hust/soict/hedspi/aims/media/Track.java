package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Default constructor
    public Track() {
    }

    // Constructor with all fields
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Method play() from Playable
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    // Override equals to compare title and length
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Track)) return false;
        Track other = (Track) o;
        return title != null && title.equals(other.title) && length == other.length;
    }

    // Override hashCode to be consistent with equals
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + length;
        return result;
    }

    // toString for display in CompactDisc play or other methods
    public String toString() {
        return "Track [title=" + title + ", length=" + length + "]";
    }
}