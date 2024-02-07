package com.restTemplate.HotelService.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExcception {
	
	@ExceptionHandler(HotelNotFound.class)
	public ResponseEntity<?> hotelNotFound(HotelNotFound hotelNotFound,WebRequest request ){
		LocalDateTime dateTime =LocalDateTime.now();
		ErrorDetails details = new ErrorDetails(dateTime,hotelNotFound.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception exception,WebRequest request){
		LocalDateTime dateTime =LocalDateTime.now();
		ErrorDetails details = new ErrorDetails(dateTime,exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
