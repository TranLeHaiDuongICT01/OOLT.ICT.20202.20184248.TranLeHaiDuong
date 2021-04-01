public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public DigitalVideoDisc getDisc(DigitalVideoDisc dvd) {
		return dvd;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public boolean search(String title) {
		String substring="";
		String s1=this.title.toLowerCase();
		String s2=title.toLowerCase();
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=' ') {
				substring+=s1.charAt(i);
			}
			if(substring!="" && (s1.charAt(i)==' ' || i==s1.length()-1)) {
				if(!s2.contains(substring)) return false;
				substring="";
			}
		}
		return true;
	}
}