package assistantControllers;

import java.util.ArrayList;

import assistantModels.Task;
import assistantModels.actorAccount;
import assistantModels.taskFolder;


public class Assistant {
    private Assistant assistant;
    private actorAccount userAccount = new actorAccount();
    private taskFolder folder = new taskFolder();
    private ArrayList<Task> arrTask = new ArrayList<Task>();
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
    
    //DISCUSS: Get all tasks by a specific folderName. 
    public int getNumTasksByFolder(taskFolder folderName) {
    	int searchID = folderName.getFolderID();
    	int numTasks = 0;
    	for(int i = 0; i < arrTask.size(); i++) {
    		if(arrTask.get(i).getFolderID() == searchID) {
    			numTasks++;
    		}
    	}
    	return numTasks;
    }


    // TODO: fix user validation 
    /* public boolean validateUser() {
        if()
    
    } */
    
    public void setTask(String taskName, String taskFolder, String dueDate, int expectedTime, int status, String taskDescription) {
    	Task task = new Task();
    	task.setTaskName(taskName);
    	task.setFolderName(taskFolder);
    	task.setDueDate(dueDate);
    	task.setExpectedTime(expectedTime);
    	task.setStatus(status);
    	task.setTaskDescription(taskDescription);
    	arrTask.add(task);
    }
    
    public void setTask(String taskName, String taskDescription, int timeUnit, 
    int expectedTime, int color, int frequency, int rank, int status){
    	Task task = new Task();
        task.setTaskDescription(taskDescription);
        task.setTimeUnit(timeUnit);
        task.setColor(color);
        task.setFrequency(frequency);
        task.setTaskName(taskName);
        task.setRank(rank);
        task.setStatus(status);
        arrTask.add(task);
    }

    public Task getTask(int i){
        return arrTask.get(i);
    }

    public void deleteTask(int i){
        arrTask.remove(i);
    }





}  