package com.kosa.pos.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.kosa.pos.dbconnection.DBConnection;

public class UserDAO {
	private Connection conn = DBConnection.getConnection();;
	private CallableStatement stmt = null;

	// parameter로 들어온 전화번호가 DB에 있는지 확인하고, 존재하면 user_id, 없으면 0을 반환
	public int checkPhoneNumExists(long long_userInput) {
		int userId = 0;
		try {
			stmt = conn.prepareCall("{call save_point_pkg.check_phonenum(?, ?)}");
			stmt.setLong(1, long_userInput);
			stmt.registerOutParameter(2, Types.INTEGER);

			stmt.execute();
			userId = stmt.getInt(2);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return userId;
	}

	// 매개변수로 들어온 전화번호를 통해 가입하고, 성공하면 user_id, 실패하면 0을 반환
	public int signUp(long long_userInput) {
		int userId = 0;
		try {
			stmt = conn.prepareCall("{call save_point_pkg.sign_up(?, ?)}");
			stmt.setLong(1, long_userInput);
			stmt.registerOutParameter(2, Types.INTEGER);

			stmt.execute();
			userId = stmt.getInt(2);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return userId;
	}

	public void updateUserId(int userId, int orderId) {
		try {
			stmt = conn.prepareCall("{call user_pkg.update_user_id(?, ?)}");
			stmt.setInt(1, userId);
			stmt.setInt(2, orderId);
			stmt.execute();
			System.out.println("user_order 테이블의 user_id 업데이트 완료");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
}
