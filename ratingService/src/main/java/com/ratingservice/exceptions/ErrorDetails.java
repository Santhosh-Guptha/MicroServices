package com.ratingservice.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	
	
	private LocalDateTime dateTime;
	private String error;
	private String details;

}
