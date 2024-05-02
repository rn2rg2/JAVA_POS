package com.kosa.pos.swing;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class CompletePayment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompletePayment frame = new CompletePayment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CompletePayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("적립하시겠습니까?");

		JLabel lbDoYouSave = new JLabel("결제 완료!");

		JButton yesButton = new JButton("네");

		JButton noButton = new JButton("아니요");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(183).addComponent(lbDoYouSave)
						.addContainerGap(156, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(68)
						.addComponent(yesButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
						.addComponent(noButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE).addGap(77))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(164, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(150)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(28).addComponent(lbDoYouSave)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(64).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(yesButton).addComponent(noButton))
						.addGap(80)));
		contentPane.setLayout(gl_contentPane);
	}
}
