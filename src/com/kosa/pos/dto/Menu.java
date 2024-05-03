package com.kosa.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
	private int menu_id;
	private String name;
	private int price;
	private String category;
	private String menu_desc;
	private String menu_path;
}
