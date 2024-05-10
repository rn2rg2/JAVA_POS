package com.kosa.pos.swing.review;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReviewPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public ReviewPanel() {
		// ReviewPanel 크기를 index 패널과 동일하게 설정
		setPreferredSize(new Dimension(950, 650));
		setLayout(null);

		// 상단 패널 구성
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 28, 950, 130);
		add(topPanel);
		topPanel.setLayout(null);

		JPanel upperPanel = new JPanel();
		upperPanel.setBounds(0, 0, 950, 65);
		topPanel.add(upperPanel);
		upperPanel.setLayout(null);

		JLabel reviewPromptLabel = new JLabel("리뷰를 작성해주세요!");
		reviewPromptLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		reviewPromptLabel.setBounds(353, 17, 244, 30);
		upperPanel.add(reviewPromptLabel);

		JPanel lowerPanel = new JPanel();
		lowerPanel.setBounds(0, 65, 950, 65);
		topPanel.add(lowerPanel);
		lowerPanel.setLayout(null);

		JLabel orderMenuLabel = new JLabel("주문한 메뉴");
		orderMenuLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		orderMenuLabel.setBounds(61, 18, 112, 28);
		lowerPanel.add(orderMenuLabel);

		JButton quitBtn = new JButton("나가기");
		quitBtn.setFont(new Font("굴림", Font.PLAIN, 20));
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		quitBtn.setBounds(785, 18, 106, 28);
		lowerPanel.add(quitBtn);

		// ScrollPane 설정
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Y_AXIS로 설정하여 수직 배치

		// test로 reviewMenuPanel 10개 추가
		for (int i = 0; i < 10; i++) { // 예시로 10개의 리뷰 메뉴 패널을 추가
			ReviewMenuPanel reviewMenuPanel = new ReviewMenuPanel();
			contentPanel.add(reviewMenuPanel); // contentPanel에 ReviewMenuPanel 추가
			if (i < 9) { // 마지막 패널을 제외하고 각 패널 사이에 간격 추가
				contentPanel.add(Box.createVerticalStrut(10)); // 10픽셀 간격
			}
		}

		JScrollPane scrollPane = new JScrollPane(contentPanel);
		scrollPane.setBounds(0, 180, 938, 470);
		add(scrollPane);
	}
}
