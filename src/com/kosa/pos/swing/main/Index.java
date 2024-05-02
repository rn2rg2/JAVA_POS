package com.kosa.pos.swing.main;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kosa.pos.swing.menu.Menu;

import lombok.Data;

public class Index extends JFrame {
	private JPanel contentPane;
    private CardLayout cardLayout;
    
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 950, 700);
		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane);
		Menu menuPanel = new Menu();
        //CardLayout cardLayout = new CardLayout();
        //contentPane.setLayout(cardLayout);
        contentPane.add(menuPanel, "menu");
        cardLayout.show(contentPane, "menu");
              
	}
	public void setPanel(JPanel panel, String str) {
    	this.contentPane.add(panel, str);
    }
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
	public JPanel getContentpane() {
		return this.contentPane;
	}
}
