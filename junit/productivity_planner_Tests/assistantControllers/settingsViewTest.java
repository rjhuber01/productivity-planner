package productivity_planner_Tests.assistantControllers;
import static org.junit.Assert.*;

import org.junit.Test;

import assistantControllers.settingsView;

public class settingsViewTest {

	@Test
	public void testGetAndSetColor() {
		settingsView settings = new settingsView();
		
		settings.setColor(1);
		assertTrue(settings.getColor() == 1);
	}
}
