package assistantControllers;
import assistantModels.Task;

public class pomodoroView{
	private int time;
	private Task task;
	private boolean restPeriod;
	
	public int setTime(int time) {
        return this.time = time;
    }

    public int getTime() {
        return time;
    }
    
    public void setCurrentTask (Task inputTask) {
    	this.task = inputTask;
    }
    
    public void setRestPeriod(boolean restPeriod) {
    	this.restPeriod = restPeriod;
    }
    
    public boolean getRestPeriod() {
    	return restPeriod;
    }
}