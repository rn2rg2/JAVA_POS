package com.kosa.pos.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Sample extends JFrame {

	public Sample() {
		setTitle("POS System");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 상위 판넬 - 그리드 레이아웃
		JPanel mainPanel = new JPanel(new GridLayout(0, 1)); // 1열로 그리드 레이아웃 설정

		// 데이터베이스에서 카테고리별 메뉴의 갯수를 가져와서 판넬에 추가
		// 예를 들어, categoryCounts 배열에 각 카테고리의 메뉴 갯수가 있다고 가정하고 아래와 같이 추가
		int[] categoryCounts = { 5, 8, 6 }; // 카테고리별 메뉴 갯수 예시
		for (int count : categoryCounts) {
			JPanel categoryPanel = new JPanel(new GridLayout(0, 3)); // 3열로 그리드 레이아웃 설정
			for (int i = 0; i < count; i++) {
				JButton menuButton = new JButton("Menu " + (i + 1)); // 메뉴 버튼 생성
				categoryPanel.add(menuButton); // 카테고리 판넬에 메뉴 버튼 추가
			}
			mainPanel.add(categoryPanel); // 상위 판넬에 카테고리 판넬 추가
		}

		JScrollPane scrollPane = new JScrollPane(mainPanel); // 스크롤 가능한 판넬에 상위 판넬 추가
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER); // 스크롤 가능한 판넬 추가
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Sample posGUI = new Sample();
			posGUI.setVisible(true);
		});
	}
}