package com.kosa.pos.swing.main;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ContentPaneManager {
	private static JPanel contentpane;

    private ContentPaneManager() {
        // 외부에서 인스턴스 생성 방지
    }

    public static JPanel getContentPane() {
        if (contentpane == null) {
        	contentpane = new JPanel(CardLayoutManager.getCardLayout());
        }
        return contentpane;
    }
}
