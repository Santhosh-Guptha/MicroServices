package com.ratingservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Rating_details")
public class Rating {
	@Id
	private int ratingId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;

}
