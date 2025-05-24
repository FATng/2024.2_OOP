package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor with all fields
    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    // Constructor with title, length
    public Disc(String title, int length) {
        super(title);
        this.length = length;
    }
    
    public Disc(String title) {
        super(title);
    }

    public Disc(float cost) {
        super(cost);
    }
    
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
    // Getters
    public int getLength() {
        return length;
    }


    public String getDirector() {
        return director;
    }

	public Disc() {
		// TODO Auto-generated constructor stub
	}

}
