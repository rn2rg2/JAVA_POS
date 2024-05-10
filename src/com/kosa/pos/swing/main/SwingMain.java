package com.kosa.pos.swing.main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.MenuRanking;

public class SwingMain {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		MenuDAO menudao = new MenuDAOImpl();
		
		List<MenuRanking> menurank = menudao.getMenuRanking();
		
		System.out.println(menurank);
	}
}
