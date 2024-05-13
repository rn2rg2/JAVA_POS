package com.kosa.pos.swing.signUp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.kosa.pos.dao.UserDAO;
import com.kosa.pos.swing.common.OrderState;
import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;

public class CompleteSignUpDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	UserDAO userDao = new UserDAO();

	public CompleteSignUpDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblMessage1 = new JLabel("가입 되었습니다!");
		lblMessage1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMessage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage1.setBounds(12, 107, 414, 29);
		getContentPane().add(lblMessage1);

		JButton btnOk = new JButton("적립하기");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = OrderState.getUserId();
				int orderId = OrderState.getOrderId();
				userDao.updateUserId(userId, orderId); // 가입 후 부여받은 user_id로 user_order 테이블의 user_id를 업데이트

				dispose();
				CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "review");
			}
		});
		btnOk.setFont(new Font("굴림", Font.PLAIN, 16));
		btnOk.setBounds(156, 181, 124, 42);
		getContentPane().add(btnOk);

		setModal(true); // 다이얼로그가 모달임을 설정하여 다이얼로그 뒤의 윈도우를 클릭할 수 없도록 함

		// TODO
		// "적립하기" 버튼 눌렀을 때 "적립 완료" + 적립된 포인트 보여주는 JDialog와 연결
	}

}
