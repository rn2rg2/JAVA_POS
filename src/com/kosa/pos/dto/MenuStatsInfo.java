package com.kosa.pos.dto;

import lombok.Data;

@Data
public class MenuStatsInfo {

	private String[] day = new String[7];
	private double[] values = new double[7];
}
