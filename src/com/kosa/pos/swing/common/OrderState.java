package com.kosa.pos.swing.common;

// 결제 후 만들어지는 user_order 테이블 데이터의 user_id 를 전단하기 위한 클래스 
public class OrderState {
	private static int currentOrderId;
	private static int currentUserId;

	public static void setOrderId(int orderId) {
		currentOrderId = orderId;
	}

	public static int getOrderId() {
		return currentOrderId;
	}

	public static void setUserId(int userId) {
		currentUserId = userId;
	}

	public static int getUserId() {
		return currentUserId;
	}
}
