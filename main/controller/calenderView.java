package controller;
import java.util.Date;

public class calenderView {
	private int displayView;
	private int day;
	private int dayOfWeek;
	private int month;
	private int year;
	
	Date currentDate = new Date();
	
	public int getDisplayView() {
        return displayView;
    }

    public void setDisplayView(int displayView) {
        this.displayView = displayView;
    }

    public int getDay() {
        return day;
    }

	public void setDay(int day) {
        day = currentDate.getDate();
    }

    public int getDayOfWeek() {
        return day;
    }

    public void setDayOfWeek(int dayOfWeek) {
    	dayOfWeek = currentDate.getDay();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        month = currentDate.getMonth();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        year = currentDate.getYear();
    }
}