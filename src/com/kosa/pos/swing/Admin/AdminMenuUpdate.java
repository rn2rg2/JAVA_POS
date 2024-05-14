package com.kosa.pos.swing.Admin;

import java.awt.Color;
import java.awt.Component;
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
import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;
import com.kosa.pos.swing.main.Index;

public class AdminMenuUpdate extends JPanel {

	private JTextField menuNameTextField;
	private JTextField categoryNameTextField;
	private JTextField priceTextField;
	private AdminMainPanel adminMain;
	private JLabel menuPath;
	private JTextArea menuDescTextArea;
	private File oldImageFile;
	private File newImageFile;
	
	private Menu menu;
	
	/**
	 * Create the application.
	 */
	public AdminMenuUpdate(AdminMainPanel adminMain, Menu menu) {
		this.menu = menu;
		this.adminMain = adminMain;
		initialize();
		setSize(743, 666);
		setLocation(227, 0);
		setVisible(true);
		adminMain.getMainPanel().add(this);
	}
	
	public void setOldImageFile(File oldImageFile) {
		this.oldImageFile = oldImageFile;
	}

	public File getOldImageFile() {
		return this.oldImageFile;
	}
	
	public void setNewImageFile(File newImageFile) {
		this.newImageFile = newImageFile;
	}
	
	public File getNewImageFile() {
		return this.newImageFile;
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
		
		JLabel lblNewLabel = new JLabel("세부 메뉴 수정");
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
		menuNameTextField.setText(menu.getName());
		
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
		categoryNameTextField.setText(menu.getCategory());
		
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
		menuDescTextArea.setText(menu.getMenu_desc());
		
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
		priceTextField.setText(String.valueOf(menu.getPrice()));
		
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
	                AdminMenuUpdate.this.menuPath.setText(selectedFile.getAbsolutePath());
	                AdminMenuUpdate.this.setNewImageFile(selectedFile);
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
		menuPath.setText(menu.getMenu_path());
		this.oldImageFile = new File(menu.getMenu_path());
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String menuName = AdminMenuUpdate.this.menuNameTextField.getText();
				String category = AdminMenuUpdate.this.categoryNameTextField.getText();
				int price = Integer.parseInt(AdminMenuUpdate.this.priceTextField.getText());
				String menuDesc = AdminMenuUpdate.this.menuDescTextArea.getText();
				File menuImage = AdminMenuUpdate.this.getOldImageFile();
				
				AdminMenuUpdate.this.menuUpdate(menuName, category, price, menuDesc, menuImage);
				
				// index.java에서도 adminPanel 생성할때 setName설정을 해줘야함
				AdminMainPanel adminPanel = new AdminMainPanel(IndexManager.getIndex());
				adminPanel.setName("adminPanel");

				Component[] compList = ContentPaneManager.getContentPane().getComponents();
				for(Component c : compList) {
					if(c.getName() != null && c.getName().equals("adminPanel")) {
						ContentPaneManager.getContentPane().remove(c);
						ContentPaneManager.getContentPane().add(adminPanel,"adminPanel");
						break;
					}
				}


				CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "adminPanel");
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setBounds(30, 529, 671, 67);
		add(btnNewButton);
	}
	
	public void menuUpdate(String menuName, String category, int price, String menuDesc, File menuImage) {
		// 1. 파일명 확보
		String fileSaveRoute = null;
		if(this.newImageFile != null) {
			// 파일을 수정하는 경우
			fileSaveRoute = FileUploadLogic.fileUploadLogic(this.newImageFile);
			if(this.oldImageFile.exists()) this.oldImageFile.delete();
		}else {
			fileSaveRoute = this.menu.getMenu_path();
		}
		
		
		// 3. callablestatement로 db에 update
		Menu menu = new Menu();
		menu.setMenu_id(this.menu.getMenu_id());
		menu.setCategory(category);
		menu.setName(menuName);
		menu.setMenu_desc(menuDesc);
		menu.setPrice(price);
		menu.setMenu_path(fileSaveRoute);
		
		MenuDAO menuDao = new MenuDAOImpl();
		menuDao.updateMenu(menu);
		
	}
}
