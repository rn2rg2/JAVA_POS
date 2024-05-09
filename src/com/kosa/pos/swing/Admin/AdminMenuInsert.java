package com.kosa.pos.swing.Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class AdminMenuInsert extends JPanel{
	private JTextField menuNameTextField;
	private JTextField categoryNameTextField;
	private JTextField priceTextField;
	private AdminMain adminMain;
	
	/**
	 * Create the application.
	 */
	public AdminMenuInsert(AdminMain adminMain) {
		this.adminMain = adminMain;
		initialize();
		setSize(743, 666);
		setLocation(227, 0);
		setVisible(false);
		adminMain.getMainPanel().add(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(225, 0, 745, 666);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		


		setBounds(0, 0, 731, 629);
//		frame.getContentPane().add(registeredMenuListPanel);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("세부 메뉴 추가");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 34, 262, 59);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 103, 671, 428);
		add(panel);
		panel.setLayout(null);
		
		JPanel menuNamePanel = new JPanel();
		menuNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuNamePanel.setBounds(0, 0, 671, 76);
		panel.add(menuNamePanel);
		menuNamePanel.setLayout(null);
		
		JLabel menuNameLabel = new JLabel("메뉴명");
		menuNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuNameLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		menuNameLabel.setBounds(22, 21, 101, 35);
		menuNamePanel.add(menuNameLabel);
		
		menuNameTextField = new JTextField();
		menuNameTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		menuNameTextField.setBounds(139, 10, 520, 56);
		menuNamePanel.add(menuNameTextField);
		menuNameTextField.setColumns(10);
		
		JPanel categoryNamePanel = new JPanel();
		categoryNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		categoryNamePanel.setBounds(0, 84, 671, 76);
		panel.add(categoryNamePanel);
		categoryNamePanel.setLayout(null);
		
		JLabel categoryNameLabel = new JLabel("카테고리명");
		categoryNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		categoryNameLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		categoryNameLabel.setBounds(17, 21, 110, 35);
		categoryNamePanel.add(categoryNameLabel);
		
		categoryNameTextField = new JTextField();
		categoryNameTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		categoryNameTextField.setColumns(10);
		categoryNameTextField.setBounds(139, 10, 520, 56);
		categoryNamePanel.add(categoryNameTextField);
		
		JPanel menuDescPanel = new JPanel();
		menuDescPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuDescPanel.setBounds(0, 170, 671, 76);
		panel.add(menuDescPanel);
		menuDescPanel.setLayout(null);
		
		JLabel menuDescLabel = new JLabel("메뉴 소개");
		menuDescLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuDescLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		menuDescLabel.setBounds(26, 20, 101, 35);
		menuDescPanel.add(menuDescLabel);
		
		JTextArea menuDescTextArea = new JTextArea();
		menuDescTextArea.setBounds(139, 10, 520, 56);
		menuDescPanel.add(menuDescTextArea);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pricePanel.setBounds(0, 256, 671, 76);
		panel.add(pricePanel);
		pricePanel.setLayout(null);
		
		JLabel priceLabel = new JLabel("가격");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		priceLabel.setBounds(26, 21, 101, 35);
		pricePanel.add(priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		priceTextField.setColumns(10);
		priceTextField.setBounds(139, 10, 520, 56);
		pricePanel.add(priceTextField);
		
		JPanel menuPathPanel = new JPanel();
		menuPathPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPathPanel.setBounds(0, 342, 671, 76);
		panel.add(menuPathPanel);
		menuPathPanel.setLayout(null);
		
		JLabel menuPathLabel = new JLabel("메뉴 이미지");
		menuPathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuPathLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		menuPathLabel.setBounds(22, 20, 117, 35);
		menuPathPanel.add(menuPathLabel);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(30, 529, 671, 67);
		add(btnNewButton);
	}
}
