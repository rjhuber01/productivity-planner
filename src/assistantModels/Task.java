package assistantModels;
import java.util.Date;


public class Task {
    private String taskName, taskDescription, folderName, dueDate, timeUnit;
	private int expectedTime, folderID, color, frequency, rank, status, taskID, accountID;
    //private Date dueDate;

    //private Date dueDate;

    public Task() {
        //dueDate = new Date();
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public String getTaskName(){
        return taskName;
    }

    public void setFolderID(int folderID){
        this.folderID = folderID;
    }

    public int getFolderID(){
        return folderID;
    }
    
    public void setFolderName(String folderName) {
    	this.folderName = folderName;
    }
    
    public String getFolderName() {
    	return folderName;
    }

    public void setExpectedTime(int expectedTime){
        this.expectedTime = expectedTime;
    }

    public int getExpectedTime(){
        return expectedTime;
    }

    // TODO: Fix date
    /* public Date setDueDate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    } */

    public void setDueDate(String dueDate) {
    	this.dueDate = dueDate;
    }
    
    public String getDueDate(){
        return dueDate;
    }

    // TODO: Fix date
    public void setTimeUnit(String timeUnit){
        this.timeUnit = timeUnit;
        //this.days = days;
        //this.hours = hours;
        //this.minutes = minutes;
    }

    public String getTimeUnit(){
        return timeUnit;
    }

    public void setColor(int color){
        this.color = color;
    }

    public int getColor(){
        return color;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public int getFrequency(){
        return frequency;
    }

    public int getRank(){
        return rank;
    }

    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription(){
        return taskDescription;
    }
    
    public int getTaskID() {
    	return taskID;
    }
    
    public void setTaskID(int taskID) {
    	this.taskID = taskID;
    }
    
    public void setAccountID(int accountID) {
    	this.accountID = accountID;
    }
    
    public int getAccountID() {
    	return taskID;
    }    
    
    public void updateTask(Task newTask) {
    	//Task Name & Due Date are always required so never null
    	if(newTask.getTaskName() != null) {
    		this.setTaskName(newTask.getTaskName());
    	}
    	
    	if(newTask.getFolderName() != null) {
    		this.setFolderName(newTask.getFolderName());
    	}
    	
    	if(newTask.getDueDate() != null) {
    		this.setDueDate(newTask.getDueDate());
    	}
    	
    	//DISCUSS: How do we handle this? 
    	if(newTask.getExpectedTime() != 0) {
    		this.setExpectedTime(newTask.getExpectedTime());
    	}
    	
    	if(newTask.getStatus() != 0) {
    		this.setStatus(newTask.getStatus());
    	}
    	
    	if(newTask.getTaskDescription() != null) {
    		this.setTaskDescription(newTask.getTaskDescription());
    	}
    	
    	//TODO: Add more fields as needed. 
    }
}