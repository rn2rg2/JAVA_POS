package com.kosa.pos.swing.Admin;

import com.kosa.pos.swing.main.Index;

public class IndexManager {
	//싱글톤으로 생성 - cardlayout.show 를 해야 되는데 새로운 객체 생성시 cardlayout이 초기화 되기 때문
    private static Index index;

    private IndexManager() {
        // 외부에서 인스턴스 생성 방지
    }

    public static Index getIndex() {
        return index;
    }
    public static void setIndex(Index idx) {
    	index = idx;
    }
}
