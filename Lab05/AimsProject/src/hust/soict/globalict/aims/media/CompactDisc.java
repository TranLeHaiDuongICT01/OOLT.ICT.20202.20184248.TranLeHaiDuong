package hust.soict.globalict.aims.media;

import java.util.ArrayList; 
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc(String title, String category, String director,String artist, float cost) {
		super(title,category,director,cost);
		this.artist=artist;
	}

	public void addTrack(Track add) {
		for(int i=0;i<tracks.size();i++) {
			if(tracks.get(i).getTitle().equalsIgnoreCase(add.getTitle())) {
				System.out.println("The input track is already in the list!");
				return;
			}
		}
		tracks.add(add);
	}
	public void removeTrack(Track remove) {
		if(tracks.contains(remove)) {
			tracks.remove(remove);
		}
		else {
			System.out.println("The input track does not exist in the list!");
		}
	}
	
	@Override
	public int getLength() {
		int sum = 0;
		for(int i=0;i<tracks.size();i++) {
			sum+=tracks.get(i).getLength();
		}
		return sum;
	}
	@Override
	public String getArtist() {
		return artist;
	}
	@Override
	public void play() {
		for(int i=0;i<tracks.size();i++) {
			System.out.println("Playing DVD: " + tracks.get(i).getTitle()); 
			System.out.println("DVD length: " + tracks.get(i).getLength()); 
		}
	}
	
	@Override
	public List<String> getTrackInfo(){
		List<String> tracksInfo = new ArrayList<String>();
		for(int i=0;i<tracks.size();i++) {
			tracksInfo.add(tracks.get(i).getTitle());
		}
		return tracksInfo;
	}

	
}
