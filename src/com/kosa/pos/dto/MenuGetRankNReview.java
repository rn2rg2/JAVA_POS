package com.kosa.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuGetRankNReview {
	private String menuName;
	private int totalOrders;
	private Double avgReview;
	private String Category;
}
