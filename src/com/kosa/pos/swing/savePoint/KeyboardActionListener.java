package com.kosa.pos.swing.savePoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class KeyboardActionListener implements ActionListener {
	Keyboard superClass;

	public KeyboardActionListener(Keyboard superClass) {
		this.superClass = superClass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str_btnName = ((JButton) e.getSource()).getText();
		String str_userInput = superClass.userInput.getText();

		if ("전체 지우기".equals(str_btnName)) {
			superClass.userInput.setText("");
		} else if ("하나 지우기".equals(str_btnName)) {
			if (str_userInput.length() > 0) {
				int length = str_userInput.length();
				// 마지막 문자가 '-' 앞에 있는지 확인
				if (length > 1 && str_userInput.charAt(length - 2) == '-') {
					// 마지막 문자와 '-' 함께 삭제
					superClass.userInput.setText(str_userInput.substring(0, length - 2));
				} else {
					// 마지막 문자 삭제
					superClass.userInput.setText(str_userInput.substring(0, length - 1));
				}
			}
		} else if ("입력".equals(str_btnName)) {
			// TODO : str_userInput -> int 전환 후, user_info 테이블 업데이트

		} else { // 숫자 버튼 입력
			String newInput = str_userInput + str_btnName;
			superClass.userInput.setText(formatPhoneNumber(newInput));
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
}
