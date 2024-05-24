package org.cjc.librarymanagementsystem.app.controller;

import java.util.List;

import org.cjc.librarymanagementsystem.app.model.Book;
import org.cjc.librarymanagementsystem.app.servicei.BookServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookServiceI bsi;

	Logger logger = LoggerFactory.getLogger(BookController.class);

	@PostMapping("/saveBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book b) {
		Book book = bsi.saveBook(b);
		if (book.getIsbnNumber() > 1) {
			logger.info("Book added to the library");
		} else {
			logger.info("couldnot add book to the library");
		}
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bsi.getBooks();
		logger.info("List of All books is returned.");
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@GetMapping("/getBooksByAuthorName/{authorName}")
	public ResponseEntity<List<Book>> findBooksByAuthorName(@PathVariable String authorName) {
		List<Book> booksByAuthor = bsi.findBooksByAuthorName(authorName);
		if (booksByAuthor.isEmpty()) {
			logger.info("No books Available..");
			return new ResponseEntity<List<Book>>(booksByAuthor, HttpStatus.NOT_FOUND);
		} else {
			logger.info("Books list is returned.");
			return new ResponseEntity<List<Book>>(booksByAuthor, HttpStatus.OK);
		}
	}
	
	/*
	 * @GetMapping("/getBookByISBN/{ISBN_Number}") public ResponseEntity<Book>
	 * findBookByISBNNumber(@PathVariable int ISBN_Number){ Book book =
	 * bsi.findBookByISBNNumber(ISBN_Number); return new ResponseEntity<Book>(book,
	 * HttpStatus.OK); }
	 */
	
	@GetMapping("getBookByTitle/{bookTitle}")
	public ResponseEntity<Book> findBookByTitle(@PathVariable String bookTitle){
		Book book = bsi.findBookByTitle(bookTitle);
		if(book!=null) {
		logger.info("Book with Title "+ bookTitle +" is found");
		return new ResponseEntity<Book>(book,HttpStatus.OK);
		}else {
			logger.info("Book with title " + bookTitle +"is Not available");
			return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
		}
		
	}

}
