package hust.soict.globalict.aims.media;

import java.util.List;

public abstract class Media {
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
	public boolean equals(Media m1) {
		if(this.getClass().equals(m1.getClass())) {
			if(this.getTitle().equalsIgnoreCase(m1.getTitle())
			   && this.getCost()==m1.getCost()) return true;
			else return false;
		}
		else return false;
	}
	public int compareTo() {
		return 0;
	}
}
