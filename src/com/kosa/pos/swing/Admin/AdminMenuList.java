package com.kosa.pos.swing.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class AdminMenuList {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuList window = new AdminMenuList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminMenuList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(225, 0, 745, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel registeredMenuListPanel = new JPanel();
		registeredMenuListPanel.setBounds(0, 0, 731, 629);
		frame.getContentPane().add(registeredMenuListPanel);
		registeredMenuListPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("현재 등록 메뉴");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 34, 262, 59);
		registeredMenuListPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(125, 103, 469, 45);
		registeredMenuListPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(606, 103, 95, 45);
		registeredMenuListPanel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"구분", "카테고리1", "카테고리2", "카테고리3"}));
		comboBox.setBounds(30, 103, 83, 45);
		registeredMenuListPanel.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 179, 671, 412);
		registeredMenuListPanel.add(panel);
	}
}
