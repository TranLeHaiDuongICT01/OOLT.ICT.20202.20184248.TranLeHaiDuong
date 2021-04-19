package hust.soict.globalict.aims.media;
//import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private final int CAPACITY = 100;
	private int index = 0;
	private List<String> authors = new ArrayList<String>(CAPACITY);
	public Book(String title) {
		super(title);
	}
	public Book(String title,String category,float cost){ 
		super(title,category,cost); 
	} 
	
	@Override
	public List<String> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
		if(index==CAPACITY) {
			System.out.println("The list is full!");
			return;
		}
		this.authors.add(authorName);
		index++;
	}
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			System.out.println(authorName+" is not in the list!");
			return;
		}
		this.authors.remove(authorName);
		index--;
	}
	public static void main(String[] args) {
		
	}
}
