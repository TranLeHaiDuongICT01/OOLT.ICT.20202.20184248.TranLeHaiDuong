package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	@Override
	public String getTitle() {
		return super.getTitle();
	}
	@Override
	public String getCategory() {
		return super.getCategory();
	}
	@Override
	public float getCost() {
		return super.getCost();
	}
	
	@Override
	public DigitalVideoDisc getDisc(DigitalVideoDisc dvd) {
		return dvd;
	}
	
	@Override
	public String getDirector() {
		return super.getDirector();
	}
	
	@Override
	public int getLength() {
		return super.getLength();
	}
	
	public void setTitle(String title) {
		super.setTitle(title);
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
}