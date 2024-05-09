package com.kosa.pos.swing.savePoint;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private JPanel container; // 패널 컨테이너
	private JPanel initialPanel; // 초기 화면 패널 TODO: 추후 결제 화면과 연결해야함.
	private KeyboardPanel keyboardPanel;

	public KeyboardPanel getKeyboard() {
		return keyboardPanel;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestFrame() {
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLocationRelativeTo(null);

		cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		getContentPane().add(container);

		keyboardPanel = new KeyboardPanel();
		initialPanel = new JPanel(); // 초기 화면 설정
		initialPanel.setLayout(new BorderLayout());
		JLabel welcomeLabel = new JLabel("Welcome to the application!", JLabel.CENTER);
		initialPanel.add(welcomeLabel, BorderLayout.CENTER);

		container.add(initialPanel, "Initial");
		container.add(keyboardPanel, "Keyboard");

		CompletePaymentDialog completePaymentDialog = new CompletePaymentDialog();
		completePaymentDialog.setModal(true);
		completePaymentDialog.setVisible(true);
	}

	public void showKeyboardPanel() {
		cardLayout.show(container, "Keyboard");
	}

}
