package com.kosa.pos.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kosa.pos.dbconnection.DBConnection;
import com.kosa.pos.dto.Menu;

public class MenuDAOImpl implements MenuDAO {

	private Connection connection = DBConnection.getConnection();
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Menu> findall() {
	    List<Menu> menuList = new ArrayList<>(); // 메뉴 객체를 담을 리스트
	    try {
	        // 쿼리문 작성
	        String sql = "SELECT * FROM menu";

	        // PreparedStatement 객체 생성 후 쿼리 실행
	        stmt = connection.createStatement();
	        rs = stmt.executeQuery(sql);

	        // 결과 처리
	        while (rs.next()) {
	            // 각 레코드마다 Menu 객체를 생성하고 결과를 설정한 후 리스트에 추가
	            Menu menu = new Menu();
	            menu.setMenu_id(rs.getInt("MENU_ID"));
	            menu.setName(rs.getString("NAME"));
	            menu.setPrice(rs.getInt("PRICE"));
	            menu.setCategory(rs.getString("CATEGORY"));
	            menu.setMenu_desc(rs.getString("MENU_DESC"));
	            menu.setMenu_path(rs.getString("MENU_PATH"));
	            menuList.add(menu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 해제
	        try {
	            if (rs != null)
	                rs.close();
	            if (stmt != null)
	                stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return menuList;
	}
	
	@Override
	public Optional<Menu> findById(int menuId) {
		String sql = "SELECT * FROM menu WHERE menu_id = ?";
		try {
	        // PreparedStatement 객체 생성 후 쿼리 실행
	        pstmt = connection.prepareStatement(sql);
	        pstmt.setInt(1, menuId);
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	            Menu menu = new Menu();
	            menu.setMenu_id(rs.getInt("MENU_ID"));
	            menu.setName(rs.getString("NAME"));
	            menu.setPrice(rs.getInt("PRICE"));
	            menu.setCategory(rs.getString("CATEGORY"));
	            menu.setMenu_desc(rs.getString("MENU_DESC"));
	            menu.setMenu_path(rs.getString("MENU_PATH"));
	            return Optional.of(menu);
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        // 리소스 해제
	        try {
	            if (rs != null)
	                rs.close();
	            if (stmt != null)
	                stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Menu> findByCategory(String category) {
		 List<Menu> menuList = new ArrayList<>(); // 메뉴 객체를 담을 리스트
		    try {
		        // 쿼리문 작성
		        String sql = "SELECT * FROM menu where category = ?";

		        // PreparedStatement 객체 생성 후 쿼리 실행
		        pstmt = connection.prepareStatement(sql);
		        pstmt.setString(1, category);
		        rs = pstmt.executeQuery();

		        // 결과 처리
		        while (rs.next()) {
		            // 각 레코드마다 Menu 객체를 생성하고 결과를 설정한 후 리스트에 추가
		            Menu menu = new Menu();
		            menu.setMenu_id(rs.getInt("MENU_ID"));
		            menu.setName(rs.getString("NAME"));
		            menu.setPrice(rs.getInt("PRICE"));
		            menu.setCategory(rs.getString("CATEGORY"));
		            menu.setMenu_desc(rs.getString("MENU_DESC"));
		            menu.setMenu_path(rs.getString("MENU_PATH"));
		            menuList.add(menu);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        // 리소스 해제
		        try {
		            if (rs != null)
		                rs.close();
		            if (stmt != null)
		                stmt.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return menuList;
	}
	
}
