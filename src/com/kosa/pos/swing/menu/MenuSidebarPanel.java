package com.kosa.pos.swing.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuSidebarPanel extends JPanel {
	private JLabel side_name;
	private JLabel side_num;
	private JLabel side_check;

	/**
	 * Create the panel.
	 */
	public MenuSidebarPanel() {
		setLayout(null);

		side_name = new JLabel("햄버거거거");
		side_name.setHorizontalAlignment(SwingConstants.LEFT);
		side_name.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		side_name.setBounds(0, 6, 74, 37);
		add(side_name);

		side_num = new JLabel("N개");
		side_num.setBounds(70, 7, 28, 37);
		add(side_num);

		side_check = new JLabel("200000");
		side_check.setHorizontalAlignment(SwingConstants.LEFT);
		side_check.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		side_check.setBounds(100, 6, 74, 37);
		add(side_check);

		setPreferredSize(new Dimension(180, 50));

	}

	public void updateSidebar(int count, String menuname, int price) {
		System.out.println("update눌림");
		side_name.setText(menuname);
		side_num.setText(count + "개");
		// 가격 계산 로직에 따라 side_check 값을 변경
		// 예를 들어, 햄버거 1개당 2000원이라면
		side_check.setText((price * count ) + "");
		System.out.println("menuname : " + side_name.getText()+" menu_num : "+ side_num.getText() + " menu_check: " + side_check.getText());
	}
	public void updateSidebarminus(int count, int price) {
		side_num.setText(count + "개");
		side_check.setText(price + "원");
	}
}
