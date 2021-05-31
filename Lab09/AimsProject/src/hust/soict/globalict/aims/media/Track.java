package hust.soict.globalict.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	public String getTitle() {
		return this.title;
	}
	public int getLength() {
		return this.length;
	}
	public Track() {
		
	}
	public Track(String title, int length) {
		this.title=title;
		this.length=length;
	}
	public Track(String title){
		this.title=title;
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
}
