package com.kosa.pos.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

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

import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.Menu;
import com.kosa.pos.dto.MenuDetail;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminBestMenuList extends JPanel {
	private JTextField textField;
	private AdminMain adminMain;
	private String keyword;
	
	/**
	 * Create the application.
	 */
	public AdminBestMenuList(AdminMain adminMain) {
		this(adminMain, null);
	}
	
	public AdminBestMenuList(AdminMain adminMain, String keyword) {
		this.keyword = keyword;
		this.adminMain = adminMain;
		initialize();
		setSize(743, 666);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocation(227, 0);
		setVisible(true);
		adminMain.getMainPanel().add(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 184, 671, 52);
		add(panel);
		panel.setLayout(null);
		
		JLabel rankLabel = new JLabel("순위");
		rankLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setBounds(34, 10, 78, 32);
		panel.add(rankLabel);
		
		JLabel rankLabel_1 = new JLabel("카테고리");
		rankLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		rankLabel_1.setBounds(156, 10, 103, 32);
		panel.add(rankLabel_1);
		
		JLabel rankLabel_1_1 = new JLabel("메뉴명");
		rankLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		rankLabel_1_1.setBounds(281, 10, 103, 32);
		panel.add(rankLabel_1_1);
		
		JLabel rankLabel_1_1_1 = new JLabel("주문 횟수");
		rankLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel_1_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		rankLabel_1_1_1.setBounds(412, 10, 103, 32);
		panel.add(rankLabel_1_1_1);
		
		JLabel rankLabel_1_1_1_1 = new JLabel("리뷰 평균");
		rankLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		rankLabel_1_1_1_1.setBounds(536, 10, 103, 32);
		panel.add(rankLabel_1_1_1_1);
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
		textField.setBounds(30, 103, 564, 45);
		add(textField);
		textField.setColumns(10);
		if(keyword != null) textField.setText(keyword);
		
		MenuDAO menuDao = new MenuDAOImpl();
		List<MenuDetail> menuRankList = menuDao.findBestMenuAll(textField.getText() + "");
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = textField.getText();
				AdminBestMenuList temp = new AdminBestMenuList(AdminBestMenuList.this.adminMain, keyword);
//				temp.getTextField().setText(textField.getText());
				AdminBestMenuList.this.adminMain.setAdminBestMenuList(temp);
				AdminBestMenuList.this.setVisible(false);
				AdminBestMenuList.this.adminMain.getMainPanel().remove(AdminBestMenuList.this);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(606, 103, 95, 45);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 238, 671, 353);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 671, 353);
		panel.add(scrollPane);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < menuRankList.size(); i++) {
			
			MenuDetail menuDetail = menuRankList.get(i);
			Menu menu = menuDetail.getMenu();
			
			JPanel gridLayoutPanel = new JPanel();
	        gridLayoutPanel.setLayout(new GridLayout(0, 5, 0, 0));
	        
			// 메뉴 번호
			JPanel menuIdPanel = new JPanel();
			menuIdPanel.setLayout(new BorderLayout());
        	
            JLabel menuIdLabel = new JLabel(menuDetail.getRank() + ""); // 순위
            menuIdLabel.setHorizontalAlignment(JLabel.CENTER);
            menuIdLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuIdPanel.add(menuIdLabel, BorderLayout.CENTER);
            
			// 메뉴 카테고리
			JPanel menucategoryPanel = new JPanel();
			menucategoryPanel.setLayout(new BorderLayout());
        	
            JLabel menucategoryLabel = new JLabel(menu.getCategory()); // 카테고리
            menucategoryLabel.setHorizontalAlignment(JLabel.CENTER);
            menucategoryLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menucategoryPanel.add(menucategoryLabel, BorderLayout.CENTER);
            
			// 메뉴명
			JPanel menuNamePanel = new JPanel();
			menuNamePanel.setLayout(new BorderLayout());
        	
            JLabel menuNameLabel = new JLabel(menu.getName()); // 이름
            menuNameLabel.setHorizontalAlignment(JLabel.CENTER);
            menuNameLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuNamePanel.add(menuNameLabel, BorderLayout.CENTER);
            
			// 주문 횟수
			JPanel menuOrderCountPanel = new JPanel();
			menuOrderCountPanel.setLayout(new BorderLayout());
        	
            JLabel menuOrderCountLabel = new JLabel(menuDetail.getCount() + ""); // 주문 횟수
            menuOrderCountLabel.setHorizontalAlignment(JLabel.CENTER);
            menuOrderCountLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuOrderCountPanel.add(menuOrderCountLabel, BorderLayout.CENTER);
            
			// 리뷰 평점
			JPanel menuReviewAvgScorePanel = new JPanel();
			menuReviewAvgScorePanel.setLayout(new BorderLayout());
        	
            JLabel menuReviewAvgScoreLabel = new JLabel(menuDetail.getAvgScore() + ""); // 리뷰 평점
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
