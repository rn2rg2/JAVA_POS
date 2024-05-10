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
	// 아직 로그인이 된 상태가 아니므로 비회원 주문으로 진행한 뒤, 로그인을 하면 데이터 업데이트
	// 비회원 user_id를 반환
	public int insertOrder() {
		int userId = 0;
		try {
			stmt = conn.prepareCall("{call order_pkg.insert_order(?)}");
			stmt.registerOutParameter(1, Types.INTEGER);

			stmt.execute();
			userId = stmt.getInt(1);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return userId;
	}
}
