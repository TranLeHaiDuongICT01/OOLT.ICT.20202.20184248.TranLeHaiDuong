package hust.soict.globalict.aims;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;
import java.util.Scanner;
public class Aims {
	public static void showMenu() { 
		System.out.println("Order Management Application: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Create new order"); 
		System.out.println("2. Add item to the order"); 
		System.out.println("3. Delete item by id"); 
		System.out.println("4. Display the items list of order"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
		} 
	public static void main(String[] args) {
		showMenu();
		int n;
		int check=0;
		Order anOrder = null;
		Scanner key = new Scanner(System.in);
		do {
			n = key.nextInt();
			switch(n) {
			case 0:
				return;
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
					DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King",
							"Animation","Roger Allers",87,19.95f);
					DigitalVideoDisc dvd2=new DigitalVideoDisc("Stars Wars",
							"Science Fiction","George Lucas",87,24.95f);
					DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin",
							"Animation",18.99f);
					anOrder.addMedia(dvd1);
					anOrder.addMedia(dvd2);
					anOrder.addMedia(dvd3);
					Book book1 = new Book("Homelessness","Horror",13.9f);
					book1.addAuthor("Victor");
					DigitalVideoDisc dvd4=new DigitalVideoDisc("The Little Mermaid",
							"Animation","Roger Allers",87,19.95f);
					anOrder.addMedia(dvd4);
					anOrder.addMedia(book1);
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
			}
		}while(n>=0 && n<=4);
	
	}
}