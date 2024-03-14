package assistantControllers;

import static org.junit.Assert.*;

import org.junit.Test;

import assistantModels.Task;

public class pomodoroViewTest {

	@Test
	public void testGetAndSetTime() {
		pomodoroView pomo = new pomodoroView();
		int time = 1;
		
		pomo.setTime(time);
		assertTrue(pomo.getTime() == 1);
	}
	@Test
	public void testGetAndSetCurrentTask() {
		pomodoroView pomo = new pomodoroView();
		Task inputTask = new Task();
		
		pomo.setCurrentTask(inputTask);
		assertTrue(pomo.getCurrentTask() == inputTask);
	}
	@Test
	public void testGetAndSetRestPeriod() {
		pomodoroView pomo = new pomodoroView();
		boolean restPeriod = true;
		
		pomo.setRestPeriod(restPeriod);
		assertTrue(pomo.getRestPeriod() == true);
	}
}
