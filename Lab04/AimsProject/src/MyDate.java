
public class MyDate {
	private String day;
	private String month;
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
	public void print() {
		String dayy;
		switch(this.day) {
		case "first":
			dayy="1th";
			break;
		case "second":
			dayy="2nd";
			break;
		case "third":
			dayy="3rd";
			break;
		case "fourth":
			dayy="4th";
			break;
		case "fifth":
			dayy="5th";
			break;
		case "sixth":
			dayy="6th";
			break;
		case "seventh":
			dayy="7th";
			break;
		case "eighth":
			dayy="8th";
			break;
		case "ninth":
			dayy="9th";
			break;
		case "tenth":
			dayy="10th";
			break;
		case "eleventh":
			dayy="11th";
			break;
		case "twelfth":
			dayy="12th";
			break;
		case "thirdteenth":
			dayy="13th";
			break;
		case "fourteenth":
			dayy="14th";
			break;
		case "fifteenth":
			dayy="15th";
			break;
		case "sixteenth":
			dayy="16th";
			break;
		case "seventeenth":
			dayy="17th";
			break;
		case "eighteenth":
			dayy="18th";
			break;
		case "ninteenth":
			dayy="19th";
			break;
		case "twentieth":
			dayy="20th";
			break;
		case "twenty first":
			dayy="21th";
			break;
		case "twenty second":
			dayy="22th";
			break;
		case "twenty third":
			dayy="23th";
			break;
		case "twenty fourth":
			dayy="24th";
			break;
		case "twenty fifth":
			dayy="25th";
			break;
		case "twenty sixth":
			dayy="26th";
			break;
		case "twenty seventh":
			dayy="27th";
			break;
		case "twenty eighth":
			dayy="28th";
			break;
		case "twentt ninth":
			dayy="29th";
			break;
		case "thirdtieth":
			dayy="30th";
			break;
		case "thirdtieth first":
			dayy="31th";
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
			break;
		case "February":
			monthh="Feb";
			break;
		case "March":
			monthh="Mar";
			break;
		case "April":
			monthh="Apr";
			break;
		case "May":
			monthh="May";
			break;
		case "June":
			monthh="Jun";
			break;
		case "July":
			monthh="Jul";
			break;
		case "August":
			monthh="Aug";
			break;
		case "September":
			monthh="Sep";
			break;
		case "October":
			monthh="Oct";
			break;
		case "November":
			monthh="Nov";
			break;
		case "December":
			monthh="Dec";
			break;
		default:
			monthh="";
			break;
		}
		System.out.println("Date: "+monthh+" "+dayy+" "+this.year);
	}
}
