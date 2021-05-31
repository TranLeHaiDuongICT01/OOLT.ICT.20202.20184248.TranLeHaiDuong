package hust.soict.globalict.aims.media;
import java.lang.Object;
public class Track implements Playable, Comparable {
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
	
	@Override
	public boolean equals(Object o) {
		Track tr1 =(Track) o;
		Track tr2 = (Track) this;
		if(tr2.getTitle().equalsIgnoreCase(tr1.getTitle())
		&& tr2.getLength()==tr1.getLength()) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Track) {
			if(!(this instanceof Track)) {
				return 0;
			}
			if(this.getTitle().equalsIgnoreCase(((Track) o).getTitle()) && this.getLength()==((Track) o).getLength()) {
				return 1;
			}
			else return 0;
		}
		return 0;
	}
}
