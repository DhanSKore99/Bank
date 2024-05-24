package org.cjc.librarymanagementsystem.app.servicei;

import java.util.List;

import org.cjc.librarymanagementsystem.app.model.Book;

public interface BookServiceI {

	Book saveBook(Book b);

	List<Book> getBooks();

	List<Book> findBooksByAuthorName(String authorName);

	Book findBookByTitle(String bookTitle);

	//Book findBookByISBNNumber(int ISBN_Number);

}
