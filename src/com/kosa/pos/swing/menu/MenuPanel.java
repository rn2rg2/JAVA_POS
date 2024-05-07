package com.kosa.pos.swing.menu;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	 public MenuPanel(String menuname) {
		setLayout(null);
		
		System.out.println(menuname);
		JButton menu_minus = new JButton("New button");
		menu_minus.setBounds(0, 197, 77, 29);
		add(menu_minus);
		
		JLabel menu_name = new JLabel(menuname);
		menu_name.setHorizontalAlignment(SwingConstants.CENTER);
		menu_name.setBounds(0, 168, 170, 29);
		add(menu_name);
		
		JLabel menu_img = new JLabel("New label");
		menu_img.setHorizontalAlignment(SwingConstants.CENTER);
		menu_img.setBounds(0, 0, 170, 156);
		add(menu_img);
		
		
		JButton menu_plus = new JButton("New button");
		menu_plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuSidebarPanel msbp = new MenuSidebarPanel();
		        //msbpport.add(msbp); 
			}
		});
		menu_plus.setBounds(89, 197, 77, 29);
		add(menu_plus);
		
		
		setPreferredSize(new Dimension(170, 230));
	    }
}
