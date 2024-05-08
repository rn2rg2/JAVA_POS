package com.kosa.pos.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.Menu;

public class AdminRegisterdMenuList extends JPanel{

	private JTextField textField;
	private AdminMain adminMain;
	private String keyword;
	
	/**
	 * Create the application.
	 */
	public AdminRegisterdMenuList(AdminMain adminMain) {
		this.adminMain = adminMain;
		initialize();
		setSize(743, 666);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocation(227, 0);
		setVisible(true);
		adminMain.getMainPanel().add(this);
	}
	
	public AdminRegisterdMenuList(AdminMain adminMain, String keyword) {
		this.keyword = keyword;
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
		
		JLabel lblNewLabel = new JLabel("현재 등록 메뉴");
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
		List<Menu> menuList = menuDao.findAll(textField.getText());
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = textField.getText();
				AdminRegisterdMenuList temp = new AdminRegisterdMenuList(AdminRegisterdMenuList.this.adminMain, keyword);
//				temp.getTextField().setText(textField.getText());
				AdminRegisterdMenuList.this.adminMain.setAdminRegisterdMenuList(temp);
				AdminRegisterdMenuList.this.setVisible(false);
				AdminRegisterdMenuList.this.adminMain.getMainPanel().remove(AdminRegisterdMenuList.this);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(606, 103, 95, 45);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 179, 671, 412);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 671, 412);
		panel.add(scrollPane);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < menuList.size(); i++) {
			
			Menu menu = menuList.get(i);
			
			JPanel gridLayoutPanel = new JPanel();
	        gridLayoutPanel.setLayout(new GridLayout(0, 4, 0, 0));
	        
			// 메뉴 번호
			JPanel menuIdPanel = new JPanel();
			menuIdPanel.setLayout(new BorderLayout());
        	
            JLabel menuIdLabel = new JLabel(menu.getMenu_id() + ""); // 메뉴번호
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
        	
            JLabel menuNameLabel = new JLabel(menu.getName()); // 메뉴명
            menuNameLabel.setHorizontalAlignment(JLabel.CENTER);
            menuNameLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuNamePanel.add(menuNameLabel, BorderLayout.CENTER);
            
			// 수정 삭제버튼
			JPanel menuUpdateAndDeletePanel = new JPanel();
			menuUpdateAndDeletePanel.setLayout(new GridLayout(1, 2, 0, 0));
        	
            JButton menuUpdateBtn = new JButton("수정");
            menuUpdateBtn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuUpdateAndDeletePanel.add(menuUpdateBtn);
            
            JButton menuDeleteBtn = new JButton("삭제");
            menuDeleteBtn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            menuUpdateAndDeletePanel.add(menuUpdateBtn);
            menuUpdateAndDeletePanel.add(menuDeleteBtn);
            
            gridLayoutPanel.add(menuIdPanel);
            gridLayoutPanel.add(menucategoryPanel);
            gridLayoutPanel.add(menuNamePanel);
            gridLayoutPanel.add(menuUpdateAndDeletePanel);
            
            listPanel.add(gridLayoutPanel);
            
		}
		
		scrollPane.setViewportView(listPanel);
		
	}
	
}
