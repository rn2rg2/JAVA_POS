package com.kosa.pos.swing.savePoint;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompletePayment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CompletePayment frame = new CompletePayment();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CompletePayment() {
		setTitle("Complete Payment");
		setSize(950, 700);
		setLocation(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xEDEDED));

		Container c = getContentPane();
		c.setBackground(Color.LIGHT_GRAY);

		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(186, 145, 548, 337);
		getContentPane().add(centerPanel);
		centerPanel.setLayout(null);

		JLabel lblCompletePayment = new JLabel("결제 완료!");
		lblCompletePayment.setFont(new Font("굴림", Font.PLAIN, 20));
		lblCompletePayment.setBounds(219, 72, 103, 54);
		centerPanel.add(lblCompletePayment);

		JLabel lblDoYouSave = new JLabel("적립하시겠습니까?");
		lblDoYouSave.setFont(new Font("굴림", Font.PLAIN, 20));
		lblDoYouSave.setBounds(186, 116, 188, 63);
		centerPanel.add(lblDoYouSave);

		JButton yesButton = new JButton("네");
		yesButton.setFont(new Font("굴림", Font.PLAIN, 17));
		yesButton.setBounds(75, 222, 147, 54);
		centerPanel.add(yesButton);

		JButton noButton = new JButton("아니요");
		noButton.setFont(new Font("굴림", Font.PLAIN, 17));
		noButton.setBounds(319, 222, 147, 54);
		centerPanel.add(noButton);

	}
}
