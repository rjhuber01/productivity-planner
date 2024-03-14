package assistantControllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class calenderViewTest {
	private calenderView calenderView = new calenderView();{
	private int displayView = 0;
		int day = 13;
		int dayOfWeek = 3;
		int month = 3;
		int year = 2024;
		
	
	@Test
	public void testSetDisplayView() {
		calenderView.setDisplayView(displayView);
		assertTrue(calenderView.getDisplayView() == 0);
	}
	@Test
	public void testGetDisplayView() {
		calenderView.setDisplayView(1);
		assertTrue(calenderView.getDisplayView() == 1);
	}
	@Test
	public void testSetDay() {
		calenderView.setDay(day);
		assertTrue(calenderView.getDay() == 13);
	}
	@Test
	public void testGetDay() {
		calenderView.setDay(3);
		assertTrue(calenderView.getDay() == 13);
	}
	@Test
	public void testSetDayOfWeek() {
		calenderView.setDayOfWeek(3);
		assertTrue(calenderView.getDayOfWeek() == 3);
	}
	@Test
	public void testGetDayOfWeek() {
		calenderView.setDayOfWeek(dayOfWeek);
		assertTrue(calenderView.getDayOfWeek() == 3);
	}
	@Test
	public void testSetMonth() {
		calenderView.setMonth(3);
		assertTrue(calenderView.getMonth() == 3);
	}
	@Test
	public void testGetMonth() {
		calenderView.setMonth(month);
		assertTrue(calenderView.getMonth() == 3);
	}
	@Test
	public void testSetyear() {
		calenderView.setYear(2024);
		assertTrue(calenderView.getMonth() == 2024);
	}
	@Test
	public void testGetYear() {
		calenderView.setYear(year);
		assertTrue(calenderView.getMonth() == 2024);
	}
}
