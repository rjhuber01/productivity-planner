package model;
public class taskFolder {
    private String folderName;
    private int folderID;

    public taskFolder(){

    }

    public void setFolderName(String folderName){
        this.folderName = folderName;
    }

    public String getFolderName(){
        return folderName;
    }

    public void setFolderID(int folderID){
        this.folderID = folderID;
    }

    public int getFolderID(){
        return folderID;
    }
}
