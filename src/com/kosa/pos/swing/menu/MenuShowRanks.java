package com.kosa.pos.swing.menu;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MenuShowRanks extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuShowRanks(int rank, String menuname, int orderCount, String orderPercentage) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setPreferredSize(new Dimension(266, 152));

		JLabel menuName = new JLabel(menuname);
		menuName.setVerticalAlignment(SwingConstants.BOTTOM);
		menuName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		menuName.setBounds(43, 6, 217, 39);
		add(menuName);
		
		JLabel MenuRank = new JLabel(Integer.toString(rank) + ".");
		MenuRank.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		MenuRank.setBounds(6, 6, 49, 50);
		if (rank == 1) {
		    MenuRank.setForeground(new Color(255, 215, 0)); // 금색
		    menuName.setForeground(new Color(255, 215, 0)); // 금색
		} else if (rank == 2) {
		    MenuRank.setForeground(new Color(192, 192, 192)); // 은색
		    menuName.setForeground(new Color(192, 192, 192)); // 금색
		} else if (rank == 3) {
		    MenuRank.setForeground(new Color(205, 127, 50)); // 동색
		    menuName.setForeground(new Color(205, 127, 50)); // 금색
		}
		
		add(MenuRank);
		JLabel OrderCount = new JLabel("주문 횟수 : ");
		OrderCount.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		OrderCount.setBounds(6, 68, 88, 39);
		add(OrderCount);

		JLabel OrderCountshow = new JLabel(
		Integer.toString(orderCount) + " (" + orderPercentage + "%) ");
		OrderCountshow.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		OrderCountshow.setBounds(91, 68, 155, 39);
		add(OrderCountshow);
		
		String graph = generateGraph(orderPercentage);
		JLabel OrderCountGraph = new JLabel(graph);
		OrderCountGraph.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		OrderCountGraph.setBounds(6, 114, 254, 39);
		add(OrderCountGraph);
	}
	// ▒ 22 를 추가하는 로직
	public String generateGraph(String orderPercentage) {
	    int numFilled = (int) Math.round((Double.parseDouble(orderPercentage) / 100.0) * 23); // 가득찬 네모의 개수 계산
	    StringBuilder graph = new StringBuilder();

	    // 가득찬 네모 추가
	    for (int i = 0; i < numFilled; i++) {
	        graph.append("■"); // 가득찬 네모는 ■로 표시합니다.
	    }

	    // 비어있는 네모 추가
	    for (int i = 0; i < 23 - numFilled; i++) {
	        graph.append("□"); // 비어있는 네모는 □로 표시합니다.
	    }

	    return graph.toString();
	}

}
