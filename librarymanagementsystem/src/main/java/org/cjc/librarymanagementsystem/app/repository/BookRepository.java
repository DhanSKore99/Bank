package org.cjc.librarymanagementsystem.app.repository;

import java.util.List;

import org.cjc.librarymanagementsystem.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findAllByAuthorName(String authorName);

	
	Book findByBookTitle(String bookTitle);

	//Book findByISBN_Number(int ISBN_Number);

}
