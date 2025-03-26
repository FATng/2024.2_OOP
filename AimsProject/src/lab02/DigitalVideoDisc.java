package lab02;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
    private int id;
    public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
        this.title = title;
        this.category = category;
        this.directory = directory;
        this.length = length;
        this.cost = cost;
        
        nbDigitalVideoDiscs++;  // Increment the counter
        this.id = nbDigitalVideoDiscs;  // Assign the unique ID
    }
    public int getId() {
        return id;
    }
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirectory() {
		return directory;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title) {
        this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
	    this.title = title;
	    this.category = category;
	    this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, float cost) {
	    this.title = title;
	    this.category = category;
	    this.directory = directory;
	    this.cost = cost;
	}
	public DigitalVideoDisc(int length) {
		super();
		this.length = length;
	}
	public DigitalVideoDisc(float cost) {
		super();
		this.cost = cost;
	}
		public void setTitle(String titleSet){ title = titleSet; }
	    public void setCategory(String categorySet){ category = categorySet; }
	    public void setDirectory(String directorySet){ directory = directorySet; }
	    public void setLength(int lengthSet){ length = lengthSet; }
	    public void setCost(float costSet){ cost = costSet; }
}
