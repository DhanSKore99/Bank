package org.cjc.librarymanagementsystem.app.serviceimpl;

import java.util.List;

import org.cjc.librarymanagementsystem.app.exception.AuthorNotfoundException;
import org.cjc.librarymanagementsystem.app.model.Book;
import org.cjc.librarymanagementsystem.app.repository.BookRepository;
import org.cjc.librarymanagementsystem.app.servicei.BookServiceI;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ch.qos.logback.classic.Logger;

@Service
public class BookServiceImpl implements BookServiceI {
	@Autowired
	BookRepository br;

	Logger logger = (Logger) LoggerFactory.getLogger(BookServiceImpl.class);

	@Override
	public Book saveBook(Book b) {
		return br.save(b);

	}

	@Override
	public List<Book> getBooks() {
		return br.findAll();
	}

	@Override
	public List<Book> findBooksByAuthorName(String authorName) {
		List<Book> blist = getBooks();
		for (Book b : blist) {
			if (b.getAuthorName() == authorName) {
				List<Book> booksByAuthor = br.findAllByAuthorName(authorName);
				logger.info("inside if condition..");
				return booksByAuthor;
			} else {
				logger.error("exception thrown");
				
				throw new AuthorNotfoundException("Author not found");
			}
			
		}
		return null;

	}

	@Override
	public Book findBookByTitle(String bookTitle) {
		List<Book> books = getBooks();
		Book book = br.findByBookTitle(bookTitle);
		return book;
		
	}

	/*
	 * @Override public Book findBookByISBNNumber(int ISBN_Number) { Book book =
	 * br.findByISBN_Number(ISBN_Number); return book; }
	 */
	
	

}
