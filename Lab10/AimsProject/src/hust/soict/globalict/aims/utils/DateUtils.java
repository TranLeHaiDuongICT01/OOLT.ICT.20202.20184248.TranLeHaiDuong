package hust.soict.globalict.aims.utils;
import hust.soict.globalict.aims.order.Order;

public class DateUtils{
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
				if(compare(orderList[i].getDate(),orderList[j].getDate())) {
					Order temp;
					temp=orderList[i];
					orderList[i]=new Order(orderList[j]);
					orderList[j]=new Order(temp);
				}
			}
		}
	}
}
