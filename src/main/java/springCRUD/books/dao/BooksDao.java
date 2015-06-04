package springCRUD.books.dao;

import java.util.List;

import springCRUD.books.model.Book;

public interface BooksDao {
	//Create and Update
	public void saveBook(Book book);
	//Delete
	public void deleteBook(long id);
	//Read
	public List<Book> listBooks();
	public Book getBook(long id);
}
