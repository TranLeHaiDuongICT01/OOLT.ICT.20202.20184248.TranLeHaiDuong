public class Aims {
	public static void main(String[] args) {
		Order anOrder = new Order();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Stars Wars",
				"Science Fiction","George Lucas",87,24.95f);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin",
				"Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
//		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("The total cost is: ");
		System.out.println(anOrder.totalCost());
	}
}