package com.kosa.pos.swing;

import java.awt.EventQueue;
import java.util.List;

import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.Menu;

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
		// 메뉴 데이터 테스트
		MenuDAO menudao = new MenuDAOImpl();
		List<Menu> mlist = menudao.findall();
		System.out.println(mlist);
	}
}
