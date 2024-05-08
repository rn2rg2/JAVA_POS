package com.kosa.pos.swing.savePoint;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class CompletePaymentDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public CompletePaymentDialog() {
		setBackground(new Color(128, 255, 255)); // 패널의 배경색 설정
		setLayout(null); // 절대 위치 지정을 위해 null 레이아웃 사용
		setSize(627, 458); // 패널의 크기 설정

		JLabel lblCompletePayment = new JLabel("결제 완료!");
		lblCompletePayment.setFont(new Font("굴림", Font.PLAIN, 20));
		lblCompletePayment.setBounds(262, 139, 103, 54); // 위치 조정
		add(lblCompletePayment);

		JLabel lblDoYouSave = new JLabel("적립하시겠습니까?");
		lblDoYouSave.setFont(new Font("굴림", Font.PLAIN, 20));
		lblDoYouSave.setBounds(225, 196, 176, 63); // 위치 조정
		add(lblDoYouSave);

		JButton yesButton = new JButton("네");
		yesButton.setFont(new Font("굴림", Font.PLAIN, 17));
		yesButton.setBounds(118, 269, 147, 54); // 위치 조정
		add(yesButton);

		JButton noButton = new JButton("아니요");
		noButton.setFont(new Font("굴림", Font.PLAIN, 17));
		noButton.setBounds(362, 269, 147, 54); // 위치 조정
		add(noButton);
	}
}
