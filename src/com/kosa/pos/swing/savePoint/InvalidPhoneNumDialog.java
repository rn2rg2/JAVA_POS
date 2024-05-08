package com.kosa.pos.swing.savePoint;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InvalidPhoneNumDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public InvalidPhoneNumDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblMessage = new JLabel("유효하지 않은 전화번호입니다.");
		lblMessage.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(12, 111, 414, 29);
		getContentPane().add(lblMessage);

		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 다이얼로그를 닫는 메서드
			}
		});
		btnClose.setBounds(170, 227, 89, 23);
		getContentPane().add(btnClose);

		setModal(true); // 다이얼로그가 모달임을 설정하여 다이얼로그 뒤의 윈도우를 클릭할 수 없도록 함
	}

}
