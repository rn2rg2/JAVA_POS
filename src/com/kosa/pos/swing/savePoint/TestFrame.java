package com.kosa.pos.swing.savePoint;

import java.awt.CardLayout;
import java.awt.EventQueue;

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
		getContentPane().setLayout(new CardLayout(0, 0));

		Keyboard keyboardPanel = new Keyboard();
		getContentPane().add(keyboardPanel, "name_1550764315052300");

		setVisible(true);
	}

}
