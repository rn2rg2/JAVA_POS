package com.kosa.pos.swing.review;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kosa.pos.dao.ReviewDAOImpl;
import com.kosa.pos.swing.common.OrderState;

public class ReviewWriteDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private int menuId;
	private String path;
	private String name;
	private int count;
	private double avg;
	private ReviewDAOImpl reviewDao;
	private JTextField titleField;

	public ReviewWriteDialog(int menuId, String path, String name, int count, double avg) {
		this.path = path;
		this.name = name;
		this.count = count;
		this.avg = avg;
		reviewDao = new ReviewDAOImpl();

		setModal(true);

		setBounds(100, 100, 750, 450);
		getContentPane().setLayout(null);

		ImageIcon imgpath = new ImageIcon(path);
		Image img = imgpath.getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING);
		imgpath = new ImageIcon(img);
		JLabel imgLabel = new JLabel(imgpath);
		imgLabel.setBounds(30, 30, 150, 150);
		getContentPane().add(imgLabel);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(195, 30, 500, 150);
		getContentPane().add(contentPanel);

		JLabel menuNameLabel = new JLabel(name);
		menuNameLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		menuNameLabel.setBounds(12, 21, 301, 50);
		contentPanel.add(menuNameLabel);

		JLabel orderCountLabel = new JLabel("주문 수:");
		orderCountLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		orderCountLabel.setBounds(12, 89, 80, 39);
		contentPanel.add(orderCountLabel);

		JLabel orderCount = new JLabel(String.valueOf(count));
		orderCount.setHorizontalAlignment(SwingConstants.CENTER);
		orderCount.setFont(new Font("굴림", Font.PLAIN, 20));
		orderCount.setBounds(92, 89, 99, 39);
		contentPanel.add(orderCount);

		JLabel ratingAvgLabel = new JLabel("별점 평균:");
		ratingAvgLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		ratingAvgLabel.setBounds(222, 89, 99, 39);
		contentPanel.add(ratingAvgLabel);

		JLabel ratingAvg = new JLabel(String.format("%.2f", avg));
		ratingAvg.setHorizontalAlignment(SwingConstants.CENTER);
		ratingAvg.setFont(new Font("굴림", Font.PLAIN, 20));
		ratingAvg.setBounds(328, 89, 99, 39);
		contentPanel.add(ratingAvg);

		JButton submitButton = new JButton("제출하기");
		submitButton.setBounds(391, 63, 97, 23);
		contentPanel.add(submitButton);

		// 별점 라디오 버튼 생성
		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton oneRadioButton = new JRadioButton("1");
		oneRadioButton.setBounds(30, 201, 40, 23);
		oneRadioButton.setActionCommand("1");
		getContentPane().add(oneRadioButton);

		JRadioButton twoRadioButton = new JRadioButton("2");
		twoRadioButton.setBounds(74, 201, 40, 23);
		twoRadioButton.setActionCommand("2");
		getContentPane().add(twoRadioButton);

		JRadioButton threeRadioButton = new JRadioButton("3");
		threeRadioButton.setBounds(118, 201, 40, 23);
		threeRadioButton.setActionCommand("3");
		getContentPane().add(threeRadioButton);

		JRadioButton fourRadioButton = new JRadioButton("4");
		fourRadioButton.setBounds(162, 201, 40, 23);
		fourRadioButton.setActionCommand("4");
		getContentPane().add(fourRadioButton);

		JRadioButton fiveRadioButton = new JRadioButton("5");
		fiveRadioButton.setBounds(206, 201, 40, 23);
		fiveRadioButton.setActionCommand("5");
		getContentPane().add(fiveRadioButton);

		buttonGroup.add(oneRadioButton);
		buttonGroup.add(twoRadioButton);
		buttonGroup.add(threeRadioButton);
		buttonGroup.add(fourRadioButton);
		buttonGroup.add(fiveRadioButton);

		titleField = new JTextField();
		titleField.setBounds(30, 231, 432, 36);
		getContentPane().add(titleField);
		titleField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("");
		textArea.setBounds(30, 277, 665, 124);
		getContentPane().add(textArea);

		// 이벤트 리스너 설정
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRating = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
				reviewDao.insertReview(titleField.getText(), textArea.getText(), selectedRating, menuId,
						OrderState.getOrderId());
				dispose();
			}
		});
	}
}
