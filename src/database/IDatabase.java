package database;

import java.util.List;

import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.booksdb.model.Book;
import edu.ycp.cs320.booksdb.model.Pair;

public interface IDatabase {
	public List<Pair<Author, Book>> findAuthorAndBookByTitle(String title);
	public List<Pair<Author, Book>> findAuthorAndBookByAuthorLastName(String lastName);
	public Integer insertBookIntoBooksTable(String title, String isbn, int published, String lastName, String firstName);
	public List<Pair<Author, Book>> findAllBooksWithAuthors();
	public List<Author> findAllAuthors();
	public List<Author> removeBookByTitle(String title);		
}
