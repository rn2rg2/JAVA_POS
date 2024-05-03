package com.kosa.pos.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_infoDTO {
	private int user_id;
	private int phonenum;
	private Date join_date;
	private int point;
	private int status;
}
