package com.kosa.pos.swing.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.MenuStatsInfo;

public class AdminStatsInfo extends JPanel {
	private JTextField textField;
	
	//초기화면 설정
	MenuDAO menuDao = new MenuDAOImpl();
	Optional<MenuStatsInfo> menushowGraph = menuDao.findOrderCountByName();
	MenuStatsInfo menuGraphInfo = menushowGraph.get();
	private String[] xData =menuGraphInfo.getDay();
	private double[] yData = menuGraphInfo.getValues();
	
	private AdminMainPanel adminMain;

	public void setData(String[] xData, double[] yData) {
		this.xData = xData;
		this.yData = yData;
		repaint();
	}

	public AdminStatsInfo(AdminMainPanel adminMain, String[] xData, double[] yData) {
		this.adminMain = adminMain;
		this.xData = xData;
		this.yData = yData;
		initialize();
		setSize(743, 666);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocation(227, 0);
		setVisible(true);
		adminMain.getMainPanel().add(this);
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.constructor
	 */
	public AdminStatsInfo(AdminMainPanel adminMain) {
		this.adminMain = adminMain;
		initialize();
		setSize(743, 666);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocation(227, 0);
		setVisible(true);
		adminMain.getMainPanel().add(this);

	}

	public JTextField getTextField() {
		return this.textField;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(0, 0, 731, 629);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("메뉴별 최근 주문 횟수");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 34, 508, 59);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(30, 103, 564, 45);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼 누르면 callableStatement로 데이터 가져온 후 xData, yData에 대입
				
				String searchContent = textField.getText();//.replaceAll("\\s", ""); // 공백 제거
				String[] xData;
				double[] yData;
				System.out.println("그래프의 search : "+ searchContent);
				if (searchContent.equals("")) {
					System.out.println("search 가 비어있을때");
					Optional<MenuStatsInfo> menuGraphDefault = menuDao.findOrderCountByName();

					xData = menuGraphDefault.get().getDay();
					yData = menuGraphDefault.get().getValues();
					System.out.println("X : " + xData[6] + " || "+ "Y : "+ yData[6]);
				} else {
					System.out.println("search 가 존재할때");
					Optional<MenuStatsInfo> _menuStatsInfo = menuDao.findOrderCountByName(searchContent);

					MenuStatsInfo menuStatsInfo = _menuStatsInfo.get();

					xData = menuStatsInfo.getDay();
					yData = menuStatsInfo.getValues();
					System.out.println("X : " + xData[6] + " || "+ "Y : "+ yData[6]);
				}

				AdminStatsInfo temp = new AdminStatsInfo(adminMain, xData, yData);
				temp.getTextField().setText(searchContent);
				AdminStatsInfo.this.adminMain.setAdminStatsInfo(temp);
				AdminStatsInfo.this.setVisible(false);
				AdminStatsInfo.this.adminMain.getMainPanel().remove(AdminStatsInfo.this);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(606, 103, 95, 45);
		add(btnNewButton);

//		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panel.setBounds(30, 170, 671, 426);
//		add(panel);
//		panel.setLayout(null);

//		String[] xData = {"24-05-01","24-05-02","24-05-03","24-05-04","24-05-05","24-05-06","24-05-07"};
//		double[] yData = {20, 10, 40, 0, 60, 70, 80};
//		double[] yData = {1,10,20,13,14,15,21};
//		if(xData != null && yData != null) {

		GraphPanel graphPanel = new GraphPanel(this.xData, this.yData);
		graphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		graphPanel.setBounds(30, 170, 671, 426);
		add(graphPanel);
		graphPanel.setVisible(true);
//		}

	}
}
