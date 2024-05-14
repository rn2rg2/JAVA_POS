package com.kosa.pos.swing.Admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kosa.pos.swing.main.CardLayoutManager;
import com.kosa.pos.swing.main.ContentPaneManager;
import com.kosa.pos.swing.main.Index;

public class AdminLoginKeyboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel userInput;
	JLabel safetyUserInput;
	JButton submitButton;

	public AdminLoginKeyboardPanel(Index index) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setBounds(0, 0, 950, 700);

		/* 상단 패널 */
		JPanel topPanel = new JPanel();
		topPanel.setBounds(175, 20, 600, 100);
		add(topPanel);
		topPanel.setLayout(null);

		JLabel pleasePhoneLbl = new JLabel("비밀번호를 입력해주세요.");
		pleasePhoneLbl.setFont(new Font("굴림", Font.PLAIN, 20));
		pleasePhoneLbl.setBounds(183, 5, 234, 40);
		topPanel.add(pleasePhoneLbl);
		
		safetyUserInput = new JLabel("");
		safetyUserInput.setFont(new Font("굴림", Font.PLAIN, 18));
		safetyUserInput.setHorizontalAlignment(SwingConstants.CENTER);
		safetyUserInput.setBounds(75, 50, 450, 50);
		topPanel.add(safetyUserInput);
		safetyUserInput.setVisible(true);

		userInput = new JLabel("");
		userInput.setFont(new Font("굴림", Font.PLAIN, 18));
		userInput.setHorizontalAlignment(SwingConstants.CENTER);
		userInput.setBounds(75, 50, 450, 50);
		topPanel.add(userInput);
		userInput.setVisible(false);

		/* 중간 패널 */
		JPanel middlePanel = new JPanel();
		middlePanel.setBounds(90, 140, 770, 400);
		middlePanel.setLayout(new GridLayout(4, 3, 5, 5));
		add(middlePanel);

		String[] buttonLabels = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "전체 지우기", "0", "하나 지우기" };
		JButton[] buttons = new JButton[buttonLabels.length];

		for (int i = 0; i < buttonLabels.length; i++) {
			buttons[i] = new JButton(buttonLabels[i]);
			buttons[i].setFont(new Font("굴림", Font.PLAIN, 20));
			middlePanel.add(buttons[i]);
		}

		/* 하단 패널 */
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(347, 560, 256, 50);
		add(bottomPanel);
		bottomPanel.setLayout(new BorderLayout(0, 0));

		submitButton = new JButton("입력");
		submitButton.setFont(new Font("굴림", Font.PLAIN, 18));
		submitButton.setBounds(0, 0, 256, 50);
		bottomPanel.add(submitButton);

		/* 리스너 설정 */
		AdminLoginKeyboardActionListener actionListener = new AdminLoginKeyboardActionListener(this);
		
		JButton btnNewButton = new JButton("뒤로 가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index.setBounds(500,500,1250,700);
				index.setLocationRelativeTo(null);
				CardLayoutManager.getCardLayout().show(ContentPaneManager.getContentPane(), "menu");
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.setBounds(32, 597, 178, 39);
		add(btnNewButton);

		/* Assign the actionListener to each button */
		for (JButton button : buttons) {
			button.addActionListener(actionListener);
		}
		submitButton.addActionListener(actionListener);

		setVisible(true);
	}
}
