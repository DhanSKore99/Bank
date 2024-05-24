package org.cjc.librarymanagementsystem.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
@Entity
public class Library {
	@Id
	private int libraryId;
	@OneToMany
	private List<Book> books;

}
