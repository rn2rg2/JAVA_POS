package com.kosa.pos.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.kosa.pos.dbconnection.DBConnection;

public class UserDAO {
	private Connection conn = DBConnection.getConnection();;
	private CallableStatement stmt = null;

	// parameter로 들어온 전화번호가 DB에 있는지 확인하고, 존재하면 1, 없으면 0을 반환
	public int checkPhoneNumExists(long long_userInput) {
		int exists = 0;
		try {
			stmt = conn.prepareCall("{call save_point_pkg.check_phonenum(?, ?)}");
			stmt.setLong(1, long_userInput);
			stmt.registerOutParameter(2, Types.INTEGER);

			stmt.execute();
			exists = stmt.getInt(2);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return exists;
	}

	public int signUp(long long_userInput) {
		int isSuccess = 0;
		try {
			stmt = conn.prepareCall("{call save_point_pkg.sign_up(?, ?)}");
			stmt.setLong(1, long_userInput);
			stmt.registerOutParameter(2, Types.INTEGER);

			stmt.execute();
			isSuccess = stmt.getInt(2);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return isSuccess;
	}
	
}
