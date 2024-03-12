package model;
import java.util.Date;


public class Task {
    private String taskName, taskDescription; 
    private int month, day, year, days, hours, minutes, timeUnit, expectedTime, folderID, color, frequency, rank, status;
    //private Date dueDate;

    private Date dueDate;

    public Task() {
        dueDate = new Date();
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
    }*/

    public Date getdueDate(){
        return dueDate;
        
    }

    // TODO: Fix date
    public void setTimeUnit(int timeUnit){
        this.timeUnit = timeUnit;
        //this.days = days;
        //this.hours = hours;
        //this.minutes = minutes;
    }

    public int getTimeUnit(){
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




}