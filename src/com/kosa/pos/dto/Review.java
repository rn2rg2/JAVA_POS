package com.kosa.pos.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	private int reviewID;
	private String title;
	private String content;
	private int rating;
	private Date reviewDate;
	private int menuMenuID;
}
