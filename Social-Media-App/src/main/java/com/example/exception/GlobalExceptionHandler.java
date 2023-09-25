package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionFormat> handlerNotFoundException(NoHandlerFoundException ex, WebRequest wr) {
		return new ResponseEntity<ExceptionFormat>(
				new ExceptionFormat(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ExceptionFormat> getUserException(UserException ex , WebRequest wr){
		return new ResponseEntity<ExceptionFormat>(
				new ExceptionFormat(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OtherException.class)
	public ResponseEntity<ExceptionFormat> getUserException(OtherException ex , WebRequest wr){
		return new ResponseEntity<ExceptionFormat>(
				new ExceptionFormat(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

}
