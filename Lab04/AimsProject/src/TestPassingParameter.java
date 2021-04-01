

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD,cinderellaDVD);
		System.out.println("jungle dvd title: "+jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+cinderellaDVD.getTitle());
		
		System.out.println();
		DigitalVideoDisc jungle2DVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderella2DVD = new DigitalVideoDisc("Cinderella");
		changeTilte(jungle2DVD,cinderella2DVD.getTitle());
		System.out.println("jungle2 dvd title: "+jungleDVD.getTitle());
		
	}
	public static void swap(DigitalVideoDisc d1,DigitalVideoDisc d2) {
		String title1=d1.getTitle();
		String title2=d2.getTitle();
		String temp=title1;
		d1.setTitle(title2);
		d2.setTitle(temp);
	}
	public static void changeTilte(DigitalVideoDisc dvd,String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}