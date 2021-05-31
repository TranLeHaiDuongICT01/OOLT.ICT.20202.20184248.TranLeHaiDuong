package hust.soict.globalict.aims.media;
//import java.lang.Object;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Book extends Media {
	private final int CAPACITY = 100;
	private int index = 0;
	private String content;
	private List<String> authors = new ArrayList<String>(CAPACITY);
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String,Integer> wordFrequency = new HashMap<String,Integer>();
	public Book(String title) {
		super(title);
	}
	public Book(String title,String category,float cost){ 
		super(title,category,cost);
	} 
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public void processContent() {
		String[] Res = content.split("[\\p{Punct}\\s]+");
		for (String s:Res){
		    contentTokens.add(s);
		}
		Collections.sort(contentTokens);
//		List<String> sorted = contentTokens.stream().sorted().collect(Collectors.toList());
//		contentTokens = new ArrayList<String>(sorted);
		java.util.Iterator iterator = contentTokens.iterator();
		while(iterator.hasNext()) {
			String temp = (String)iterator.next();
			if(wordFrequency.containsKey(temp)) {
				for(Map.Entry<String, Integer> m : wordFrequency.entrySet()) {
					if(m.getKey().equals(temp)) {
						int n = m.getValue();
						n++;
						m.setValue(n);
					}
				}
			}
			else {
				wordFrequency.put(temp, 1);
			}
		}
		System.out.println(contentTokens);
		System.out.println(wordFrequency);
	}
}
