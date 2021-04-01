
package hust.soict.globalict.aims;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;


public class DiskTest {
	public static void main(String[] args) {
		Order anOrder = new Order();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Stars Wars",
				"Science Fiction","George Lucas",87,24.95f);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin",
				"Animation",18.99f);
		
// Adding one element		
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
//		anOrder.printDvdList();

// Adding a list		
		DigitalVideoDisc dvd4=new DigitalVideoDisc("The Little Mermaid",
				"Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd5=new DigitalVideoDisc("The Avengers",
				"Science Fiction","George Lucas",87,24.95f);
		DigitalVideoDisc dvd6=new DigitalVideoDisc("Superman",
				"Animation",18.99f);
		DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[3];
		itemsOrdered[0]=dvd4;
		itemsOrdered[1]=dvd5;
		itemsOrdered[2]=dvd6;
		anOrder.addDigitalVideoDisc(itemsOrdered);
//		anOrder.printDvdList();

// Adding two elements		
		anOrder.addDigitalVideoDisc(dvd1,dvd2);
		
// Print list		
//		anOrder.printDvdList();
		
// Total cost
//		System.out.println("The total cost is: "+anOrder.totalCost());
		System.out.println();
		
		Order anOrder2 = new Order("twenty first","January","1980");
		Order anOrder3 = new Order("twenty second","February","1960");
// Adding one element		
		anOrder2.addDigitalVideoDisc(dvd1);
		anOrder2.addDigitalVideoDisc(dvd3);
//		anOrder.printDvdList();
		anOrder3.addDigitalVideoDisc(dvd2);
		anOrder3.addDigitalVideoDisc(dvd5);
// Adding a list		
		anOrder2.addDigitalVideoDisc(itemsOrdered);
//		anOrder.printDvdList();

// Adding two elements		
		anOrder2.addDigitalVideoDisc(dvd1,dvd2);
		
// Print list		
//		anOrder2.printDvdList();
		
// Total cost
		Order orderList[]=new Order[anOrder.getMaxLimitedOrder()];
		orderList[0]=anOrder;
		orderList[1]=anOrder2;
		orderList[2]=anOrder3;
		System.out.println("The list of order before sorted: \n");
		for(int i=0;i<anOrder.getMaxLimitedOrder();i++) {
			if(orderList[i]!= null ) {
				orderList[i].printDvdList();
				System.out.println("The total cost is: "+orderList[i].totalCost());
				System.out.println();
			}
		}
		System.out.println("The list of order after sorted: \n");
		orderList[0].sortDate(orderList);
		for(int i=0;i<anOrder.getMaxLimitedOrder();i++) {
			if(orderList[i]!=null) {
				orderList[i].printDvdList();
				System.out.println("The total cost is: "+orderList[i].totalCost());
				System.out.println();
			}
		}
//		System.out.println("The total cost is: "+anOrder2.totalCost());
		for(int i=0;i<anOrder.getMaxLimitedOrder();i++) {
			if(orderList[i]!=null) {
				System.out.println("List "+(i+1)+": ");
				orderList[i].printDvdList();
				System.out.println("The disc to get free: "+orderList[i].getALuckyItem().getTitle());
				float cost = orderList[i].totalCost() - orderList[i].getALuckyItem().getCost();
				System.out.println("The total cost after getting free a disc is: "+ cost);
				System.out.println();
			}
		}
	}
}