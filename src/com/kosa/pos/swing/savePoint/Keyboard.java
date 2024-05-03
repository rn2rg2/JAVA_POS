package com.kosa.pos.swing.savePoint;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Keyboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel keyboardPane;
	JLabel userInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Keyboard frame = new Keyboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Keyboard() {
		setTitle("Keyboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 700);
		setLocation(500, 500);

		keyboardPane = new JPanel();
		keyboardPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(keyboardPane);
		keyboardPane.setLayout(null);

		/* 상단 패널 */
		JPanel topPanel = new JPanel();
		topPanel.setBounds(154, 39, 600, 139);
		keyboardPane.add(topPanel);
		topPanel.setLayout(null);

		JLabel pleasePhoneLbl = new JLabel("전화번호를 입력해주세요.");
		pleasePhoneLbl.setFont(new Font("굴림", Font.PLAIN, 20));
		pleasePhoneLbl.setBounds(187, 0, 233, 61);
		topPanel.add(pleasePhoneLbl);

		userInput = new JLabel("");
		userInput.setFont(new Font("굴림", Font.PLAIN, 18));
		userInput.setHorizontalAlignment(SwingConstants.CENTER);
		userInput.setBounds(70, 71, 457, 56);
		topPanel.add(userInput);

		/* 중간 패널 */
		JPanel middlePanel = new JPanel();
		middlePanel.setBounds(73, 188, 770, 362);
		keyboardPane.add(middlePanel);
		middlePanel.setLayout(new GridLayout(4, 3, 5, 5));

		JButton oneButton = new JButton("1");
		oneButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(oneButton);

		JButton twoButton = new JButton("2");
		twoButton.setFont(new Font("굴림", Font.PLAIN, 20));
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		middlePanel.add(twoButton);

		JButton threeButton = new JButton("3");
		threeButton.setFont(new Font("굴림", Font.PLAIN, 20));
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		middlePanel.add(threeButton);

		JButton fourButton = new JButton("4");
		fourButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(fourButton);

		JButton fiveButton = new JButton("5");
		fiveButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(fiveButton);

		JButton sixButton = new JButton("6");
		sixButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(sixButton);

		JButton sevenButton = new JButton("7");
		sevenButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(sevenButton);

		JButton eightButton = new JButton("8");
		eightButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(eightButton);

		JButton nineButton = new JButton("9");
		nineButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(nineButton);

		JButton deleteAllButton = new JButton("전체 지우기");
		deleteAllButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(deleteAllButton);

		JButton zeroButton = new JButton("0");
		zeroButton.setFont(new Font("굴림", Font.PLAIN, 20));
		middlePanel.add(zeroButton);

		JButton deleteOneButton = new JButton("하나 지우기");
		deleteOneButton.setFont(new Font("굴림", Font.PLAIN, 20));
		deleteOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		middlePanel.add(deleteOneButton);

		/* 하단 패널 */
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(329, 564, 256, 73);
		keyboardPane.add(bottomPanel);
		bottomPanel.setLayout(new BorderLayout(0, 0));

		JButton submitButton = new JButton("입력");
		submitButton.setFont(new Font("굴림", Font.PLAIN, 18));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bottomPanel.add(submitButton);

		/* 리스너 설정 */
		/* Create an instance of ActionListener */
		KeyboardActionListener actionListener = new KeyboardActionListener(this);

		/* Assign the actionListener to each button */
		oneButton.addActionListener(actionListener);
		twoButton.addActionListener(actionListener);
		threeButton.addActionListener(actionListener);
		fourButton.addActionListener(actionListener);
		fiveButton.addActionListener(actionListener);
		sixButton.addActionListener(actionListener);
		sevenButton.addActionListener(actionListener);
		eightButton.addActionListener(actionListener);
		nineButton.addActionListener(actionListener);
		zeroButton.addActionListener(actionListener);
		deleteAllButton.addActionListener(actionListener);
		deleteOneButton.addActionListener(actionListener);
		submitButton.addActionListener(actionListener);
	}

}
