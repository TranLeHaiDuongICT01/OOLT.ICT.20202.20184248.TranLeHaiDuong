import java.time.LocalDate;
import java.time.Month;
public class Order {
	public static final int MAX_NUMER_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS=5;
	private static int nbOrders=0;
	private MyDate dateOrdered;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMER_ORDERED];
	private int size = 0;
	public Order(){
		if(nbOrders>=MAX_LIMITTED_ORDERS) {
			System.out.println("The number of orders reaches the limit!");
			return;
		}
		nbOrders++;
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		String month = String.valueOf(currentMonth).toLowerCase();
		month = month.substring(0,1).toUpperCase()+month.substring(1);
		String year = String.valueOf(currentDate.getYear());
		int currentDay = currentDate.getDayOfMonth();
		String day="";
		if(currentDay==30)
			day="thirdtieth";
		else {
			if(currentDay>=10&&currentDay<=20) {
				switch(currentDay) {
				case 10:
					day="tenth";
					break;
				case 11:
					day="elementh";
					break;
				case 12:
					day="twelfth";
					break;
				case 13:
					day="thirdteenth";
					break;
				case 14:
					day="fourteenth";
					break;
				case 15:
					day="fifteenth";
					break;
				case 16:
					day="sixteenth";
					break;
				case 17:
					day="seventeenth";
					break;
				case 18:
					day="eighteenth";
					break;
				case 19:
					day="ninteenth";
					break;
				default:
					day="twentieth";
					break;
				}
			}
			else {
				switch(currentDay/10) {
				case 2:
					day+="twenty";
					break;
				case 3:
					day+="thirdty";
					break;
				default:
					break;
				}
				currentDay%=10;
				switch(currentDay) {
				case 1:
					day+="first";
					break;
				case 2:
					day+="second";
					break;
				case 3:
					day+="third";
					break;
				case 4:
					day+="fourth";
					break;
				case 5:
					day+="fifth";
					break;
				case 6:
					day+="sixth";
					break;
				case 7:
					day+="seventh";
					break;
				case 8:
					day+="eighth";
					break;
				case 9:
					day+="ninth";
					break;
				default:
					break;
				}
			}
		}
		dateOrdered=new MyDate(day,month,year);
	}
	public int getNbOrders() {
		return nbOrders;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(size>=MAX_NUMER_ORDERED) {
			System.out.println("The order is almost full");
			return;
		}
		for(int i=0;i<size;i++) {
			if(this.itemsOrdered[i]==disc) {
				System.out.println("The disc has been added");
				return;
			}
		}
		this.itemsOrdered[size++]=disc;
//		System.out.println(size);
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if(size>=MAX_NUMER_ORDERED) {
			System.out.println("The order is almost full, cannot be added");
			return;
		}
		if(dvdList.length+size>MAX_NUMER_ORDERED) {
			System.out.println("The insert list length is greater than the default length");
			return;
		}
		int n = dvdList.length;
		int i=0,j=size;
		while(i!=n) {
			this.itemsOrdered[j]=dvdList[i];
			i++;j++;
			size++;
//			System.out.println(size);
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(size>=MAX_NUMER_ORDERED-1) {
			System.out.println("The order is almost full");
			return;
		}
		this.itemsOrdered[size++]=dvd1;
		this.itemsOrdered[size++]=dvd2;
//		System.out.println(size);
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0;i<size;i++) {
			if(this.itemsOrdered[i]==disc) {
				if(i==9) {
					this.itemsOrdered[i]=null;
					return;
				}
				for(int j=i;j<9;j++) {
					this.itemsOrdered[j]=this.itemsOrdered[j+1];
				}
			}
		}
		size--;
//		System.out.println(size);
	}
	public float totalCost() {
		float cost=0;
		for(int i=0;i<size;i++) {
			if(this.itemsOrdered[i]==null)
				break;
			cost+=this.itemsOrdered[i].getCost();
		}
		return cost;
	}
	public void printDvdList() {
//		System.out.println(size);
		dateOrdered.print();
		dateOrdered.print2();
		for(int i=0;i<size;i++) {
			System.out.println(i+1+". DVD - "+itemsOrdered[i].getTitle()+" - "
			+itemsOrdered[i].getCategory()+" - "+itemsOrdered[i].getDirector()
			+" - "+itemsOrdered[i].getLength()+": "+itemsOrdered[i].getCost()+"$");
		}
	}
	public int qtyOrdered() {
		return size;
	}
}

