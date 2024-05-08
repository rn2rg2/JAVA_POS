package com.kosa.pos.swing.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.kosa.pos.dao.MenuDAO;
import com.kosa.pos.dao.MenuDAOImpl;
import com.kosa.pos.dto.Menu;
import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;

public class MenuView extends JPanel {
	MenuDAO menudao = new MenuDAOImpl();
	/**
	 * @wbp.nonvisual location=418,41
	 */

	/**
	 * Create the panel.
	 */

	JPanel mainpanel = new JPanel();
	static JPanel msbpport = new JPanel(); // menusidebar 를 위해서 위에 생성
	MenuPanel menuPanel;
	private List<MenuPanel> menuPanels = new ArrayList<>(); // 기존에 생성된 MenuPanel을 저장하기 위한 리스트
	private static Map<String, Integer> clickCountManager = new HashMap<>();
	private static Map<String, MenuSidebarPanel> sidebarPanels = new HashMap<>(); // Map to store MenuSidebarPanels by menu name
	private static List<String> sidebarOrder = new ArrayList<>();
	static JLabel Total = new JLabel(0+" 원");
	public MenuView() {

		setBackground(new Color(0, 0, 0));

		// 메뉴 패널의 크기를 인덱스 패널과 동일하게 설정

		setPreferredSize(new Dimension(950, 650));
		setLayout(null);

		// 메뉴 스크롤 부분

		mainpanel.setBounds(6, 92, 735, 552);
		add(mainpanel);
		mainpanel.setLayout(new BorderLayout(0, 0));

		// 카테고리 분류를 통해 메뉴를 여러개 받아온 것을 리스에 저장
		// 리스트에 저장하는 이유는 메뉴 하나는 값 하나당 각 값이 고유하기 때문이다.
		List<Menu> menulist = menudao.findByCategory("돈카츠");
		List<MenuPanel> menuPanels = new ArrayList<>();

		// MenuPanel을 생성하여 ArrayList에 추가
		for (int i = 0; i < menulist.size(); i++) {
			menuPanel = new MenuPanel(menulist.get(i).getName(), menulist.get(i).getPrice(), msbpport);
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
		// !메뉴 스크롤 부분

		// 카테고리 버튼
		JButton Category1 = new JButton("돈카츠");
		Category1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMenuByCategory("돈카츠");
			}
		});
		Category1.setBounds(0, 0, 123, 40);
		add(Category1);

		JButton Category2 = new JButton("마제소바");
		Category2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMenuByCategory("마제소바");
			}
		});
		Category2.setBounds(0, 40, 123, 40);
		add(Category2);

		JButton Category3 = new JButton("냉소바");
		Category3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMenuByCategory("냉소바");
			}
		});
		Category3.setBounds(129, 0, 123, 40);
		add(Category3);

		JButton Category4 = new JButton("온소바");
		Category4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMenuByCategory("온소바");
			}
		});
		Category4.setBounds(129, 40, 123, 40);
		add(Category4);

		JButton Category6 = new JButton("우동");
		Category6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMenuByCategory("우동");
			}
		});
		Category6.setBounds(264, 40, 123, 40);
		add(Category6);

		JButton Category5 = new JButton("음료");
		Category5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMenuByCategory("음료");
			}
		});
		Category5.setBounds(264, 0, 123, 40);
		add(Category5);
		// !카테고리 버튼

		// sidebar scroll
		JPanel sidepanel = new JPanel();
		sidepanel.setLayout(new BoxLayout(sidepanel, BoxLayout.Y_AXIS));
		sidepanel.setBounds(753, 92, 190, 420);
		add(sidepanel);
		msbpport.setLayout(new GridLayout(0, 1, 0, 15)); // Set the layout here
//		JPanel msbpport = new JPanel();
//		msbpport.setLayout(new GridLayout(0, 1, 0, 15)); // 4개의 열, 간격은 15픽셀
//		for (int i = 0; i < 10; i++) {
//			MenuSidebarPanel msbp = new MenuSidebarPanel();
//			msbpport.add(msbp);
//		}

		JScrollPane scrollPane_1 = new JScrollPane(msbpport);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sidepanel.add(scrollPane_1, BorderLayout.CENTER);
		// !sidebar scroll

		// 장바구니 & 결제 버튼
		ImageIcon cancel = new ImageIcon("./img/menu/images.png");
		JButton deletebtn = new JButton(cancel);
		deletebtn.setBounds(753, 562, 191, 40);
		deletebtn.setPreferredSize(new Dimension(cancel.getIconWidth(), cancel.getIconHeight()));
		// 버튼의 크기를 이미지의 크기에 맞게 설정합니다.
		add(deletebtn);

		ImageIcon pay = new ImageIcon("./img/menu/diycheckout-payment-button.png");
		JButton paybtn = new JButton(pay);
		paybtn.addActionListener(
				e -> CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "cp"));
		paybtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		paybtn.setPreferredSize(new Dimension(pay.getIconWidth(), pay.getIconHeight()));
		paybtn.setBounds(753, 604, 191, 40);
		add(paybtn);
		// !장바구니 & 결제 버튼

		JButton mgrbtn = new JButton("관리자");
		mgrbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mgrbtn.setBounds(827, 6, 117, 29);
		add(mgrbtn);

		
		Total.setForeground(new Color(255, 255, 255));
		Total.setBounds(753, 530, 191, 29);
		add(Total);
	}

	private void loadMenuByCategory(String category) {
		System.out.println(category + " 눌림");
		List<Menu> menulist = menudao.findByCategory(category);
		menuPanels = new ArrayList<>();

		for (int i = 0; i < menulist.size(); i++) {
			menuPanel = new MenuPanel(menulist.get(i).getName(), menulist.get(i).getPrice(), msbpport); // msbpport
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

		// 메뉴를 새로 로드할 때 기존에 있는 메뉴 패널을 지우고 새로운 메뉴 패널을 추가합니다.
		mainpanel.removeAll();
		mainpanel.add(scrollPane, BorderLayout.CENTER);
		mainpanel.revalidate();
		mainpanel.repaint();
	}

	public static int getClickCount(String menuName) {
		return clickCountManager.getOrDefault(menuName, 0);
	}

	// Method to update click count for a menu item
	public static void updateClickCount(String menuName, int count) {
		clickCountManager.put(menuName, count);
	}

	public static MenuSidebarPanel getMenuSidebarPanel(String menuName) {
		return sidebarPanels.get(menuName);
	}

	// Method to add a MenuSidebarPanel for a menu name
	public static void addMenuSidebarPanel(String menuName, MenuSidebarPanel panel) {
		sidebarPanels.put(menuName, panel); // Add the panel to the map
		msbpport.add(panel); // Add the panel to the container
	}

	// Method to remove a MenuSidebarPanel for a menu name
	public static void removeMenuSidebarPanel(String menuName) {
		MenuSidebarPanel sidebarPanel = sidebarPanels.remove(menuName); // 해당 메뉴 이름을 키로 사용하여 사이드바 제거
		if (sidebarPanel != null) {
			msbpport.remove(sidebarPanel); // 컨테이너에서 사이드바 제거
			msbpport.revalidate();
			msbpport.repaint();
		}
	}

	// Get the order of the sidebar panels
	public static List<String> getSidebarOrder() {
		return sidebarOrder;
	}
	public static void moveSidebarPanelToBottom(String menuName) {
        sidebarOrder.remove(menuName);
        sidebarOrder.add(menuName);
    }
	
}
