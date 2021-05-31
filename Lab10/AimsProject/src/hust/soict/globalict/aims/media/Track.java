package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

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
	public void play() throws PlayerException {
		if(this.getLength()<=0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
}
