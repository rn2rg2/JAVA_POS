package com.kosa.pos.swing.menu;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuShowRanks extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuShowRanks(int rank, String menuname, int orderCount, double orderPercentage) {
		setLayout(null);
		setPreferredSize(new Dimension(266, 152));

		JLabel MenuRank = new JLabel(Integer.toString(rank) + ".");
		MenuRank.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		MenuRank.setBounds(6, 6, 49, 50);
		add(MenuRank);

		JLabel menuName = new JLabel(menuname);
		menuName.setVerticalAlignment(SwingConstants.BOTTOM);
		menuName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		menuName.setBounds(43, 6, 217, 39);
		add(menuName);

		JLabel OrderCount = new JLabel("주문 횟수 : ");
		OrderCount.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		OrderCount.setBounds(6, 68, 88, 39);
		add(OrderCount);

		JLabel OrderCountshow = new JLabel(
		Integer.toString(orderCount) + " (" + Double.toString(orderPercentage) + "%) ");
		OrderCountshow.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		OrderCountshow.setBounds(91, 68, 105, 39);
		add(OrderCountshow);
		
		String graph = generateGraph(orderPercentage);
		JLabel OrderCountGraph = new JLabel(graph);
		OrderCountGraph.setBounds(6, 114, 254, 39);
		add(OrderCountGraph);
	}
	// ▒ 22 를 추가하는 로직
	public String generateGraph(double orderPercentage) {
	    int numBars = (int) Math.round((orderPercentage / 100.0) * 22); // 퍼센티지를 바의 개수로 변환
	    StringBuilder graph = new StringBuilder("▒"); // 그래프 초기화

	    // 퍼센티지에 따라 그래프 바 추가
	    for (int i = 0; i < numBars; i++) {
	        graph.append("▒");
	    }
	    return graph.toString();
	}

}
