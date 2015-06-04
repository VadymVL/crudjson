package springCRUD.books.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springCRUD.books.dao.BooksDao;
import springCRUD.books.model.Book;

@Repository
public class BooksDaoImpl implements BooksDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private Session getSession() {
		Session session = getSessionFactory().getCurrentSession();
		if(session == null) {
			session = getSessionFactory().openSession();
		}
		return session;
	}
	
	public void saveBook(Book book) {
		getSession().merge(book);
	}

	public void deleteBook(long id) {
		Book book = getBook(id);
		if(null != book) {
			getSession().delete(book);
		}
	}

	public List<Book> listBooks() {
		return getSession().createCriteria(Book.class).list();
	}

	public Book getBook(long id) {
		return (Book) getSession().get(Book.class, id);
	}

}
