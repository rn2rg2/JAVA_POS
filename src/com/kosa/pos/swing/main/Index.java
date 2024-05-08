package com.kosa.pos.swing.main;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kosa.pos.swing.menu.MenuView;
import com.kosa.pos.swing.menu.menutest;

public class Index extends JFrame {
	//싱글톤으로 지정
	private JPanel contentPane;
    private CardLayout cardLayout;
    
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 950, 700);
		cardLayout = CardLayoutManager.getCardLayout();
		//contentPane = new JPanel(cardLayout);
		contentPane = ContentPaneManager.getContentPane();
		
		add(contentPane);
		MenuView menuPanel = new MenuView();


		menutest cp = new menutest();

		contentPane.add(menuPanel, "menu");
		contentPane.add(cp, "cp");
        cardLayout.show(contentPane, "menu");         
	}
}
