package com.kosa.pos.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.kosa.pos.dbconnection.DBConnection;

public class OrderDAO {
	private Connection conn = DBConnection.getConnection();
	private CallableStatement stmt = null;

	// 사용자가 "결제" 버튼을 눌렀을 때 user_order에 데이터 삽입.
	// 아직 로그인이 된 상태가 아니므로 비회원 주문으로 진행한 뒤, 로그인을 하면 데이터 업데이트 해야 함
	// 비회원 user_id와 해당 주문의 order_id를 반환
	public int[] insertOrder() {
		int[] ids = new int[2];
		try {
			stmt = conn.prepareCall("{call order_pkg.insert_order(?, ?)}");
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.registerOutParameter(2, Types.INTEGER);

			stmt.execute();
			ids[0] = stmt.getInt(1); // userId
			ids[1] = stmt.getInt(2); // orderId

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return ids;
	}

	public void insertOrderDetail(int orderId, int menuId, int quantity) {
		try {
			stmt = conn.prepareCall("{call order_pkg.insert_order_detail(?,?,?)}");
			stmt.setInt(1, orderId);
			stmt.setInt(2, menuId);
			stmt.setInt(3, quantity);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
