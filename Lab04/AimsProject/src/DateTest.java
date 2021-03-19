
public class DateTest {
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
		anOrder.printDvdList();
		
// Total cost
		System.out.println("The total cost is: "+anOrder.totalCost());
		System.out.println();
	}
}
