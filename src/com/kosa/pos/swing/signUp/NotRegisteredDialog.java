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

public class NotRegisteredDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public NotRegisteredDialog(long long_userInput) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblMessage1 = new JLabel("가입되어 있지 않습니다.");
		lblMessage1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMessage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage1.setBounds(12, 74, 414, 29);
		getContentPane().add(lblMessage1);

		JLabel lblMessage2 = new JLabel("가입하시겠습니까?");
		lblMessage2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMessage2.setBounds(12, 125, 414, 29);
		getContentPane().add(lblMessage2);

		JButton btnYes = new JButton("네");
		btnYes.setFont(new Font("굴림", Font.PLAIN, 16));
		btnYes.setBounds(73, 195, 124, 42);
		getContentPane().add(btnYes);

		JButton btnNo = new JButton("아니요");
		btnNo.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNo.setBounds(229, 195, 124, 42);
		getContentPane().add(btnNo);

		setModal(true); // 다이얼로그가 모달임을 설정하여 다이얼로그 뒤의 윈도우를 클릭할 수 없도록 함

		/* 리스너 설정 */
		/* "네" 버튼 */
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserDAO userDao = new UserDAO();
				int userId = userDao.signUp(long_userInput); // 새로 회원가입한 user_id
				OrderState.setUserId(userId); // CompleteSignUpDialog에 userId 넘겨주기 위한 static 변수 업데이트

				if (userId != 0) {
					System.out.println("회원가입 완료");
					CompleteSignUpDialog csu = new CompleteSignUpDialog();
					csu.setVisible(true);
				}

			}
		});

		/* "아니요" 버튼 */
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "menu");
			}
		});
	}
}
