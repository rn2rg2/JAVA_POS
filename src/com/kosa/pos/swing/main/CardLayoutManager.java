package com.kosa.pos.swing.main;

import java.awt.CardLayout;

public class CardLayoutManager {
	//싱글톤으로 생성 - cardlayout.show 를 해야 되는데 새로운 객체 생성시 cardlayout이 초기화 되기 때문
    private static CardLayout cardLayout;

    private CardLayoutManager() {
        // 외부에서 인스턴스 생성 방지
    }

    public static CardLayout getCardLayout() {
        if (cardLayout == null) {
            cardLayout = new CardLayout();
        }
        return cardLayout;
    }
}
