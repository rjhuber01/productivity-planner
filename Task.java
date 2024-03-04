
public class Task {
    private String name, date; 
    private int month, day, year, color, rank, status;

    public Task() {

    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getDate(){
        return date;
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