
public class Order {
	public static final int MAX_NUMER_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMER_ORDERED];
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		int count=0;
		for(int i=0;i<10;i++) {
			if(this.itemsOrdered[i]!=null) {
				count++;
			}
		}
		if(count>10) {
			System.out.println("The order is almost full");
			return;
		}
		for(int i=0;i<10;i++) {
			if(this.itemsOrdered[i]==disc) {
				System.out.println("The disc has been added");
				return;
			}
		}
		for(int i=0;i<10;i++) {
			if(this.itemsOrdered[i]==null) {
				this.itemsOrdered[i]=disc;
				break;
			}
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0;i<10;i++) {
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
	}
	public float totalCost() {
		float cost=0;
		for(int i=0;i<10;i++) {
			if(this.itemsOrdered[i]==null)
				break;
			cost+=this.itemsOrdered[i].getCost();
		}
		return cost;
	}
}