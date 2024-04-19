package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assistantModels.Task;
import assistantModels.actorAccount;
import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.booksdb.model.Book;
import edu.ycp.cs320.booksdb.model.BookAuthor;
import edu.ycp.cs320.booksdb.model.Pair;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	
	// transaction that all a users tasks, then sorts by due date
	@Override
	public List<Task> getTasksSortByDueDate(final int accountID) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Task> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select tasks.* " +
							"  from  tasks"
							+ "join accounts " +
							"  where accounts.account_id = ?"
							+ " and accounts.account_id = tasks.account_id " +
							"    sort by tasks.duedate asc"
					);
					stmt.setInt(1, accountID);
					
					List<Task> result = new ArrayList<Task>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Task task = new Task();
						loadTask(task, resultSet, 1);
						
						result.add(new Task(task));
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("No tasks for that user");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	public List<Task> getTasksSortByFolder(final int accountID) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Task> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select tasks.* " +
							"  from  tasks"
							+ "join accounts " +
							"  where accounts.account_id = ? " +
							"    and accounts.account_id = tasks.account_id " +
							"    sort by folder_id asc"
					);
					stmt.setInt(1, accountID);
					
					List<Task> result = new ArrayList<Task>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Task task = new Task();
						loadTask(task, resultSet, 1);
						
						result.add(new Task(task));
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("No tasks for that user");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public List<Task> getTasksSortByStatus(final int accountID) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Task> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select tasks.* " +
							"  from  tasks"
							+ "join accounts " +
							"  where accounts.account_id = ? " +
							"    and accounts.account_id = tasks.account_id " +
							"    sort by tasks.status asc"
					);
					stmt.setInt(1, accountID);
					
					List<Task> result = new ArrayList<Task>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Task task = new Task();
						loadTask(task, resultSet, 1);
						
						result.add(new Task(task));
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("No tasks for that user");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	public List<Task> getTasksSortByRank(final int accountID) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Task> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select tasks.* " +
							"  from  tasks"
							+ "join accounts " +
							"  where accounts.account_id = ? " +
							"    and accounts.account_id = tasks.account_id " +
							"    sort by tasks.rank asc"
					);
					stmt.setInt(1, accountID);
					
					List<Task> result = new ArrayList<Task>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Task task = new Task();
						loadTask(task, resultSet, 1);
						
						result.add(new Task(task));
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("No tasks for that user");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}	
	
	// transaction that inserts new Book into the Books table
	// also first inserts new Author into Authors table, if necessary
	// and then inserts entry into BookAuthors junction table
	@Override
	public void insertTaskIntoTasksTable(final int accountID, 
			final String name, final int folderID, final String dueDate, final int expectedTime, final String timeUnit, final int status, final int rank, final String description) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;		
				
				ResultSet resultSet = null;			

					// now insert new Book into Books table
					// prepare SQL insert statement to add new Book to Books table
					stmt1 = conn.prepareStatement(
							"insert into tasks (account_id, name, folder_id, duedate, expectedtime, timeunit, status, rank, description) " +
							"  values(?, ?, ?, ?, ?, ?, ?, ?, ?) "
					);
					stmt1.setInt(1, accountID);
					stmt1.setString(2, name);
					stmt1.setInt(3, folderID);
					stmt1.setString(4, dueDate);
					stmt1.setInt(5, expectedTime);
					stmt1.setString(6, timeUnit);
					stmt1.setInt(7, status);
					stmt1.setInt(8, rank);
					stmt1.setString(9, description);
					
					// execute the update
					stmt1.executeUpdate();
					
					System.out.println("New task <" + name + "> inserted into Tasks table");					
					
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt1);
				}
			}
		});
		
		public void insertAccountIntoAccountsTable(final String firstName, 
				final String lastName, final String email, final int salt, final String hashedPass) {
			return executeTransaction(new Transaction<Integer>() {
				@Override
				public Integer execute(Connection conn) throws SQLException {
					PreparedStatement stmt1 = null;		
			
					ResultSet resultSet = null;			

				// now insert new Book into Books table
				// prepare SQL insert statement to add new Book to Books table
				stmt1 = conn.prepareStatement(
						"insert into accounts (firstname, lastname, email, salt, hashedpass) " +
						"  values(?, ?, ?, ?, ?, ?, ?, ?, ?) "
				);
				stmt1.setString(1, firstName);
				stmt1.setString(2, lastName);
				stmt1.setString(3, email);
				stmt1.setString(4, salt);
				stmt1.setString(5, hashedPass);
				
				// execute the update
				stmt1.executeUpdate();
				
				System.out.println("New account <" + email + "> inserted into Accounts table");					

				
			} finally {
				DBUtil.closeQuietly(resultSet);
				DBUtil.closeQuietly(stmt1);
			}
		}
	});
}
	
	// transaction that deletes Book (and possibly its Author) from Library
	// TODO: Change to removeTaskByName
	@Override
	public List<Task> removeTaskByName(final String name, final int accountID) {
		return executeTransaction(new Transaction<List<Author>>() {
			@Override
			public List<Task> execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;							
				
				ResultSet resultSet1    = null;			
				ResultSet resultSet2    = null;
				ResultSet resultSet5    = null;
										
					// now get the Book(s) to be deleted
					// we will need the book_id to remove associated entries in BookAuthors (junction table)
				
					stmt1 = conn.prepareStatement(
							"select tasks.* " +
							"  from  tasks " +
							"  where name = ?"
							+ "and account_id = ? "
					);
					
					// get the Book(s)
					stmt1.setString(1, name);
					resultSet = stmt1.executeQuery();
					
					// assemble list of Tasks from query
					List<Task> tasks = new ArrayList<Task>();					
				
					while (resultSet.next()) {
						Task task = new Task();
						loadTask(task, resultSet2, 1);
						tasks.add(task);
					}								
					
					// now delete entries in Books table for this title
					stmt2 = conn.prepareStatement(
							"delete from tasks " +
							"  where name = ? "
					);
					
					// delete the Book entries from the DB for this title
					stmt2.setString(1, name);
					stmt2.executeUpdate();
					
					System.out.println("Deleted tasks(s) with name <" + name + "> from DB");									
					return tasks;
				} finally {
					DBUtil.closeQuietly(resultSet);
					
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);					
				}
			}
		});
	}
	
	
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you name and specify the location of your Derby SQL database
	// TODO: Change it here and in SQLDemo.java under CS320_LibraryExample_Lab06->edu.ycp.cs320.sqldemo
	// TODO: DO NOT PUT THE DB IN THE SAME FOLDER AS YOUR PROJECT - that will cause conflicts later w/Git
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/CS320-2023-LibraryExample-DB/library.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// retrieves Author information from query result set
	private void loadAccount(actorAccount account, ResultSet resultSet, int index) throws SQLException {
		account.setAccountID(resultSet.getInt(index++));
		account.setFirstName(resultSet.getString(index++));
		account.setLastName(resultSet.getString(index++));
		account.setEmail(resultSet.getString(index++));
		account.setSalt(resultSet.getString(index++));
		account.setHashedPassword(resultSet.getString(index++));
	}
	
	// retrieves Book information from query result set
	private void loadTask(Task task, ResultSet resultSet, int index) throws SQLException {
		task.setTaskID(resultSet.getInt(index++));
		task.setAccountID(resultSet.getInt(index++));
		task.setTaskName(resultSet.getString(index++));
		task.setFolderID(resultSet.getInt(index++));
		task.setDueDate(resultSet.getString(index++));
		task.setExpectedTime(resultSet.getInt(index++));
		task.setTimeUnit(resultSet.getString(index++));
		task.setStatus(resultSet.getInt(index++));
		task.setRank(resultSet.getInt(index++));
		task.setTaskDescription(resultSet.getString(index++));
		
	}
	
	//  creates the Authors and Books tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;			
			
				try {
					stmt1 = conn.prepareStatement(
						"create table accounts (" +
						"	account_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	firstname varchar(40)," +
						"	lastname varchar(40)" +
						"   email varchat(40)" +
						"   salt varchar(40)" +
						"   hashedpass varchat(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("Accounts table created");
					
					stmt2 = conn.prepareStatement(
							"create table tasks (" +
							"	task_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
//							"	author_id integer constraint author_id references authors, " +  	// this is now in the BookAuthors table
							"	name varchar(70)," +
							"	folder_id integer," +
							"   duedate varchar(40)"
							+ " expectedtime integer"
							+ " timeunite varchar(40)"
							+ " status integer"
							+ " rank integer"
							+ " description varchar(100)"
							+ " account_id integer" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Tasks table created");									
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<actorAccount> accountList;
				List<Task> taskList;
				
				try {
					accountList     = InitialData.getAccounts();
					taskList       = InitialData.getTasks();			
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertAccount     = null;
				PreparedStatement insertTask       = null;

				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					insertAccount = conn.prepareStatement("insert into accounts (firstname, lastname, email, salt, hashedpassword) values (?, ?, ?, ?, ?)");
					for (actorAccount account : accountList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertAccount.setString(1, account.getFirstName());
						insertAccount.setString(2, account.getLastName());
						insertAccount.setString(3, account.getEmail());
						insertAccount.setString(4, account.getSalt());
						insertAccount.setString(5, account.getHashedPassword());
						insertAccount.addBatch();
					}
					insertAccount.executeBatch();
					
					System.out.println("Accounts table populated");
					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertTask = conn.prepareStatement("insert into tasks (account_id, name, folder_id, duedate, expectedtime, timeunit, status, rank, description) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					for (Task task : taskList) {
//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
//						insertBook.setInt(1, book.getAuthorId());	// this is now in the BookAuthors table
						insertTask.setInt(1, task.getAccountID());
						insertTask.setString(2, task.getTaskName());
						insertTask.setInt(3, task.getFolderID());
						insertTask.setString(4, task.getDueDate());
						insertTask.setInt(5, task.getExpectedTime());
						insertTask.setString(6, task.getTimeUnit());
						insertTask.setInt(7,  task.getStatus());
						insertTask.setInt(8, task.getRank());
						insertTask.setString(9, task.getTaskDescription());
						

						insertTask.addBatch();
					}
					insertTask.executeBatch();
					
					System.out.println("Task table populated");					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertAccount);
					DBUtil.closeQuietly(insertTask);				
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Library DB successfully initialized!");
	}
}
