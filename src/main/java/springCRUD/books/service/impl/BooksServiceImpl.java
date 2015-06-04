package springCRUD.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springCRUD.books.dao.BooksDao;
import springCRUD.books.model.Book;
import springCRUD.books.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService{
	
	@Autowired
	private BooksDao booksDao;
	
	@Transactional(readOnly=true)
	public Book getBook(long id) {
		return booksDao.getBook(id);
	}

	@Transactional(readOnly=true)
	public List<Book> listBooks() {
		return booksDao.listBooks();
	}
	
	@Transactional
	public void deleteBook(long id) {
		booksDao.deleteBook(id);
	}

	//Create and Update
	@Transactional
	public void saveBook(Book book) {
		booksDao.saveBook(book);
	}

}
