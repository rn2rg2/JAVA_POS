package com.kosa.pos.swing.menu.Manager;

import javax.swing.JPanel;

public class MenuSidebarManager {
	//싱글톤으로 생성
    private static JPanel jpanel;

    private MenuSidebarManager() {
        // 외부에서 인스턴스 생성 방지
    }

    public static JPanel getmenuSidebarManager() {
        if (jpanel == null) {
        	jpanel = new JPanel();
        }
        return jpanel;
    }
}
