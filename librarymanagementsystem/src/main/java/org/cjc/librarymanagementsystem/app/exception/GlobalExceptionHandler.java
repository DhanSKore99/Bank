package org.cjc.librarymanagementsystem.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(AuthorNotfoundException.class)
	 public ResponseEntity<String>  AuthorNotfoundExceptionHandler(AuthorNotfoundException e){
		 return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	 }
}
