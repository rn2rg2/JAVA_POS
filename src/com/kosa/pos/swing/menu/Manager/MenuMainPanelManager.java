package com.kosa.pos.swing.menu.Manager;

import javax.swing.JPanel;

public class MenuMainPanelManager {
	private static JPanel jpanel;
	
	private MenuMainPanelManager() {}
	
	public static JPanel getMenuMainPanelManager() {
		if(jpanel == null) {
			jpanel = new JPanel();
		}
		return jpanel;
	}

}
