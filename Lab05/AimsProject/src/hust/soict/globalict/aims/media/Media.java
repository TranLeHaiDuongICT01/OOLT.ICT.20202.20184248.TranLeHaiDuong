package hust.soict.globalict.aims.media;

import java.util.List;

public abstract class Media implements Comparable {
	private String title;
	private String category;
	private float cost; 
	public Media() {
		
	}
	public Media(String title){ 
		this.title=title;
	} 
	public Media(String title,String category, float cost){ 
		this.title=title;
		this.category=category;
		this.cost=cost;
	} 
	public String getTitle() {
		return this.title;
	}
	public String getCategory() {
		return this.category;
	}
	public float getCost() {
		return this.cost;
	}
	public String getContent() {
		return null;
	}
	public List<String> getAuthors() {
		return null;
	}
	public DigitalVideoDisc getDisc(DigitalVideoDisc dvd) {
		return null;
	}
	public String getDirector() {
		return null;
	}
	public int getLength() {
		return 0;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getArtist() {
		return null;
	}
	public List<Track> getTrack() {
		return null;
	}
	public List<String> getTrackInfo() {
		return null;
	}
	@Override
	public boolean equals(Object o) {
		Media me = (Media) o;
		Media me2 = (Media) this;
		if(me2.getTitle().equalsIgnoreCase(me.getTitle())) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Book) {
			if(!(this instanceof Book)) {
				return 0;
			}
			if(this.getTitle().equalsIgnoreCase(((Book) o).getTitle()))
				return 1;
			else return 0;
		}
		else if(o instanceof DigitalVideoDisc) {
			if(!(this instanceof DigitalVideoDisc)) {
				return 0;
			}
			if(this.getTitle().equalsIgnoreCase(((DigitalVideoDisc) o).getTitle()))
				return 1;
			else return 0;
		}
		else if(o instanceof CompactDisc) {
			if(!(this instanceof CompactDisc)) {
				return 0;
			}
			if(this.getTitle().equalsIgnoreCase(((CompactDisc) o).getTitle()))
				return 1;
			else return 0;
		}
		return 0;
	}
}
