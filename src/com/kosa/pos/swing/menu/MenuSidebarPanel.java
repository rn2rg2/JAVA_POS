package com.kosa.pos.swing.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuSidebarPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuSidebarPanel() {
		setLayout(null);
		
		JLabel side_name = new JLabel("햄버거거거");
		side_name.setHorizontalAlignment(SwingConstants.CENTER);
		side_name.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		side_name.setBounds(6, 6, 74, 37);
		add(side_name);
		
		JLabel side_num = new JLabel("N개");
		side_num.setBounds(86, 7, 28, 37);
		add(side_num);
		
		JLabel side_check = new JLabel("200000");
		side_check.setHorizontalAlignment(SwingConstants.CENTER);
		side_check.setBounds(110, 7, 74, 37);
		add(side_check);
			
		setPreferredSize(new Dimension(180, 50));
	}

}
