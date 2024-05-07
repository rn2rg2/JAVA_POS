package com.kosa.pos.swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AdminStatsInfo extends JPanel {
	private JTextField textField;
	private String[] xData;
	private double[] yData;
	
	
	public void setData(String[] xData, double[] yData) {
		this.xData = xData;
		this.yData = yData;
		initialize();
	}
	
	/**
	 * Create the application.
	 */
	public AdminStatsInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(0, 0, 731, 629);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("통계 정보");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 34, 262, 59);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(30, 103, 564, 45);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(606, 103, 95, 45);
		add(btnNewButton);
		
//		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel.setBounds(30, 170, 671, 426);
//		add(panel);
//		panel.setLayout(null);
		
		String[] xData = {"24-05-01","24-05-02","24-05-03","24-05-04","24-05-05","24-05-06","24-05-07"};
//		double[] yData = {20, 10, 40, 0, 60, 70, 80};
		double[] yData = {1,10,20,13,14,15,21};
		if(xData != null && yData != null) {
			
			GraphPanel graphPanel = new GraphPanel(xData, yData);
			graphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			graphPanel.setBounds(30, 170, 671, 426);
			add(graphPanel);
			graphPanel.setVisible(true);
		}

		
	}
}
