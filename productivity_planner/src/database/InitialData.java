package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import assistantModels.Task;
import assistantModels.actorAccount;

public class InitialData {

	// reads initial Author data from CSV file and returns a List of Authors
	public static List<actorAccount> getAccounts() throws IOException {
		List<actorAccount> accountList = new ArrayList<actorAccount>();
		ReadCSV readAccounts = new ReadCSV("Initial_Users.csv");
		try {
			// auto-generated primary key for authors table
			Integer accountId = 1;
			while (true) {
				List<String> tuple = readAccounts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				actorAccount account = new actorAccount();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				account.setAccountID(accountId++);				
				account.setFirstName(i.next());
				account.setLastName(i.next());
				account.setEmail(i.next());
				account.setSalt(i.next());
				account.setHashedPassword(i.next());
				accountList.add(account);
			}
			System.out.println("accountList loaded from CSV file");
			return accountList;
		} finally {
			readAccounts.close();
		}
	}
	
	// reads initial Book data from CSV file and returns a List of Books
	public static List<Task> getTasks() throws IOException {
		List<Task> taskList = new ArrayList<Task>();
		ReadCSV readTasks = new ReadCSV("Initial_Tasks.csv");
		try {
			// auto-generated primary key for table books
			Integer taskId = 1;
			while (true) {
				List<String> tuple = readTasks.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Task task = new Task();
				
				// read book ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file
				Integer.parseInt(i.next());
				// auto-generate book ID, instead
				task.setTaskID(taskId++);				
//				book.setAuthorId(Integer.parseInt(i.next()));  // no longer in books table
				task.setAccountID(Integer.parseInt(i.next()));
				task.setTaskName(i.next());
				task.setFolderID(Integer.parseInt(i.next()));
				task.setDueDate(i.next());
				task.setExpectedTime(Integer.parseInt(i.next()));
				task.setTimeUnit(i.next());
				task.setStatus(Integer.parseInt(i.next()));
				task.setRank(Integer.parseInt(i.next()));
				task.setTaskDescription(i.next());
				//needs a user id???
			}
			System.out.println("taskList loaded from CSV file");			
			return taskList;
		} finally {
			readTasks.close();
		}
	}
}