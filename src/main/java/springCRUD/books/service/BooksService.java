package springCRUD.books.service;

import java.util.List;

import springCRUD.books.model.Book;

public interface BooksService {
	//Read
	public Book getBook(long id);
	
	public List<Book> listBooks();
	
	//Delete
	public void deleteBook(long id);
	
	//Create and Update
	public void saveBook(Book book);
	
}
