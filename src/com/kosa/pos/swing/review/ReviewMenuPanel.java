package com.kosa.pos.swing.review;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int menuId;
	private String path;
	private String name;
	private int count;
	private double avg;

	public ReviewMenuPanel(int menuId, String path, String name, int count, double avg) {
		this.menuId = menuId;
		this.path = path;
		this.name = name;
		this.count = count;
		this.avg = avg;

		setPreferredSize(new Dimension(950, 185));
		setLayout(null);

		JLabel imgLabel = new JLabel("img");
		imgLabel.setBounds(37, 17, 150, 150);
		add(imgLabel);

		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(199, 17, 500, 150);
		add(contentPanel);
		contentPanel.setLayout(null);

		JLabel menuNameLabel = new JLabel(name);
		menuNameLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		menuNameLabel.setBounds(12, 21, 301, 50);
		contentPanel.add(menuNameLabel);

		JLabel orderCountLabel = new JLabel("주문 수:");
		orderCountLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		orderCountLabel.setBounds(12, 89, 80, 39);
		contentPanel.add(orderCountLabel);

		JLabel orderCount = new JLabel(String.valueOf(count));
		orderCount.setHorizontalAlignment(SwingConstants.CENTER);
		orderCount.setFont(new Font("굴림", Font.PLAIN, 20));
		orderCount.setBounds(92, 89, 99, 39);
		contentPanel.add(orderCount);

		JLabel ratingAvgLabel = new JLabel("별점 평균:");
		ratingAvgLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		ratingAvgLabel.setBounds(222, 89, 99, 39);
		contentPanel.add(ratingAvgLabel);

		JLabel ratingAvg = new JLabel(String.format("%.2f", avg));
		ratingAvg.setHorizontalAlignment(SwingConstants.CENTER);
		ratingAvg.setFont(new Font("굴림", Font.PLAIN, 20));
		ratingAvg.setBounds(328, 89, 99, 39);
		contentPanel.add(ratingAvg);

		JButton writeReviewButton = new JButton("리뷰 쓰러가기");
		writeReviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewWriteDialog rwd = new ReviewWriteDialog(menuId, path, name, count, avg);
				rwd.setModal(true);
				rwd.setVisible(true);
			}
		});
		writeReviewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		writeReviewButton.setBounds(711, 66, 171, 48);
		add(writeReviewButton);
	}
}
