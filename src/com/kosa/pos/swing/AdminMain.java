package com.kosa.pos.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JLabel lblNewLabel = new JLabel("▼ 메뉴 추가");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 43, 164, 46);
		menuPanel.add(lblNewLabel);
		
		// 카테고리 추가 버튼 시작
		JButton btnNewButton = new JButton("- 카테고리 추가");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setForeground(Color.red);
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setForeground(Color.black);
				frame.setCursor(Cursor.getDefaultCursor());
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.setBounds(52, 85, 152, 42);
		menuPanel.add(btnNewButton);
		// 카테고리 추가 버튼 끝
		
		// 세부 메뉴 추가 시작
		JButton btnNewButton_1 = new JButton("- 세부 메뉴 추가");
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
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(52, 124, 164, 42);
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
			}
		});
		btnNewButton_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(12, 159, 164, 61);
		menuPanel.add(btnNewButton_1_1);
		// 등록 메뉴 끝
		
		JLabel lblNewLabel_1 = new JLabel("▼ 통계 정보");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 209, 164, 46);
		menuPanel.add(lblNewLabel_1);
		
		// 인기 메뉴 시작 
		JButton btnNewButton_2 = new JButton("- 인기 메뉴");
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
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(41, 249, 152, 42);
		menuPanel.add(btnNewButton_2);
		// 인기 메뉴 끝
		
		// 통계 정보1 시작 
		JButton btnNewButton_2_1 = new JButton("- 통계 정보1");
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
			}
		});
		btnNewButton_2_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBounds(41, 285, 152, 42);
		menuPanel.add(btnNewButton_2_1);
		
		JPanel listPanel = new JPanel();
		listPanel.setBounds(225, 0, 745, 666);
		mainPanel.add(listPanel);
		listPanel.setLayout(new CardLayout(0, 0));
		// 통계 정보1 끝
		
		
		
	}
}
