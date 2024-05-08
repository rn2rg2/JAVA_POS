package com.kosa.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MenuStatsInfo {

	private String[] day = new String[7];
	private double[] values = new double[7];
}
