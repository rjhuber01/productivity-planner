package assistantControllers;
import assistantModels.taskFolder;

public class dashboardView{
	private int taskFolderProportions;
	private Assistant assistant;
	private taskFolder folder;
	
	public dashboardView() {
		assistant = new Assistant();
	}
	
	private int classProportion(taskFolder folderName) {
		int numTasks = assistant.getNumTasksByFolder(folderName);
		int totalTasks = assistant.getAllTasks().size();
		return numTasks / totalTasks;
	}
	
}