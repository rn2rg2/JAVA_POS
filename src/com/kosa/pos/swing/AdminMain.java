package com.kosa.pos.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;

public class AdminMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain window = new AdminMain();
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
	public AdminMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 984, 703);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 970, 666);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPanel.setBounds(0, 0, 228, 666);
		mainPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		// 현재 등록된 메뉴 화면
		AdminRegisterdMenuList adminRegisterdMenuList = new AdminRegisterdMenuList();
		adminRegisterdMenuList.setSize(743, 666);
		adminRegisterdMenuList.setLocation(227, 0);
		adminRegisterdMenuList.setVisible(true);
		mainPanel.add(adminRegisterdMenuList);
		
		// 세부 메뉴 추가 화면
		AdminMenuInsert adminMenuInsert = new AdminMenuInsert();
		adminMenuInsert.setSize(743, 666);
		adminMenuInsert.setLocation(227, 0);
		adminMenuInsert.setVisible(false);
		mainPanel.add(adminMenuInsert);
		
		// 인기 메뉴 화면
		AdminBestMenuList adminBestMenuList = new AdminBestMenuList();
		adminBestMenuList.setSize(743, 666);
		adminBestMenuList.setLocation(227, 0);
		adminBestMenuList.setVisible(false);
		mainPanel.add(adminBestMenuList);
		
		// 통계 화면
		AdminStatsInfo adminStatsInfo = new AdminStatsInfo();
		adminStatsInfo.setSize(743, 666);
		adminStatsInfo.setLocation(227, 0);
		adminStatsInfo.setVisible(false);
		mainPanel.add(adminStatsInfo);
		
		JLabel lblNewLabel = new JLabel("▼ 메뉴 추가");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 43, 164, 46);
		menuPanel.add(lblNewLabel);
		
		// 세부 메뉴 추가 시작
		JButton btnNewButton_1 = new JButton("- 세부 메뉴 추가");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setForeground(Color.red);
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setForeground(Color.black);
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminMenuInsert.setVisible(true);
				adminRegisterdMenuList.setVisible(false);
				adminBestMenuList.setVisible(false);
				adminStatsInfo.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(41, 86, 164, 42);
		menuPanel.add(btnNewButton_1);
		// 세부 메뉴 추가 끝
		
		
		// 등록 메뉴 시작 
		JButton btnNewButton_1_1 = new JButton("▶ 등록 메뉴");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1_1.setForeground(Color.red);
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1_1.setForeground(Color.black);
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminRegisterdMenuList.setVisible(true);
				adminMenuInsert.setVisible(false);
				adminBestMenuList.setVisible(false);
				adminStatsInfo.setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(12, 127, 164, 61);
		menuPanel.add(btnNewButton_1_1);
		// 등록 메뉴 끝
		
		JLabel lblNewLabel_1 = new JLabel("▼ 통계 정보");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 183, 164, 46);
		menuPanel.add(lblNewLabel_1);
		
		// 인기 메뉴 시작 
		JButton btnNewButton_2 = new JButton("- 인기 메뉴");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setForeground(Color.red);
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setForeground(Color.black);
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminRegisterdMenuList.setVisible(false);
				adminMenuInsert.setVisible(false);
				adminBestMenuList.setVisible(true);
				adminStatsInfo.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(41, 223, 152, 42);
		menuPanel.add(btnNewButton_2);
		// 인기 메뉴 끝
		
		// 통계 정보1 시작 
		JButton btnNewButton_2_1 = new JButton("- 통계 정보1");
		btnNewButton_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2_1.setForeground(Color.red);
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2_1.setForeground(Color.black);
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});
		
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adminStatsInfo.setVisible(true);
				adminRegisterdMenuList.setVisible(false);
				adminMenuInsert.setVisible(false);
				adminBestMenuList.setVisible(false);
			}
		});
		btnNewButton_2_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBounds(41, 263, 152, 42);
		menuPanel.add(btnNewButton_2_1);
		

		
		
		
		
	}
}
