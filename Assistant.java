import java.util.ArrayList;


public class Assistant {
    private Assistant assistant;
    private actorAccount userAccount = new actorAccount();
    private taskFolder folder = new taskFolder();
    private ArrayList<Task> arrTask = new ArrayList<Task>();
    private int i;
    private final String DEFAULTFOLDER = "AllTasks";
    
    public void setAssistant(Assistant assistant){
        this.assistant = assistant;
    }

    public Assistant getAssistant(){
        return assistant;
    }

    public actorAccount getActorAccount(){
        return userAccount;
    }

    public void setTaskFolder(String folderName, int folderID){
        folder.setFolderName(folderName);
        folder.setFolderID(folderID);
    }

    public taskFolder getTaskFolder(){
        if ( folder == null ) {
            setTaskFolder(DEFAULTFOLDER, 0);
        }
        return folder;
    }

    public ArrayList<Task> getAllTasks(){
        return arrTask;
    }


    // TODO: fix user validation 
    public boolean validateUser() {
        if()
    
    }

    public void setTask(String taskName, String taskDescription, int timeUnit, 
    int expectedTime, int color, int frequency, int rank, int status){
        arrTask.get(i).setTaskDescription(taskDescription);
        arrTask.get(i).setTimeUnit(timeUnit);
        arrTask.get(i).setColor(color);
        arrTask.get(i).setFrequency(frequency);
        arrTask.get(i).setTaskName(taskName);
        arrTask.get(i).setRank(rank);
        arrTask.get(i).setStatus(status);

    }

    public Task getTask(){
        return arrTask.get(i);
    }

    public void deleteTask(int index){
        index = i;
        arrTask.remove(index);
    }





}  