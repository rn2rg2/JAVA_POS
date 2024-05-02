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

public class index extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel_1_1 = new JPanel();

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(new CardLayout(0, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
						.addContainerGap()));

		// 비회원 주문 이벤트 리스너
		btnNewButton_1 = new JButton("비회원 주문");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userData = "왜 안";
				menu menuf = new menu(userData);
				menuf.setVisible(true);
				setVisible(false);
			}
		});
		panel_1_1_1.add(btnNewButton_1, "name_101134429196583");
		panel_1_1.setLayout(new CardLayout(0, 0));

		// 회원 주문 이벤트 리스터
		btnNewButton = new JButton("회원 주문");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_1_1.add(btnNewButton, "name_101131841027083");
		contentPane.setLayout(gl_contentPane);
	}
}
