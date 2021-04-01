import java.util.Scanner;
public class DisplayNumberOfDays{
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		System.out.println("Input month: ");
		String month=key.nextLine();
		System.out.println("Input year: ");
		int year=key.nextInt();
		while(year<=0 || year>2021) {
			System.out.println("Year "+year+" doesn't exists! Re-enter.");
			year=key.nextInt();
		}
		int check;
		if(year%100==0) {
			if(year%400==0) check=0;//nam nhuan
			else check=1;//nam khong nhuan
		}
		else {
			if(year%4==0) check=0;
			else check=1;
		}
		switch(month){
		case "January":
		case "Jan.":
		case "Jan":
		case "1":
			
		case "March":
		case "Mar.":
		case "Mar":
		case "3":
			
		case "May":
		case "5":
			
		case "July":
		case "Jul":
		case "7":
			
		case "August":
		case "Aug.":
		case "Aug":
		case "8":
			
		case "October":
		case "Oct.":
		case "Oct":
		case "10":
		
		case "December":
		case "Dec.":
		case "Dec":
		case "12":
			System.out.println("31 days");
			break;
		case "February":
		case "Feb.":
		case "Feb":
		case "2":
			if(check==0) {
				System.out.println("29 days");
			}
			if(check==1) {
				System.out.println("28 days");
			}
			break;
		case "April":
		case "Apr.":
		case "Apr":
		case "4":
			
		case "June":
		case "Jun":
		case "6":
			
		case "September":
		case "Sep.":
		case "Sep":
		case "9":
			
		case "November":
		case "Nov.":
		case "Nov":
		case "11":
			System.out.println("30 days");
			break;
		default:
			System.out.println("Month "+month+" doesn't exists!");
			break;
		}
		key.close();
	}
}