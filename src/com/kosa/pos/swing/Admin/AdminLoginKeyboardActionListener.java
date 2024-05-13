package com.kosa.pos.swing.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;
import com.kosa.pos.swing.signUp.InvalidPhoneNumDialog;
import com.kosa.pos.swing.signUp.NotRegisteredDialog;

public class AdminLoginKeyboardActionListener implements ActionListener  {
	AdminLoginKeyboardPanel superClass;
	private long adminInfo = 1234; // admin로그인 정보

	public AdminLoginKeyboardActionListener(AdminLoginKeyboardPanel superClass) {
		this.superClass = superClass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String str_btnName = ((JButton) e.getSource()).getText();
			String str_userInput = superClass.userInput.getText();
			String str_safetyUserInput = superClass.safetyUserInput.getText();

			if ("전체 지우기".equals(str_btnName)) {
				superClass.userInput.setText("");
				superClass.safetyUserInput.setText("");
			} else if ("하나 지우기".equals(str_btnName)) {
				if (str_userInput.length() > 0) {
					int length = str_userInput.length();
					// 마지막 문자가 '-' 앞에 있는지 확인
					if (length > 1 && str_userInput.charAt(length - 2) == '-') {
						superClass.userInput.setText(str_userInput.substring(0, length - 2));
						superClass.safetyUserInput.setText(str_safetyUserInput.substring(0, length - 2));
					} else if (length > 1 && str_userInput.charAt(length - 1) == '-') {
						superClass.userInput.setText(str_userInput.substring(0, length - 2));
						superClass.safetyUserInput.setText(str_safetyUserInput.substring(0, length - 2));
						
					} else {
						superClass.userInput.setText(str_userInput.substring(0, length - 1));
						superClass.safetyUserInput.setText(str_safetyUserInput.substring(0, length - 1));
					}
				}
			} else if ("입력".equals(str_btnName)) {
				String rawNumber = str_userInput.replaceAll("-", "");

				/* 입력 유효성 확인 */
				if (rawNumber.length() == 0) {
					InvalidPhoneNumDialog ipn = new InvalidPhoneNumDialog("비밀번호가 잘못됐습니다");
					ipn.setVisible(true);

					superClass.userInput.setText("");
					superClass.safetyUserInput.setText("");

					return;
				}

				long long_userInput = Long.parseLong(rawNumber); // 숫자 변환을 long 처리

				if (adminInfo == long_userInput) { // 입력된 정보가 관리자 계정인 경우
					CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "adminPanel");
					superClass.userInput.setText("");
					superClass.safetyUserInput.setText("");
				} else { // 가입 안 된 전화번호
					InvalidPhoneNumDialog ipn = new InvalidPhoneNumDialog("비밀번호가 일치하지 않습니다.");
					ipn.setVisible(true);
				}
			} else { // 숫자 버튼 입력
				String newInput = str_userInput + str_btnName;
				superClass.userInput.setText(formatPhoneNumber(newInput));
				superClass.safetyUserInput.setText(safetyFormatPhoneNumber(newInput));
				System.out.println(newInput);
			}
		} catch (NumberFormatException ex) {
			System.err.println("입력된 전화번호가 유효하지 않습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private String formatPhoneNumber(String rawNumber) {

		StringBuilder formatted = new StringBuilder();
		for (int i = 0; i < rawNumber.length(); i++) {
			formatted.append(rawNumber.charAt(i));
		}
		return formatted.toString();
	}
	
	private String safetyFormatPhoneNumber(String rawNumber) {
		StringBuilder formatted = new StringBuilder();
		for (int i = 0; i < rawNumber.length(); i++) {
			formatted.append("*");
		}
		return formatted.toString();
	}
}
