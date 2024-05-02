package com.kosa.pos.dbconnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class JdbcConnection {

	@SuppressWarnings("unused")
	public static void main(String args[]) throws SQLException {

		OracleDataSource ods = new OracleDataSource();
		/* 설정 파일 + 싱글턴 패턴 활용 접속 */
		Connection conn5 = DBConnection.getConnection();
		System.out.println(conn5);
		/* Oracle Call Interface (OCI) driver */

		
	}

}