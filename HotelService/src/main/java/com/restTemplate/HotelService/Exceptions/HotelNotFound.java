package com.restTemplate.HotelService.Exceptions;

public class HotelNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HotelNotFound() {
		super("Hotel not found in database.....");
	}
	
	public HotelNotFound(String message) {
		super(message);
	}
}
