package com.kosa.pos.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Sample extends JFrame{
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Scroll Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JTextArea 생성
        JTextArea textArea = new JTextArea(10, 20);
        
        // JScrollPane에 JTextArea 추가
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // JFrame에 JScrollPane 추가
        frame.getContentPane().add(scrollPane);
        
        // 프레임 크기 조절
        frame.pack();
        
        // 가운데 정렬
        frame.setLocationRelativeTo(null);
        
        // 프레임 표시
        frame.setVisible(true);
    }
}