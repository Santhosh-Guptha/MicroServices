package com.restTemplate.HotelService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hotel_details")
public class Hotel {
	
	@Id
	@Column(name="Hotel_ID")
	private int id;
	private String name;
	private String location;
	
}
