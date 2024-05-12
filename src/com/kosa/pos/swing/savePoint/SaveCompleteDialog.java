package com.kosa.pos.swing.savePoint;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;

public class SaveCompleteDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public SaveCompleteDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblMessage = new JLabel("적립이 완료되었습니다!");
		lblMessage.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(12, 111, 414, 29);
		getContentPane().add(lblMessage);

		JButton btnClose = new JButton("닫기");
		btnClose.setBounds(170, 227, 89, 23);
		getContentPane().add(btnClose);

		setModal(true); // 다이얼로그가 모달임을 설정하여 다이얼로그 뒤의 윈도우를 클릭할 수 없도록 함

		/* 리스너 설정 */
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 다이얼로그를 닫는 메서드
				CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "review");
			}
		});
	}
	// TODO
	// 몇 포인트 적립 됐는지 보여주는 JLabel 추가하기
}
