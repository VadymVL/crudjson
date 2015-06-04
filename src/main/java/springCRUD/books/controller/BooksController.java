package springCRUD.books.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springCRUD.books.model.Book;
import springCRUD.books.service.BooksService;

@Controller
@RequestMapping("/book")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@RequestMapping(value = {"/", "/list"})
	public String listBooks(Map<String, Object> map) {
		map.put("book", new Book());
		map.put("listBooks", booksService.listBooks());
		return "/book/booksList";
	}
	
	@RequestMapping(value = {"/get/{bookId}", "/list/get/{bookId}"})
	public String getBook(@PathVariable long bookId, Map<String, Object> map) {
		map.put("book", booksService.getBook(bookId));
		return "/book/bookForm";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book, BindingResult result) {
		booksService.saveBook(book);
		return "redirect:list"; //there is no slash after the redirect. so we are in parent book/ path
	}
	
	@RequestMapping("delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") long id) {
		booksService.deleteBook(id);
		return "redirect:/book/list";//there IS a slash
	}
	
	@RequestMapping("/json/book/{id}")
	public @ResponseBody  
	 Book getJsonBook(@PathVariable long id) {
		return booksService.getBook(id);
	}
	
	@RequestMapping(value = "/json/list.json", headers="Accept=*/*", method=RequestMethod.GET)
	public @ResponseBody  
	 List<Book> getJsonBookList() {
		return booksService.listBooks();
	}
}
