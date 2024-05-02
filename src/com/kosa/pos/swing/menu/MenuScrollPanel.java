package com.kosa.pos.swing.menu;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;

public class MenuScrollPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuScrollPanel() {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBounds(6, 88, 726, 556);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
	}

}
