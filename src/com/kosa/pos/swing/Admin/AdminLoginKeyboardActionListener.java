package com.kosa.pos.swing.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;
import com.kosa.pos.swing.savePoint.InvalidPhoneNumDialog;
import com.kosa.pos.swing.savePoint.NotRegisteredDialog;

public class AdminLoginKeyboardActionListener implements ActionListener  {
	AdminLoginKeyboardPanel superClass;
	private long adminInfo = 1012345678; // admin로그인 정보

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
				if (rawNumber.length() == 0 || rawNumber.charAt(0) != '0' || rawNumber.length() != 11) {
					System.out.println("유효하지 않은 전화번호");
					InvalidPhoneNumDialog ipn = new InvalidPhoneNumDialog();
					ipn.setVisible(true);

					superClass.userInput.setText("");
					superClass.safetyUserInput.setText("");

					return;
				}

				long long_userInput = Long.parseLong(rawNumber); // 숫자 변환을 long 처리

//				UserDAO userDao = new UserDAO();

				// 가입된 전화번호인지 확인
//				int exists = userDao.checkPhoneNumExists(long_userInput);
				
				

				if (adminInfo == long_userInput) { // 입력된 정보가 관리자 계정인 경우
					CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "adminPanel");
					superClass.userInput.setText("");
					superClass.safetyUserInput.setText("");
				} else { // 가입 안 된 전화번호
					InvalidPhoneNumDialog ipn = new InvalidPhoneNumDialog("번호가 일치하지 않습니다.");
					ipn.setVisible(true);
				}
			} else { // 숫자 버튼 입력
				String newInput = str_userInput + str_btnName;
				superClass.userInput.setText(formatPhoneNumber(newInput));
				superClass.safetyUserInput.setText(safetyFormatPhoneNumber(newInput));
			}
		} catch (NumberFormatException ex) {
			System.err.println("입력된 전화번호가 유효하지 않습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private String formatPhoneNumber(String rawNumber) {
		// 기존에 추가 되어있는 '-' 기호 제거
		rawNumber = rawNumber.replaceAll("-", "");

		StringBuilder formatted = new StringBuilder();
		for (int i = 0; i < rawNumber.length(); i++) {
			formatted.append(rawNumber.charAt(i));

			// 3번째, 7번째 문자 앞에 '-' 기호 추가
			if (i == 2 || i == 6) {
				formatted.append("-");
			}

			// 문자열 길이가 11이 되면 더이상 입력 불가
			if (i == 10)
				break;
		}
		return formatted.toString();
	}
	
	private String safetyFormatPhoneNumber(String rawNumber) {
		// 기존에 추가 되어있는 '-' 기호 제거
		rawNumber = rawNumber.replaceAll("-", "");

		StringBuilder formatted = new StringBuilder();
		for (int i = 0; i < rawNumber.length(); i++) {
			formatted.append("*");

			// 3번째, 7번째 문자 앞에 '-' 기호 추가
			if (i == 2 || i == 6) {
				formatted.append("-");
			}

			// 문자열 길이가 11이 되면 더이상 입력 불가
			if (i == 10)
				break;
		}
		return formatted.toString();
	}
}
