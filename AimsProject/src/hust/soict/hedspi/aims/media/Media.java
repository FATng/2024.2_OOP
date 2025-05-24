package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Playable{
    private int id;
    private String title;
    private String category;
    private float cost;
    
    // Static final comparators
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    // Default constructor
    public Media() {
    }

    // Constructor with title, category, cost
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor with title only
    public Media(String title) {
        this.title = title;
    }

    // Constructor with cost only
    public Media(float cost) {
        this.cost = cost;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    // Override equals to compare titles
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Media)) return false;
        Media other = (Media) o;
        return title != null && title.equals(other.title);
    }

    // Override hashCode to be consistent with equals
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    // toString for search and print methods
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
    }
    
    public void play() {
        System.out.println("Playing: " + this.getTitle());
    }
}