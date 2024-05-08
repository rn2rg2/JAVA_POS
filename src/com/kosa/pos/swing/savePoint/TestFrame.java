package com.kosa.pos.swing.savePoint;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	Keyboard keyboard = new Keyboard();

	JPanel panel;

	CardLayout card = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TestFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setTitle("Keyboard Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		Keyboard keyboardPanel = new Keyboard();

		CompletePaymentDialog completePaymentDialog = new CompletePaymentDialog();
		completePaymentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		completePaymentDialog.setModal(true); // Optional: makes the dialog block other windows
		completePaymentDialog.setLocationRelativeTo(this);

		// Show the dialog when needed
		completePaymentDialog.setVisible(true);

		// setVisible(true);
	}

}
