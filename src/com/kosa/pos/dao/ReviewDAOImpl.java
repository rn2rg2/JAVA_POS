package com.kosa.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kosa.pos.dbconnection.DBConnection;
import com.kosa.pos.dto.Review;

public class ReviewDAOImpl implements ReviewDAO{

	private Connection connection = DBConnection.getConnection();
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	@Override
	public List<Review> findByMenuId(int menuId) {
		
		List<Review> reviewList = new ArrayList<>();
		String sql = "select * from review where menu_menu_id = ? "
				+ "and sysdate - review_date <= 7 order by review_date desc";
		
		try {
			// PreparedStatement 객체 생성 후 쿼리 실행
			 pstmt = connection.prepareStatement(sql);
		     pstmt.setInt(1, menuId);
		     rs = pstmt.executeQuery();

	        // 결과 처리
	        while (rs.next()) {
	            // 각 레코드마다 REVIEW 객체를 생성하고 결과를 설정한 후 리스트에 추가
	            Review review = new Review();
	            review.setReviewID(rs.getInt("REVIEW_ID"));
	            review.setTitle(rs.getString("TITLE"));
	            review.setContent(rs.getString("CONTENT"));
	            review.setRating(rs.getInt("RATING"));
	            review.setReviewDate(rs.getTimestamp("REVIEW_DATE"));
	            review.setMenuMenuID(rs.getInt("MENU_MENU_ID"));
	            reviewList.add(review);
	        }
	        return reviewList;
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
		
		return null;
	}
	
	@Override
	public Map<String, Double> reviewCountandAvgFindByMenuId(int menuId) {
		Map<String, Double> map = new HashMap<>();
		String sql = "select "
				+ "count(*) as count, "
				+ "round(avg(rating),2) as avg_score "
				+ "from review where menu_menu_id = ? "
				+ "and sysdate - review_date <= 7";
		
		try {
			// PreparedStatement 객체 생성 후 쿼리 실행
			 pstmt = connection.prepareStatement(sql);
		     pstmt.setInt(1, menuId);
		     rs = pstmt.executeQuery();

	        // 결과 처리
	        if (rs.next()) {
	            // 각 레코드마다 REVIEW 객체를 생성하고 결과를 설정한 후 리스트에 추가
	            map.put("count" , (double) rs.getInt("count"));
	            map.put("avgScore" , rs.getDouble("avg_score"));
	            
	        }
	        return map;
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
		return null;
	}
}
