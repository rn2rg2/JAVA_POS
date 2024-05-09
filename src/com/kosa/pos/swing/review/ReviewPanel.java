package com.kosa.pos.swing.review;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ReviewPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Review Panel Demo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(950, 650); // 창의 크기 설정
				frame.setLocationRelativeTo(null); // 화면 중앙에 위치시킴

				ReviewPanel reviewPanel = new ReviewPanel(); // ReviewPanel 인스턴스 생성
				frame.getContentPane().add(reviewPanel); // JFrame에 ReviewPanel 추가
				frame.setVisible(true); // 창을 보이게 설정
			}
		});
	}

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

		// 가정: ReviewMenuPanel이라는 클래스가 이미 정의되어 있으며, 이를 여러 개 추가할 것입니다.
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
