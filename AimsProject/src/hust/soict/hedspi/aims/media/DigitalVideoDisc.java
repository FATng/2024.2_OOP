package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    public String getDirectory() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public void setDirector(String directorSet) {
        this.director = directorSet;
    }

    public void setLength(int lengthSet) {
        this.length = lengthSet;
    }

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(int length) {
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(float cost) {
        super(cost);
        nbDigitalVideoDiscs++;
    }

    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle() != null && this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}