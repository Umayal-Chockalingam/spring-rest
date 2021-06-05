package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springdemo.entity.errorSO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<errorSO> exceptionHandlingMethod(StudentNotFoundException stuException){
	 
		errorSO so = new errorSO();
		so.setErrorCode(HttpStatus.NOT_FOUND.value());
		so.setErrorMessage(stuException.getMessage());
		so.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(so ,HttpStatus.NOT_FOUND );

	}

	@ExceptionHandler
	public ResponseEntity<errorSO> exceptionHandlingMethod(Exception exception){
		
		errorSO so = new errorSO();
		so.setErrorCode(HttpStatus.BAD_REQUEST.value());
		so.setErrorMessage(exception.getMessage());
		so.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(so ,HttpStatus.BAD_REQUEST );
		
	}
	
	
}
