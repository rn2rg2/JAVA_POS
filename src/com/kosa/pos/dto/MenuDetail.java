package com.kosa.pos.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDetail {
	private int menu_id;
	private String name;
	private int price;
	private String category;
	private String menu_desc;
	
	private int count;
	private double avgScore;
	
	private List<Review> reviewList;
	
	public MenuDetail(int menuID, String name, int price, String category,
			String menuDesc) {
		this.menu_id = menuID;
		this.name = name;
		this.price = price;
		this.category = category;
		this.menu_desc = menuDesc;
	}
}
