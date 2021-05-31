package hust.soict.globalict.aims;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.order.Order;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.SwingUtilities;
public class Aims {
	public static void showMenu() { 
		System.out.println("Order Management Application: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Create new order"); 
		System.out.println("2. Add item to the order"); 
		System.out.println("3. Delete item by id"); 
		System.out.println("4. Display the items list of order");
		System.out.println("5. Play the list!");
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
		} 
	public static void main(String[] args) throws LimitExceededException, PlayerException {
		MemoryDaemon daemon = new MemoryDaemon(); 
//		daemon.run();
		System.out.println(daemon.getMemoryUsed());
		showMenu();
		int n;
		int check=0;
		Order anOrder = null;
		Scanner key = new Scanner(System.in);
loop1:		do {
			n = key.nextInt();
			switch(n) {
			case 0:
				break loop1;
			case 1:
				anOrder = new Order();
				check=1;
				System.out.println("Create new order successfully!");
				break;
			case 2:
				if(check==0) {
					System.out.println("You haven't created an order yet!");
					continue;
				}
				else {
					System.out.println("a. Add book"); 
					System.out.println("b. Add Compact Disc"); 
					System.out.println("c. Add DigitalVideoDisc");
					char t = key.next().charAt(0);
					switch(t) {
					case 'a':
						Book book1 = new Book("Homelessness","Horror",13.9f);
						book1.addAuthor("Victor");
						
						Book book2 = new Book("HunterxHunter","Action",13.9f);
						book2.addAuthor("Victor");
						anOrder.addMedia(book1);
						anOrder.addMedia(book2);
						break;
					case 'b':
						CompactDisc Cdisc = new CompactDisc("sfbdfbc",
								"Animation","Roger Allers","abc",19.95f);
						Cdisc.addTrack(new Track("dfbdb",15));
						Cdisc.addTrack(new Track("fvdfdf",56));
						anOrder.addMedia(Cdisc);
						break;
					case 'c':
						DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King",
								"Animation","Roger Allers",0,19.95f);
						DigitalVideoDisc dvd2=new DigitalVideoDisc("Stars Wars",
								"Science Fiction","George Lucas",87,24.95f);
						DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin",
								"Animation",18.99f);
						anOrder.addMedia(dvd1);
						anOrder.addMedia(dvd2);
						anOrder.addMedia(dvd3);
						DigitalVideoDisc dvd4=new DigitalVideoDisc("The Little Mermaid",
								"Animation","Roger Allers",87,19.95f);
						anOrder.addMedia(dvd4);
						break;
					}
					check=2;
					System.out.println("Add new items successfully!");
					break;
				}
			case 3:
				if(check==0) {
					System.out.println("You haven't created items yet!");
					continue;
				}
				else if(check==1) {
					System.out.println("You haven't added an order yet!");
					continue;
				}
				else {
					String removeTitle = key.nextLine();
					DigitalVideoDisc mediaRemove = new DigitalVideoDisc(removeTitle);
					anOrder.removeMedia(mediaRemove);
					break;
				}
			case 4:
				if(check==0) {
					System.out.println("You haven't created items yet!");
					continue;
				}
				else if(check==1) {
					System.out.println("You haven't added an order yet!");
					continue;
				}
				else {
					anOrder.printMedia();
					System.out.println("Print order successfully!");
					break;
				}
			case 5:
				if(check==0) {
					System.out.println("You haven't created items yet!");
					continue;
				}
				else if(check==1) {
					System.out.println("You haven't added an order yet!");
					continue;
				}
				else {
					for(int i=0;i<anOrder.getItemsOrdered().size();i++) {
						try {
							if(anOrder.getItemsOrdered().get(i) instanceof Book) {
								System.out.println("This is a book, cannot play!");
							}
							else if(anOrder.getItemsOrdered().get(i) instanceof DigitalVideoDisc) {
								DigitalVideoDisc d = (DigitalVideoDisc) anOrder.getItemsOrdered().get(i);
								d.play();
							}
							else if(anOrder.getItemsOrdered().get(i) instanceof CompactDisc) {
								CompactDisc c = (CompactDisc) anOrder.getItemsOrdered().get(i);
								c.play();
							}
						} catch (PlayerException e) {
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									new PlayError(e.getMessage(),e.toString(),e.getError());
								}
							});
							throw e;
						}
					}
				}
				break;
			default:
				System.out.println("Re input!");
				break;
			}
		}while(n>=0 && n<=4);
		daemon.run();
		System.out.println(daemon.getMemoryUsed());
		key.close();
		System.exit(0);
	}
}