import java.time.LocalDate;


public class Task {
    private String taskName, ; 
    private int month, day, year, expectedTime, dueDate, folderID, color, rank, status;

    public Task() {

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

    public void setDueDate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int  getdueDate(){
        LocalDate.getMonthValue(int month);
        
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

    public int getRank(){
        return rank;
    }




}