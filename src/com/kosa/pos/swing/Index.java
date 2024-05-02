package com.kosa.pos.swing;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private JPanel menu_basket;
	private JPanel panel_2;
	private JPanel menu_scroll_frame;
	private JPanel menu_frame;
	private JPanel panel_4;
	private JButton delete_menubasket;
	private JButton fundallmenu;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel menu_img;
	private JButton menu_plus;
	private JButton menu_minus;
	private JPanel menu_detail;
	private JPanel menu_category;
	private JButton menu_category1;
	private JButton menu_category2;
	private JButton menu_category3;
	private JButton menu_category4;
	private JButton menu_category5;
	private JPanel menu_data;
	private JPanel menu_name;
	private JButton manager_btn;

	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		menu_scroll_frame = new JPanel();
		menu_scroll_frame.setAutoscrolls(true);
		
		menu_basket = new JPanel();
		
		panel_2 = new JPanel();
		
		panel_4 = new JPanel();
		panel_4.setLayout(new CardLayout(0, 0));
		
		menu_category = new JPanel();
		
		menu_data = new JPanel();
		
		manager_btn = new JButton("관리자 페이지");
		manager_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(menu_category, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(menu_scroll_frame, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
						.addComponent(menu_data, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(manager_btn, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(menu_basket, GroupLayout.PREFERRED_SIZE, 177, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(menu_category, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(manager_btn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(menu_scroll_frame, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(menu_basket, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(menu_data, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		delete_menubasket = new JButton("장바구니 비우기");
		panel_4.add(delete_menubasket, "name_114577126026667");
		delete_menubasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		menu_category1 = new JButton("New button");
		
		menu_category2 = new JButton("New button");
		
		menu_category3 = new JButton("New button");
		menu_category3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		menu_category4 = new JButton("New button");
		
		menu_category5 = new JButton("New button");
		menu_category5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_menu_category = new GroupLayout(menu_category);
		gl_menu_category.setHorizontalGroup(
			gl_menu_category.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu_category.createSequentialGroup()
					.addGap(17)
					.addComponent(menu_category1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(menu_category2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(menu_category3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(menu_category4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(menu_category5)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_menu_category.setVerticalGroup(
			gl_menu_category.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu_category.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menu_category.createParallelGroup(Alignment.BASELINE)
						.addComponent(menu_category4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(menu_category3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(menu_category2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(menu_category1, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(menu_category5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		menu_category.setLayout(gl_menu_category);
		
		menu_detail = new JPanel();
		GroupLayout gl_menu_basket = new GroupLayout(menu_basket);
		gl_menu_basket.setHorizontalGroup(
			gl_menu_basket.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu_basket.createSequentialGroup()
					.addContainerGap()
					.addComponent(menu_detail, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_menu_basket.setVerticalGroup(
			gl_menu_basket.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu_basket.createSequentialGroup()
					.addContainerGap()
					.addComponent(menu_detail, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(415, Short.MAX_VALUE))
		);
		GroupLayout gl_menu_detail = new GroupLayout(menu_detail);
		gl_menu_detail.setHorizontalGroup(
			gl_menu_detail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 165, Short.MAX_VALUE)
		);
		gl_menu_detail.setVerticalGroup(
			gl_menu_detail.createParallelGroup(Alignment.LEADING)
				.addGap(0, 61, Short.MAX_VALUE)
		);
		menu_detail.setLayout(gl_menu_detail);
		menu_basket.setLayout(gl_menu_basket);
		
		menu_frame = new JPanel();
		
		panel_5 = new JPanel();
		
		panel_6 = new JPanel();
		
		menu_img = new JPanel();
		
		menu_name = new JPanel();
		GroupLayout gl_menu_frame = new GroupLayout(menu_frame);
		gl_menu_frame.setHorizontalGroup(
			gl_menu_frame.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu_frame.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_menu_frame.createParallelGroup(Alignment.LEADING)
						.addComponent(menu_name, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(menu_img, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_menu_frame.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_menu_frame.setVerticalGroup(
			gl_menu_frame.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menu_frame.createSequentialGroup()
					.addContainerGap()
					.addComponent(menu_img, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menu_name, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_menu_frame.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_6.setLayout(new CardLayout(0, 0));
		
		menu_minus = new JButton("+");
		panel_6.add(menu_minus, "name_112875944449417");
		panel_5.setLayout(new CardLayout(0, 0));
		
		menu_plus = new JButton("-");
		menu_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_5.add(menu_plus, "name_112869191014792");
		menu_frame.setLayout(gl_menu_frame);
		GroupLayout gl_menu_scroll_frame = new GroupLayout(menu_scroll_frame);
		gl_menu_scroll_frame.setHorizontalGroup(
			gl_menu_scroll_frame.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu_scroll_frame.createSequentialGroup()
					.addContainerGap()
					.addComponent(menu_frame, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(466, Short.MAX_VALUE))
		);
		gl_menu_scroll_frame.setVerticalGroup(
			gl_menu_scroll_frame.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu_scroll_frame.createSequentialGroup()
					.addContainerGap()
					.addComponent(menu_frame, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(214, Short.MAX_VALUE))
		);
		menu_scroll_frame.setLayout(gl_menu_scroll_frame);
		
		panel_2.setLayout(new CardLayout(0, 0));
		
		fundallmenu = new JButton("결제하기");
		fundallmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(fundallmenu, "name_112689796232542");
		contentPane.setLayout(gl_contentPane);
	}
}
