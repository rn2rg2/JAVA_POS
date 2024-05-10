package com.kosa.pos.swing.review;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ReviewMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ReviewMenuPanel() {
		setPreferredSize(new Dimension(950, 185));
		setLayout(null);

		JLabel imgLabel = new JLabel("img");
		imgLabel.setBounds(37, 17, 150, 150);
		add(imgLabel);

		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(199, 17, 500, 150);
		add(contentPanel);
		contentPanel.setLayout(null);

		JLabel menuNameLabel = new JLabel("");
		menuNameLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		menuNameLabel.setBounds(12, 21, 301, 50);
		contentPanel.add(menuNameLabel);

		JLabel orderCountLabel = new JLabel("주문 수:");
		orderCountLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		orderCountLabel.setBounds(12, 89, 80, 39);
		contentPanel.add(orderCountLabel);

		JLabel orderCount = new JLabel("");
		orderCount.setHorizontalAlignment(SwingConstants.CENTER);
		orderCount.setFont(new Font("굴림", Font.PLAIN, 20));
		orderCount.setBounds(92, 89, 99, 39);
		contentPanel.add(orderCount);

		JLabel ratingAvgLabel = new JLabel("별점 평균:");
		ratingAvgLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		ratingAvgLabel.setBounds(222, 89, 99, 39);
		contentPanel.add(ratingAvgLabel);

		JLabel orderCount_1 = new JLabel("");
		orderCount_1.setHorizontalAlignment(SwingConstants.CENTER);
		orderCount_1.setFont(new Font("굴림", Font.PLAIN, 20));
		orderCount_1.setBounds(328, 89, 99, 39);
		contentPanel.add(orderCount_1);

		JButton writeReviewButton = new JButton("리뷰 쓰러가기");
		writeReviewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		writeReviewButton.setBounds(711, 66, 171, 48);
		add(writeReviewButton);
	}
	// TODO
	// 1. ReviewMenuPanel 생성자에 매개변수 추가
	// (필요한 매개변수: 메뉴명, 주문수, 별점 평균 -> menu_id만 가져와서 다 처리할 수도 있을 듯)
}
