package hust.soict.globalict.aims.utils;
public class MyDate {
	private String day;
	private int dayNo;
	private String month;
	private int monthNo;
	private String year;
	public MyDate(String day, String month, String year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String getDay() {
		return day;
	}
	public String getMonth() {
		return month;
	}
	public String getYear() {
		return year;
	}
	public int getDayNo() {
		return dayNo;
	}
	public int getMonthNo() {
		return monthNo;
	}
	public void print() {
		String dayy;
		switch(this.day) {
		case "first":
			dayy="1th";
			this.dayNo=1;
			break;
		case "second":
			dayy="2nd";
			this.dayNo=2;
			break;
		case "third":
			dayy="3rd";
			this.dayNo=3;
			break;
		case "fourth":
			dayy="4th";
			this.dayNo=4;
			break;
		case "fifth":
			dayy="5th";
			this.dayNo=5;
			break;
		case "sixth":
			dayy="6th";
			this.dayNo=6;
			break;
		case "seventh":
			dayy="7th";
			this.dayNo=7;
			break;
		case "eighth":
			dayy="8th";
			this.dayNo=8;
			break;
		case "ninth":
			dayy="9th";
			this.dayNo=9;
			break;
		case "tenth":
			dayy="10th";
			this.dayNo=10;
			break;
		case "eleventh":
			dayy="11th";
			this.dayNo=11;
			break;
		case "twelfth":
			dayy="12th";
			this.dayNo=12;
			break;
		case "thirdteenth":
			dayy="13th";
			this.dayNo=13;
			break;
		case "fourteenth":
			dayy="14th";
			this.dayNo=14;
			break;
		case "fifteenth":
			dayy="15th";
			this.dayNo=15;
			break;
		case "sixteenth":
			dayy="16th";
			this.dayNo=16;
			break;
		case "seventeenth":
			dayy="17th";
			this.dayNo=17;
			break;
		case "eighteenth":
			dayy="18th";
			this.dayNo=18;
			break;
		case "ninteenth":
			dayy="19th";
			this.dayNo=19;
			break;
		case "twentieth":
			dayy="20th";
			this.dayNo=20;
			break;
		case "twenty first":
			dayy="21th";
			this.dayNo=21;
			break;
		case "twenty second":
			dayy="22th";
			this.dayNo=22;
			break;
		case "twenty third":
			dayy="23th";
			this.dayNo=23;
			break;
		case "twenty fourth":
			dayy="24th";
			this.dayNo=24;
			break;
		case "twenty fifth":
			dayy="25th";
			this.dayNo=25;
			break;
		case "twenty sixth":
			dayy="26th";
			this.dayNo=26;
			break;
		case "twenty seventh":
			dayy="27th";
			this.dayNo=27;
			break;
		case "twenty eighth":
			dayy="28th";
			this.dayNo=28;
			break;
		case "twentt ninth":
			dayy="29th";
			this.dayNo=29;
			break;
		case "thirdtieth":
			dayy="30th";
			this.dayNo=30;
			break;
		case "thirdtieth first":
			dayy="31th";
			this.dayNo=31;
			break;
		default:
			dayy="";
			break;
		}
		System.out.println("Date: "+this.month+" "+dayy+" "+this.year);
	}
	public void print2() {
		int dayy;
		switch(this.day) {
		case "first":
			dayy=1;
			break;
		case "second":
			dayy=2;
			break;
		case "third":
			dayy=3;
			break;
		case "fourth":
			dayy=4;
			break;
		case "fifth":
			dayy=5;
			break;
		case "sixth":
			dayy=6;
			break;
		case "seventh":
			dayy=7;
			break;
		case "eighth":
			dayy=8;
			break;
		case "ninth":
			dayy=9;
			break;
		case "tenth":
			dayy=10;
			break;
		case "eleventh":
			dayy=11;
			break;
		case "twelfth":
			dayy=12;
			break;
		case "thirdteenth":
			dayy=13;
			break;
		case "fourteenth":
			dayy=14;
			break;
		case "fifteenth":
			dayy=15;
			break;
		case "sixteenth":
			dayy=16;
			break;
		case "seventeenth":
			dayy=17;
			break;
		case "eighteenth":
			dayy=18;
			break;
		case "ninteenth":
			dayy=19;
			break;
		case "twentieth":
			dayy=20;
			break;
		case "twenty first":
			dayy=21;
			break;
		case "twenty second":
			dayy=22;
			break;
		case "twenty third":
			dayy=23;
			break;
		case "twenty fourth":
			dayy=24;
			break;
		case "twenty fifth":
			dayy=25;
			break;
		case "twenty sixth":
			dayy=26;
			break;
		case "twenty seventh":
			dayy=27;
			break;
		case "twenty eighth":
			dayy=28;
			break;
		case "twentt ninth":
			dayy=29;
			break;
		case "thirdtieth":
			dayy=30;
			break;
		case "thirdtieth first":
			dayy=31;
			break;
		default:
			dayy=0;
			break;
		}
		String monthh="";
		switch(this.month) {
		case "January":
			monthh="Jan";
			this.monthNo=1;
			break;
		case "February":
			monthh="Feb";
			this.monthNo=2;
			break;
		case "March":
			monthh="Mar";
			this.monthNo=3;
			break;
		case "April":
			monthh="Apr";
			this.monthNo=4;
			break;
		case "May":
			monthh="May";
			this.monthNo=5;
			break;
		case "June":
			monthh="Jun";
			this.monthNo=6;
			break;
		case "July":
			monthh="Jul";
			this.monthNo=7;
			break;
		case "August":
			monthh="Aug";
			this.monthNo=8;
			break;
		case "September":
			monthh="Sep";
			this.monthNo=9;
			break;
		case "October":
			monthh="Oct";
			this.monthNo=10;
			break;
		case "November":
			monthh="Nov";
			this.monthNo=11;
			break;
		case "December":
			monthh="Dec";
			this.monthNo=12;
			break;
		default:
			monthh="";
			break;
		}
		System.out.println("Date: "+monthh+" "+dayy+" "+this.year);
	}
}