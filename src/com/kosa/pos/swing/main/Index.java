package com.kosa.pos.swing.main;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kosa.pos.swing.menu.MenuView;

public class Index extends JFrame {
	private JPanel contentPane;
    private CardLayout cardLayout;
    
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 950, 700);
		cardLayout = CardLayoutManager.getCardLayout();
		contentPane = new JPanel(cardLayout);
		
		
		add(contentPane);
		MenuView menuPanel = new MenuView();
		contentPane.add(menuPanel, "menu");
        cardLayout.show(contentPane, "menu");
              
	}
	public void showCard(String cardName) {
	    cardLayout.show(contentPane, cardName);
	}
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
	public JPanel getContentpane() {
		return this.contentPane;
	}
}
