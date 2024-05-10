package com.kosa.pos.swing.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;

public class MenuPanel extends JPanel {
	private MenuSidebarPanel msbp = new MenuSidebarPanel(); // SidebarPanelManager.getSidebarPanelManager();

	/**
	 * Create the panel.
	 */
	;
	JLabel menu_name;
	static Map<String, Integer> menuTotalPriceMap = new HashMap<>(); // 메뉴별 총 가격을 저장할 맵

	public MenuPanel(String menuname, int price, JPanel msbpport, int menuId) {
		setBackground(new Color(254, 255, 255));
		setBorder(new LineBorder(new Color(207, 201, 214)));
		setLayout(null);
		setPreferredSize(new Dimension(170, 274));
		// System.out.println("menuname : "+ menuname + " 가격 : "+ price );

		JButton menu_minus = new JButton("-");
		menu_minus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = MenuView.getClickCount(menuname);
				count--;

				if (count < 0) {
					count = 0;
				} // 클릭 횟수 감소 및 0 이하로 내려가지 않게 하기
				menuTotalPriceMap.put(menuname, price * count);
				calculateTotalOrderPrice(menuname, price, count);
				MenuView.updateClickCount(menuname, count);
				if (count == 0) {
					MenuView.removeMenuSidebarPanel(menuname); // 클릭 횟수가 0이면 해당 메뉴의 사이드바 제거
				} else {
					MenuSidebarPanel msbp = MenuView.getMenuSidebarPanel(menuname);
					msbp.updateSidebarminus(count, price); // 사이드바 업데이트
					msbpport.add(msbp, 0); // 변경된 MenuSidebarPanel을 패널의 맨 위에 추; // 변경된 MenuSidebarPanel 추가
					msbpport.revalidate(); // 레이아웃 갱신
					msbpport.repaint(); // 변경된 내용을 다시 그림
				}
				System.out.println(count);
				System.out.println(price);
			}
		});

		JButton menu_plus = new JButton("+");
		menu_plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = MenuView.getClickCount(menuname);
				count++; // 클릭 횟수 증가
				MenuView.updateClickCount(menuname, count);
				MenuSidebarPanel msbp = MenuView.getMenuSidebarPanel(menuname);
				if (msbp == null) {
					msbp = new MenuSidebarPanel();
					MenuView.addMenuSidebarPanel(menuname, msbp); // Add the MenuSidebarPanel to MenuView
				}

				msbp.updateSidebar(count, menuname, price); // 사이드바 업데이트
				calculateTotalOrderPrice(menuname, count, price);
				msbpport.add(msbp, 0); // 변경된 MenuSidebarPanel을 패널의 맨 위에 추가 // 변경된 MenuSidebarPanel 추가
				msbpport.revalidate(); // 레이아웃 갱신
				msbpport.repaint(); // 변경된 내용을 다시 그림

			}
		});
		menu_plus.setBounds(89, 239, 77, 29);
		add(menu_plus);

		menu_minus.setBounds(0, 239, 77, 29);
		add(menu_minus);

		menu_name = new JLabel(menuname);
		menu_name.setHorizontalAlignment(SwingConstants.CENTER);
		menu_name.setBounds(0, 168, 170, 29);
		add(menu_name);

		JLabel menu_img = new JLabel("New label");
		menu_img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("이미지 눌림");
//				MenuDetailPanel mdp = new MenuDetailPanel(menuId);
//				mdp.setName("mdp");
//				Component[] compList = ContentPaneManager.getContentPane().getComponents();
//				for(Component c : compList) {
//					if(c.getName() != null && c.getName().equals("mdp")) {
//						System.out.println("sss");
//						ContentPaneManager.getContentPane().remove(c);
//						break;
//					}
//				}
//					
//				ContentPaneManager.getContentPane().add(mdp,"menudetail");
				CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "menudetail");
				
			}
		});
		menu_img.setHorizontalAlignment(SwingConstants.CENTER);
		menu_img.setBounds(0, 0, 170, 156);
		add(menu_img);

		

		JLabel menu_price = new JLabel(Integer.toString(price));
		menu_price.setHorizontalAlignment(SwingConstants.CENTER);
		menu_price.setBounds(0, 209, 170, 29);
		add(menu_price);

	}

	public void calculateTotalOrderPrice(String menuname, int price, int count) {
		menuTotalPriceMap.put(menuname, price * count);
		int totalOrderPrice = 0;
		for (int prices : MenuPanel.menuTotalPriceMap.values()) {
			totalOrderPrice += prices;
		}
		MenuView.Total.setText(Integer.toString(totalOrderPrice) + "원");
	}

	// 메뉴 총 가격이 1 이상인 개수를 세는 메서드
	// 이렇게 하면 사이드바에 몇개가 추가 됐는지 대략 알 수 있게 된다.
}
