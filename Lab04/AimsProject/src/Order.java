
public class Order {
	public static final int MAX_NUMER_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMER_ORDERED];
	private int size = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(size>=10) {
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
		if(size>=10) {
			System.out.println("The order is almost full, cannot be added");
			return;
		}
		if(dvdList.length+size>10) {
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
		if(size>=9) {
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
		for(int i=0;i<size;i++) {
			System.out.println("'"+itemsOrdered[i].getTitle()+"'"+" "+itemsOrdered[i].getCategory()
					+" "+itemsOrdered[i].getCost());
		}
	}
	public int qtyOrdered() {
		return size;
	}
}
