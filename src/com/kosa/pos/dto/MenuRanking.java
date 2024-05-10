package com.kosa.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRanking {
	private String menuName;
	private int total_order;
	private double total_percentage;
}
