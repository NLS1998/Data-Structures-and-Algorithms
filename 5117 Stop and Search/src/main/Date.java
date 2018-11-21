package main;

public class Date {
	private int year;
	private int month;
	private int day;
	
	private int hour;
	private int minutes;
	private int seconds;
	
	public Date(String dateStr) {
		this.year = Integer.valueOf(dateStr.substring(0,4));
		this.month = Integer.valueOf(dateStr.substring(5,7));
		this.day = Integer.valueOf(dateStr.substring(8,10));
		
		this.hour = Integer.valueOf(dateStr.substring(11,13));
		this.minutes = Integer.valueOf(dateStr.substring(14,16)); // + 20,21
		this.seconds = Integer.valueOf(dateStr.substring(17,19)); // + 23,24
		
//		Print Date's Data when created
//		System.out.println(dateStr);
//		this.dateToString();
		
	}
	
	public void dateToString() {
		System.out.printf("%02d:%02d:%02d - %02d/%02d/%d \n \n",this.hour, this.minutes, this.seconds, this.day, this.month, this.year);
	}
	
	// GETTERS AND SETTERS
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}
