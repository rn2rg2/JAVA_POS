package com.kosa.pos.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kosa.pos.dbconnection.DBConnection;
import com.kosa.pos.dto.Menu;
import com.kosa.pos.dto.MenuDetail;
import com.kosa.pos.dto.Review;

import oracle.jdbc.OracleTypes;

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
	public Optional<MenuDetail> findById(int menuId) {
		
//		int menuID = 1;
		String runSP = "{ call menu_package.get_menu_detail(?,?,?,?,?) }";
		
		try {
	        // PreparedStatement 객체 생성 후 쿼리 실행
			CallableStatement callableStatement = connection.prepareCall(runSP);
			callableStatement.setInt(1, menuId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // 메뉴 디테일
			callableStatement.registerOutParameter(3, OracleTypes.NUMBER); // 주문 받은 횟수
			callableStatement.registerOutParameter(4, OracleTypes.NUMBER); // 리뷰 평점
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR); // 리뷰 리스트
			callableStatement.execute();
	        
			ResultSet menuRec = (ResultSet) callableStatement.getObject(2);
			int menuOrderCount = callableStatement.getInt(3);
			float menuReviewAvgScore = callableStatement.getFloat(4);
			ResultSet reviewList = (ResultSet) callableStatement.getObject(5);
			
			MenuDetail menuDetail = new MenuDetail();
			// 세부 메뉴 정보
			if(menuRec.next()) {
				Menu menu = new Menu();
	            menu.setMenu_id(menuRec.getInt("MENU_ID"));
	            menu.setName(menuRec.getString("NAME"));
	            menu.setPrice(menuRec.getInt("PRICE"));
	            menu.setCategory(menuRec.getString("CATEGORY"));
	            menu.setMenu_desc(menuRec.getString("MENU_DESC"));
	            menu.setMenu_path(menuRec.getString("MENU_PATH"));
	            menuDetail.setMenu(menu);
			}
			
			// 주문 횟수, 리뷰 평점
			menuDetail.setCount(menuOrderCount);
	        menuDetail.setAvgScore(menuReviewAvgScore);
	        
	        // 리뷰 리스트
	        List<Review> list = new ArrayList<>();
	        while(reviewList.next()) {
	        	Review review = new Review();
	        	review.setTitle(reviewList.getString("TITLE"));
	        	review.setContent(reviewList.getString("CONTENT"));
	        	review.setRating(reviewList.getInt("RATING"));
	        	review.setReviewDate(reviewList.getDate("REVIEW_DATE"));
	        	list.add(review);
	        }
	        menuDetail.setReviewList(list);
	        return Optional.of(menuDetail);
	        
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
}
