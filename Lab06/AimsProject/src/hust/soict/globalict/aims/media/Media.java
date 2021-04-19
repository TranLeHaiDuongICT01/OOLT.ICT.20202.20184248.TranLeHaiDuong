package hust.soict.globalict.aims.media;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class Media {
	protected String title;
	protected String category;
	protected float cost; 
	public Media(String title){ 
		this.title = title; 
	} 
	public Media(String title,  String category,float cost){ 
		this(title); 
		this.category = category; 
		this.cost = cost;
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
}
