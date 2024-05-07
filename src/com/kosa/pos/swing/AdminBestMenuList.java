package com.kosa.pos.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AdminBestMenuList extends JPanel {
private JTextField textField;
	
	/**
	 * Create the application.
	 */
	public AdminBestMenuList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(0, 0, 731, 629);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인기 메뉴");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 34, 262, 59);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(125, 103, 469, 45);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(606, 103, 95, 45);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"구분", "카테고리1", "카테고리2", "카테고리3"}));
		comboBox.setBounds(30, 103, 83, 45);
		add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 179, 671, 412);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 671, 412);
		panel.add(scrollPane);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < 20; i++) {
			
			JPanel gridLayoutPanel = new JPanel();
	        gridLayoutPanel.setLayout(new GridLayout(0, 5, 0, 0));
	        
			// 메뉴 번호
			JPanel menuIdPanel = new JPanel();
			menuIdPanel.setLayout(new BorderLayout());
        	
            JLabel menuIdLabel = new JLabel("순위" + i);
            menuIdLabel.setHorizontalAlignment(JLabel.CENTER);
            menuIdLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuIdPanel.add(menuIdLabel, BorderLayout.CENTER);
            
			// 메뉴 카테고리
			JPanel menucategoryPanel = new JPanel();
			menucategoryPanel.setLayout(new BorderLayout());
        	
            JLabel menucategoryLabel = new JLabel("카테고리명" + i);
            menucategoryLabel.setHorizontalAlignment(JLabel.CENTER);
            menucategoryLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menucategoryPanel.add(menucategoryLabel, BorderLayout.CENTER);
            
			// 메뉴 카테고리
			JPanel menuNamePanel = new JPanel();
			menuNamePanel.setLayout(new BorderLayout());
        	
            JLabel menuNameLabel = new JLabel("메뉴 이름" + i);
            menuNameLabel.setHorizontalAlignment(JLabel.CENTER);
            menuNameLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuNamePanel.add(menuNameLabel, BorderLayout.CENTER);
            
			// 주문 횟수
			JPanel menuOrderCountPanel = new JPanel();
			menuOrderCountPanel.setLayout(new BorderLayout());
        	
            JLabel menuOrderCountLabel = new JLabel("주문 횟수" + i);
            menuOrderCountLabel.setHorizontalAlignment(JLabel.CENTER);
            menuOrderCountLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuOrderCountPanel.add(menuOrderCountLabel, BorderLayout.CENTER);
            
			// 리뷰 평점
			JPanel menuReviewAvgScorePanel = new JPanel();
			menuReviewAvgScorePanel.setLayout(new BorderLayout());
        	
            JLabel menuReviewAvgScoreLabel = new JLabel("리뷰 평점" + i);
            menuReviewAvgScoreLabel.setHorizontalAlignment(JLabel.CENTER);
            menuReviewAvgScoreLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuReviewAvgScorePanel.add(menuReviewAvgScoreLabel, BorderLayout.CENTER);
            
            gridLayoutPanel.add(menuIdPanel);
            gridLayoutPanel.add(menucategoryPanel);
            gridLayoutPanel.add(menuNamePanel);
            gridLayoutPanel.add(menuOrderCountPanel);
            gridLayoutPanel.add(menuReviewAvgScorePanel);
            
            listPanel.add(gridLayoutPanel);
            
		}
		
		scrollPane.setViewportView(listPanel);
		
	}
}
