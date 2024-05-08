package com.kosa.pos.swing.savePoint;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CompleteSignUp extends JDialog {

	private static final long serialVersionUID = 1L;

	public CompleteSignUp() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblMessage1 = new JLabel("가입 되었습니다!");
		lblMessage1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMessage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage1.setBounds(12, 107, 414, 29);
		getContentPane().add(lblMessage1);

		JButton btnOk = new JButton("적립하기");
		btnOk.setFont(new Font("굴림", Font.PLAIN, 16));
		btnOk.setBounds(156, 181, 124, 42);
		getContentPane().add(btnOk);

		setModal(true); // 다이얼로그가 모달임을 설정하여 다이얼로그 뒤의 윈도우를 클릭할 수 없도록 함

		// TODO
		// 1. "적립하기" 버튼 눌렀을 때 point column update하는 이벤트리스너 생성
		// 2. "적립하기" 버튼 눌렀을 때 "적립 완료" + 적립된 포인트 보여주는 JDialog와 연결
	}

}
