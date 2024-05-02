package com.kosa.pos.swing.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

public class Menu extends JPanel {
	/**
	 * @wbp.nonvisual location=418,41
	 */

	/**
	 * Create the panel.
	 */
	public Menu() {

		// 메뉴 패널의 크기를 인덱스 패널과 동일하게 설정

		setPreferredSize(new Dimension(900, 650));
		setLayout(null);
		 MenuScrollPanel menuScrollPanel = new MenuScrollPanel();
		menuScrollPanel.setBounds(22, 88, 726, 556);

		// Menu 패널에 MenuScrollPanel 추가
		add(menuScrollPanel);

	}
}
