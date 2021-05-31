package hust.soict.globalict.aims.order;

import java.time.LocalDate; 
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MyDate;
public class Order{
	public static final int MAX_NUMER_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS=5;
	private static int nbOrders=0;
	private MyDate dateOrdered;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(MAX_NUMER_ORDERED);
	private int size = 0;
	public int getMaxLimitedOrder() {
		return MAX_LIMITTED_ORDERS;
	}
	public Order(String day,String month,String year) {
		dateOrdered=new MyDate(day,month,year);
		if(nbOrders>=MAX_LIMITTED_ORDERS) {
			System.out.println("The number of orders reaches the limit!");
			return;
		}
		nbOrders++;
	}
	public Order(Order list) {
		this.dateOrdered=list.dateOrdered;
		this.itemsOrdered=list.itemsOrdered;
	}
	public Order() throws LimitExceededException {
		if(nbOrders>=MAX_LIMITTED_ORDERS) {
			throw new LimitExceededException("ERROR: The number of order has reached limit!");
		}
		nbOrders++;
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		String month = String.valueOf(currentMonth).toLowerCase();
		month = month.substring(0,1).toUpperCase()+month.substring(1);
		String year = String.valueOf(currentDate.getYear());
		int currentDay = currentDate.getDayOfMonth();
		String day="";
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
			case 20:
				day="twentieth";
				break;
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
			case 21:
				day+="twenty first";
				break;
			case 22:
				day+="twenty second";
				break;
			case 23:
				day+="twenty third";
				break;
			case 24:
				day+="twenty fourth";
				break;
			case 25:
				day+="twenty fifth";
				break;
			case 26:
				day+="twenty sixth";
				break;
			case 27:
				day+="twenty seventh";
				break;
			case 28:
				day+="twenty eighth";
				break;
			case 29:
				day+="twenty ninth";
				break;
			case 30: 
				day="thirdtieth";
				break;
			default:
				break;
			}
		dateOrdered=new MyDate(day,month,year);
	}
	public int getNbOrders() {
		return nbOrders;
	}
	public MyDate getDate() {
		return dateOrdered;
	}
	public void addMedia(Media media) {
		if(size>=MAX_NUMER_ORDERED) {
			System.out.println("The order is almost full");
			return;
		}
		for(int i=0;i<size;i++) {
			if(itemsOrdered.get(i).equals(media)) {
				System.out.println("The disc has been added");
				return;
			}
		}
		itemsOrdered.add(media);
		size++;
	}
	public void addMedia(Media[] mediaList) {
		if(size>=MAX_NUMER_ORDERED) {
			System.out.println("The order is almost full, cannot be added");
			return;
		}
		if(itemsOrdered.size()+size>MAX_NUMER_ORDERED) {
			System.out.println("The insert list length is greater than the default length");
			return;
		}
		int n = mediaList.length;
		int i=0,check=0;
		while(i!=n) {
			for(int j=0;j<size;j++) {
				if(itemsOrdered.get(j).equals(mediaList[i])) {
					check=j;
				}
			}
			if(check==0) {
				itemsOrdered.add(mediaList[i]);
				i++;
				size++;
			}
			else {
				System.out.println(itemsOrdered.get(check).getTitle()+" has been added");
			}
		}
	}
	public void addMedia(Media dvd1,Media dvd2) {
		if(size>=MAX_NUMER_ORDERED-1) {
			System.out.println("The order is almost full");
			return;
		}
		int check1=0,check2=0;
		for(int j=0;j<size;j++) {
			if(itemsOrdered.get(j).equals(dvd1)) {
				System.out.println(itemsOrdered.get(j).getTitle()+" has been added");
				check1=1;
			}
			if(itemsOrdered.get(j).equals(dvd2)) {
				System.out.println(itemsOrdered.get(j).getTitle()+" has been added");
				check2=1;
			}
		}
		if(check1==0) {
			itemsOrdered.add(dvd1);
			size++;
		}
		if(check2==0) {
			itemsOrdered.add(dvd2);
			size++;
		}
	}
	public void removeMedia(Media media) {
		for(int i=0;i<size;i++) {
			if(itemsOrdered.get(i).getTitle().equalsIgnoreCase(media.getTitle())) {
				itemsOrdered.remove(i);
				size--;
				System.out.println("Remove items successfully!");
				return;
			}
		}
		System.out.println("The item does not exist!");
	}
	public float totalCost() {
		float cost=0.0f;
		for(int i=0;i<size;i++) {
			cost=cost + itemsOrdered.get(i).getCost();
		}
		return cost;
	}
	public void printMedia() {
//		System.out.println(size);
		dateOrdered.print();
		dateOrdered.print2();
		for(int i=0;i<size;i++) {
			if(itemsOrdered.get(i) instanceof DigitalVideoDisc) {
				System.out.println(i+1+". DVD - "+itemsOrdered.get(i).getTitle()+" - "
						+itemsOrdered.get(i).getCategory()+" - "+itemsOrdered.get(i).getDirector()
						+" - "+itemsOrdered.get(i).getLength()+": "+itemsOrdered.get(i).getCost()+"$");
			}
			else if(itemsOrdered.get(i) instanceof Book) {
				System.out.println(i+1+". BOOK - "+itemsOrdered.get(i).getTitle()+" - "
						+itemsOrdered.get(i).getCategory()+" - "
						+itemsOrdered.get(i).getAuthors()+": "+itemsOrdered.get(i).getCost()+"$");
			}
			else if(itemsOrdered.get(i) instanceof CompactDisc) {
				System.out.println(i+1+". Compact Disc - "+itemsOrdered.get(i).getTitle()+" - "
								+itemsOrdered.get(i).getCategory()+" - "+itemsOrdered.get(i).getArtist()+" - "
								+itemsOrdered.get(i).getLength()+": "+itemsOrdered.get(i).getCost()+"$");
				System.out.println('\t'+"Tracks List: "+itemsOrdered.get(i).getTrackInfo());
			}
		}
	}
	public int qtyOrdered() {
		return size;
	}
	public boolean compare(MyDate date1,MyDate date2) {
		int year1=Integer.valueOf(date1.getYear());
		int year2=Integer.valueOf(date2.getYear());
		if(year1<year2) return true;
		else if(year1>year2) return false;
		else{
			if(date1.getMonthNo()<date2.getMonthNo()) return true;
			else if(date1.getMonthNo()>date2.getMonthNo()) return false;
			else {
				if(date1.getDayNo()<=date2.getDayNo()) return true;
				else return false;
			}
		}
	}
	public void sortDate(Order orderList[]) {
		for(int i=0;i<orderList[0].getNbOrders()-1;i++) {
			for(int j=i+i;j<orderList[0].getNbOrders();j++) {
				if(!compare(orderList[i].getDate(),orderList[j].getDate())) {
					Order temp;
					temp=orderList[i];
					orderList[i]=orderList[j];
					orderList[j]=temp;
				}
			}
		}
	}
	public boolean compare(String title1,String title2) {
		String substring="";
		String s1=title1.toLowerCase();
		String s2=title2.toLowerCase();
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=' ') {
				substring+=s1.charAt(i);
			}
			if(substring!="" && (s1.charAt(i)==' ' || i==s1.length()-1)) {
				if(!s2.contains(substring)) return false;
				substring="";
			}
		}
		return true;
	}
	public void searchInListOfMedia(String title) {
		for(int i=0;i<size;i++) {
			if(compare(itemsOrdered.get(i).getTitle(),title)) {
				if(itemsOrdered.get(i) instanceof DigitalVideoDisc) {
					System.out.println(" DVD - "+itemsOrdered.get(i).getTitle()+" - "
							+itemsOrdered.get(i).getCategory()+" - "+itemsOrdered.get(i).getDirector()
							+" - "+itemsOrdered.get(i).getLength()+": "+itemsOrdered.get(i).getCost()+"$");
				}
				else {
					System.out.println(" BOOK - "+itemsOrdered.get(i).getTitle()+" - "
							+itemsOrdered.get(i).getCategory()+" - "
							+itemsOrdered.get(i).getAuthors()+": "+itemsOrdered.get(i).getCost()+"$");
				}
			}
		}
	}
	public Media getALuckyItem() {
		Random rand = new Random();
        int int_rand = rand.nextInt(size);
        return itemsOrdered.get(int_rand);
	}
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
}