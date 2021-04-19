package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title);
		this.category=category;
		this.cost=cost;
		this.director = director;
		this.length = length;
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title);
		this.category=category;
		this.cost=cost;
	}
	@Override
	public String getTitle() {
		return this.title;
	}
	@Override
	public String getCategory() {
		return this.category;
	}
	@Override
	public float getCost() {
		return this.cost;
	}
	
	@Override
	public DigitalVideoDisc getDisc(DigitalVideoDisc dvd) {
		return dvd;
	}
	
	@Override
	public String getDirector() {
		return director;
	}
	
	@Override
	public int getLength() {
		return length;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
}