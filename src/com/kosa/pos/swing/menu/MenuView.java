package com.kosa.pos.swing.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.Menu;

public class MenuView extends JPanel {
	MenuDAO menudao = new MenuDAOImpl();
	/**
	 * @wbp.nonvisual location=418,41
	 */

	/**
	 * Create the panel.
	 */

	public MenuView() {
		
		setBackground(new Color(0, 0, 0));

		// 메뉴 패널의 크기를 인덱스 패널과 동일하게 설정

		setPreferredSize(new Dimension(950, 650));
		setLayout(null);

		// 패널 스크롤 부분
		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(6, 92, 735, 552);
		add(mainpanel);
		mainpanel.setLayout(new BorderLayout(0, 0));

		// 카테고리 분류를 통해 메뉴를 여러개 받아온 것을 리스에 저장
		// 리스트에 저장하는 이유는 메뉴 하나는 값 하나당 각 값이 고유하기 때문이다.
		List<Menu> menulist =  menudao.findall();
		List<MenuPanel> menuPanels = new ArrayList<>();

		// MenuPanel을 생성하여 ArrayList에 추가
		for (int i = 0; i < menulist.size(); i++) {	
			MenuPanel menuPanel = new MenuPanel(menulist.get(i).getName());
			menuPanels.add(menuPanel);
		}

		JPanel viewport = new JPanel();
		viewport.setLayout(new GridLayout(0, 4, 10, 10)); // 4개의 열, 간격은 15픽셀
		for (MenuPanel menuPanel : menuPanels) {
			viewport.add(menuPanel);
		}

		JScrollPane scrollPane = new JScrollPane(viewport);
		scrollPane.setPreferredSize(new Dimension(700, 500)); // 스크롤 패널의 크기 제한
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainpanel.add(scrollPane, BorderLayout.CENTER);
		// !패널 스크롤 부분

		JButton Category1 = new JButton("New button");
		Category1.setBounds(0, 0, 123, 40);
		add(Category1);

		JButton Category2 = new JButton("New button");
		Category2.setBounds(0, 40, 123, 40);
		add(Category2);

		JButton Categroy3 = new JButton("New button");
		Categroy3.setBounds(129, 0, 123, 40);
		add(Categroy3);

		JButton Category4 = new JButton("New button");
		Category4.setBounds(129, 40, 123, 40);
		add(Category4);

		JButton Category6 = new JButton("New button");
		Category6.setBounds(264, 40, 123, 40);
		add(Category6);

		JButton Category5 = new JButton("New button");
		Category5.setBounds(264, 0, 123, 40);
		add(Category5);

		// sidebar scroll
		JPanel sidepanel = new JPanel();
		sidepanel.setBounds(753, 92, 190, 420);
		add(sidepanel);
		sidepanel.setLayout(new BorderLayout(0, 0));

		JPanel msbpport = new JPanel();
		msbpport.setLayout(new GridLayout(0, 1, 0, 15)); // 4개의 열, 간격은 15픽셀
		for (int i = 0; i < 10; i++) {
			MenuSidebarPanel msbp = new MenuSidebarPanel();
			msbpport.add(msbp);
		}
		JScrollPane scrollPane_1 = new JScrollPane(msbpport);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sidepanel.add(scrollPane_1, BorderLayout.CENTER);

		scrollPane_1.setPreferredSize(new Dimension(190, 420)); // 스크롤 패널의 크기 제한
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sidepanel.add(scrollPane_1, BorderLayout.CENTER);
		// !sidebar scroll

		// 이미지 아이콘을 생성하고 이미지를 로드합니다.
		
		ImageIcon cancel = new ImageIcon("./img/menu/images.png");
		JButton deletebtn = new JButton(cancel);
		deletebtn.setBounds(753, 562, 191, 40);
		deletebtn.setPreferredSize(new Dimension(cancel.getIconWidth(), cancel.getIconHeight()));
		// 버튼의 크기를 이미지의 크기에 맞게 설정합니다.
		add(deletebtn);

		
		ImageIcon pay = new ImageIcon("./img/menu/diycheckout-payment-button.png");
		JButton paybtn = new JButton(pay);
		paybtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		paybtn.setPreferredSize(new Dimension(pay.getIconWidth(), pay.getIconHeight()));
		paybtn.setBounds(753, 604, 191, 40);
		add(paybtn);

		JButton mgrbtn = new JButton("관리자");
		mgrbtn.setBounds(827, 6, 117, 29);
		add(mgrbtn);

		JLabel Total = new JLabel("New label");
		Total.setForeground(new Color(255, 255, 255));
		Total.setBounds(753, 530, 191, 29);
		add(Total);

	}
}
