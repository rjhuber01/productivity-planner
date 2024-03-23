package productivity_planner_Tests.assistantControllers;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import assistantControllers.calenderView;

public class calenderViewTest {
	private calenderView calenderView = new calenderView();
	private int displayView = 0;
		int day = 13;
		int dayOfWeek = 3;
		int month = 3;
		int year = 2024;
		
	
	@Test
	public void testGetAndSetDisplayView() {
		calenderView.setDisplayView(displayView);
		assertTrue(calenderView.getDisplayView() == 0);
	}
	@Test
	public void testGetAndSetDay() {
		calenderView.setDay(day);
		assertTrue(calenderView.getDay() == 13);
	}
	@Test
	public void testGetAndSetDayOfWeek() {
		calenderView.setDayOfWeek(dayOfWeek);
		assertTrue(calenderView.getDayOfWeek() == 3);
	}
	@Test
	public void testGetAndSetMonth() {
		calenderView.setMonth(month);
		assertTrue(calenderView.getMonth() == 3);
	}
	@Test
	public void testGetAndSetYear() {
		calenderView.setYear(year);
		assertTrue(calenderView.getMonth() == 2024);
	}
}
