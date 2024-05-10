
package com.kosa.pos.swing.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.kosa.pos.common.FileUploadLogic;
import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.Menu;

public class AdminMenuInsert extends JPanel{
	private JTextField menuNameTextField;
	private JTextField categoryNameTextField;
	private JTextField priceTextField;
	private AdminMainPanel adminMain;
	private JLabel menuPath;
	private JTextArea menuDescTextArea;
	private File menuImage;
	
	/**
	 * Create the application.
	 */
	public AdminMenuInsert(AdminMainPanel adminMain) {
		this.adminMain = adminMain;
		initialize();
		setSize(743, 666);
		setLocation(227, 0);
		setVisible(true);
		adminMain.getMainPanel().add(this);
	}
	
	public void setMenuImageFile(File menuImage) {
		this.menuImage = menuImage;
	}

	public File getMenuImageFile() {
		return this.menuImage;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(225, 0, 745, 666);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		


		setBounds(0, 0, 731, 629);
//		frame.getContentPane().add(registeredMenuListPanel);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("세부 메뉴 추가");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 34, 262, 59);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 103, 671, 428);
		add(panel);
		panel.setLayout(null);
		
		JPanel menuNamePanel = new JPanel();
		menuNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuNamePanel.setBounds(0, 0, 671, 76);
		panel.add(menuNamePanel);
		menuNamePanel.setLayout(null);
		
		JLabel menuNameLabel = new JLabel("메뉴명");
		menuNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuNameLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		menuNameLabel.setBounds(22, 21, 101, 35);
		menuNamePanel.add(menuNameLabel);
		
		menuNameTextField = new JTextField();
		menuNameTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		menuNameTextField.setBounds(139, 10, 520, 56);
		menuNamePanel.add(menuNameTextField);
		menuNameTextField.setColumns(10);
		
		JPanel categoryNamePanel = new JPanel();
		categoryNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		categoryNamePanel.setBounds(0, 84, 671, 76);
		panel.add(categoryNamePanel);
		categoryNamePanel.setLayout(null);
		
		JLabel categoryNameLabel = new JLabel("카테고리명");
		categoryNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		categoryNameLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		categoryNameLabel.setBounds(17, 21, 110, 35);
		categoryNamePanel.add(categoryNameLabel);
		
		categoryNameTextField = new JTextField();
		categoryNameTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		categoryNameTextField.setColumns(10);
		categoryNameTextField.setBounds(139, 10, 520, 56);
		categoryNamePanel.add(categoryNameTextField);
		
		JPanel menuDescPanel = new JPanel();
		menuDescPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuDescPanel.setBounds(0, 170, 671, 76);
		panel.add(menuDescPanel);
		menuDescPanel.setLayout(null);
		
		JLabel menuDescLabel = new JLabel("메뉴 소개");
		menuDescLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuDescLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		menuDescLabel.setBounds(26, 20, 101, 35);
		menuDescPanel.add(menuDescLabel);
		
		menuDescTextArea = new JTextArea();
		menuDescTextArea.setBounds(139, 10, 520, 56);
		menuDescPanel.add(menuDescTextArea);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pricePanel.setBounds(0, 256, 671, 76);
		panel.add(pricePanel);
		pricePanel.setLayout(null);
		
		JLabel priceLabel = new JLabel("가격");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		priceLabel.setBounds(26, 21, 101, 35);
		pricePanel.add(priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		priceTextField.setColumns(10);
		priceTextField.setBounds(139, 10, 520, 56);
		pricePanel.add(priceTextField);
		
		JPanel menuPathPanel = new JPanel();
		menuPathPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPathPanel.setBounds(0, 342, 671, 76);
		panel.add(menuPathPanel);
		menuPathPanel.setLayout(null);
		
		JLabel menuPathLabel = new JLabel("메뉴 이미지");
		menuPathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuPathLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		menuPathLabel.setBounds(22, 20, 117, 35);
		menuPathPanel.add(menuPathLabel);
		
		JButton btnNewButton_1 = new JButton("파일 업로드");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            JFileChooser fileChooser = new JFileChooser();
	            int returnValue = fileChooser.showOpenDialog(null);
	            
	            if (returnValue == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                // 선택된 파일에 대한 작업을 수행합니다.
	                AdminMenuInsert.this.menuPath.setText(selectedFile.getAbsolutePath());
	                AdminMenuInsert.this.setMenuImageFile(selectedFile);
//	                System.out.println("선택한 파일: " + selectedFile.getAbsolutePath());
	            }
		        
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBounds(151, 23, 155, 31);
		menuPathPanel.add(btnNewButton_1);
		
		menuPath = new JLabel("");
		menuPath.setHorizontalAlignment(SwingConstants.CENTER);
		menuPath.setFont(new Font("굴림", Font.PLAIN, 12));
		menuPath.setBounds(319, 20, 340, 35);
		menuPathPanel.add(menuPath);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String menuName = AdminMenuInsert.this.menuNameTextField.getText();
				String category = AdminMenuInsert.this.categoryNameTextField.getText();
				int price = Integer.parseInt(AdminMenuInsert.this.priceTextField.getText());
				String menuDesc = AdminMenuInsert.this.menuDescTextArea.getText();
				File menuImage = AdminMenuInsert.this.getMenuImageFile();
				
				AdminMenuInsert.this.menuInsert(menuName, category, price, menuDesc, menuImage);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(30, 529, 671, 67);
		add(btnNewButton);
	}
	
	public void menuInsert(String menuName, String category, int price, String menuDesc, File menuImage) {
		// 1. 파일명 확보
		String fileSaveRoute = FileUploadLogic.fileUploadLogic(menuImage);
		
		
		// 3. callablestatement로 db에 insert
		Menu menu = new Menu();
		menu.setCategory(category);
		menu.setName(menuName);
		menu.setMenu_desc(menuDesc);
		menu.setPrice(price);
		menu.setMenu_path(fileSaveRoute);
		
		MenuDAO menuDao = new MenuDAOImpl();
		menuDao.insertMenu(menu);
		
		// 4. 화면 새로 고침
		this.adminMain.setAdminMenuInsert(new AdminMenuInsert(this.adminMain));
		this.setVisible(false);
		this.adminMain.getMainPanel().remove(this);
		
		// 등록 했을 때 등록화면, 인기메뉴 화면을 다시 불러야함
		AdminRegisterdMenuList arm = AdminMenuInsert.this.adminMain.getAdminRegisterdMenuList();
		AdminMenuInsert.this.adminMain.setAdminRegisterdMenuList(new AdminRegisterdMenuList(AdminMenuInsert.this.adminMain));
		AdminMenuInsert.this.adminMain.getAdminRegisterdMenuList().setVisible(false);
		arm.setVisible(false);
		AdminMenuInsert.this.adminMain.getMainPanel().remove(arm);
		
		AdminBestMenuList abm = AdminMenuInsert.this.adminMain.getAdminBestMenuList();
		AdminMenuInsert.this.adminMain.setAdminBestMenuList(new AdminBestMenuList(AdminMenuInsert.this.adminMain));
		AdminMenuInsert.this.adminMain.getAdminBestMenuList().setVisible(false);
		abm.setVisible(false);
		AdminMenuInsert.this.adminMain.getMainPanel().remove(abm);
		
	}
}
