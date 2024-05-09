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
import com.kosa.pos.dto.MenuStatsInfo;
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
		String runSP = "{ call menu_package.get_menu_detail(?,?,?,?,?,?,?) }";
		
		try {
	        // PreparedStatement 객체 생성 후 쿼리 실행
			CallableStatement callableStatement = connection.prepareCall(runSP);
			callableStatement.setInt(1, menuId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // 메뉴 디테일
			callableStatement.registerOutParameter(3, OracleTypes.NUMBER); // 주문 받은 횟수
			callableStatement.registerOutParameter(4, OracleTypes.NUMBER); // 리뷰 평점
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR); // 리뷰 리스트 최신순
			callableStatement.registerOutParameter(6, OracleTypes.CURSOR); // 리뷰 리스트 평점순
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR); // 리뷰 리스트 오래된순
			callableStatement.execute();
	        
			ResultSet menuRec = (ResultSet) callableStatement.getObject(2);
			int menuOrderCount = callableStatement.getInt(3);
			float menuReviewAvgScore = callableStatement.getFloat(4);
			ResultSet orderByReviewDateDesc = (ResultSet) callableStatement.getObject(5);
			ResultSet orderByRatingDesc = (ResultSet) callableStatement.getObject(6);
			ResultSet orderByReviewDateAsc = (ResultSet) callableStatement.getObject(7);
			
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
	        
	        // 리뷰 최신순 리스트
	        List<Review> orderByReviewDateDescList = new ArrayList<>();
	        while(orderByReviewDateDesc.next()) {
	        	Review review = new Review();
	        	review.setTitle(orderByReviewDateDesc.getString("TITLE"));
	        	review.setContent(orderByReviewDateDesc.getString("CONTENT"));
	        	review.setRating(orderByReviewDateDesc.getInt("RATING"));
	        	review.setReviewDate(orderByReviewDateDesc.getDate("REVIEW_DATE"));
	        	orderByReviewDateDescList.add(review);
	        }
	        menuDetail.setOrderByReviewDateDescList(orderByReviewDateDescList);
	        
	        // 리뷰 평점순 리스트
	        List<Review> orderByRatingDescList = new ArrayList<>();
	        while(orderByRatingDesc.next()) {
	        	Review review = new Review();
	        	review.setTitle(orderByRatingDesc.getString("TITLE"));
	        	review.setContent(orderByRatingDesc.getString("CONTENT"));
	        	review.setRating(orderByRatingDesc.getInt("RATING"));
	        	review.setReviewDate(orderByRatingDesc.getDate("REVIEW_DATE"));
	        	orderByRatingDescList.add(review);
	        }
	        menuDetail.setOrderByRatingDescList(orderByRatingDescList);
	        
	        // 리뷰 오래된순 리스트
	        List<Review> orderByReviewDateAscList = new ArrayList<>();
	        while(orderByReviewDateAsc.next()) {
	        	Review review = new Review();
	        	review.setTitle(orderByReviewDateAsc.getString("TITLE"));
	        	review.setContent(orderByReviewDateAsc.getString("CONTENT"));
	        	review.setRating(orderByReviewDateAsc.getInt("RATING"));
	        	review.setReviewDate(orderByReviewDateAsc.getDate("REVIEW_DATE"));
	        	orderByReviewDateAscList.add(review);
	        }
	        menuDetail.setOrderByReviewDateAscList(orderByReviewDateAscList);
	        
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

	@Override
	public Optional<MenuStatsInfo> findOrderCountByName(String name) {
//		int menuID = 1;
		String runSP = "{ call menu_stats_info.get_menu_order_count(?,?) }";
		
		try {
	        // PreparedStatement 객체 생성 후 쿼리 실행
			CallableStatement callableStatement = connection.prepareCall(runSP);
			callableStatement.setString(1, name);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // 특정 메뉴의 최근 일주일간의 주문 받은 횟수
			
			callableStatement.execute();
	        
			ResultSet orderCount = (ResultSet) callableStatement.getObject(2);

			
			MenuStatsInfo menuStatsInfo = new MenuStatsInfo();
			int index = 0;
	        while(orderCount.next()) {
	        	menuStatsInfo.getDay()[index] = orderCount.getString("DAY").toString();
	        	menuStatsInfo.getValues()[index] = orderCount.getDouble("TOTAL");
	        	index++;
	        }
	        return Optional.of(menuStatsInfo);
	        
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
		
		
		
		
		return Optional.empty();
	}

	@Override
	public List<MenuDetail> findBestMenuAll(String name) {
		String runSP = "{ call menu_stats_info.get_menu_rank(?,?) }";
		
		try {
	        // PreparedStatement 객체 생성 후 쿼리 실행
			CallableStatement callableStatement = connection.prepareCall(runSP);
			callableStatement.setString(1, name);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // 인기 메뉴
			callableStatement.execute();
	        
			ResultSet menuRank = (ResultSet) callableStatement.getObject(2);

			List<MenuDetail> menuRankList = new ArrayList<>();
	        while(menuRank.next()) {
	        	MenuDetail menuDetail = new MenuDetail();
	        	menuDetail.setRank(menuRank.getInt("RANK"));
	        	menuDetail.setAvgScore(menuRank.getDouble("AVG_SCORE"));
	        	menuDetail.setCount(menuRank.getInt("ORDER_COUNT"));
	        	
	        	Menu menu = new Menu();
	        	menu.setCategory(menuRank.getString("CATEGORY"));
	        	menu.setName(menuRank.getString("NAME"));
	        	menuDetail.setMenu(menu);

	        	menuRankList.add(menuDetail);
	        	
	        }
	        return menuRankList;
	        
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

	public List<Menu> findByCategory(String category) {
		 List<Menu> menuList = new ArrayList<>(); // 메뉴 객체를 담을 리스트
		    try {
		        // 쿼리문 작성
		        String sql = "{ call menu_package.find_category(?, ?) }";

		        // PreparedStatement 객체 생성 후 쿼리 실행
		        CallableStatement callableStatement = connection.prepareCall(sql);
		        callableStatement.setString(1, category);
				callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // 메뉴의 모든 데이터
				callableStatement.execute();
				
				ResultSet menubycategory = (ResultSet) callableStatement.getObject(2);
				while(menubycategory.next()) {
					Menu menu = new Menu();
					menu.setMenu_id(menubycategory.getInt("MENU_ID"));
					menu.setName(menubycategory.getString("NAME"));
					menu.setPrice(menubycategory.getInt("PRICE"));
					menu.setCategory(menubycategory.getString("CATEGORY"));
		            menu.setMenu_desc(menubycategory.getString("MENU_DESC"));
		            menu.setMenu_path(menubycategory.getString("MENU_PATH"));
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
	public List<Menu> findAll(String name) {
		String runSP = "{ call menu_package.get_menu_list(?,?) }";
		
		try {
	        // PreparedStatement 객체 생성 후 쿼리 실행
			CallableStatement callableStatement = connection.prepareCall(runSP);
			callableStatement.setString(1, name);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // 특정 메뉴의 최근 일주일간의 주문 받은 횟수
			
			callableStatement.execute();
	        
			ResultSet menuList = (ResultSet) callableStatement.getObject(2);

			List<Menu> list = new ArrayList<>();
	        while(menuList.next()) {
	        	Menu menu = new Menu();
	        	menu.setMenu_id(menuList.getInt("MENU_ID"));
	        	menu.setCategory(menuList.getString("CATEGORY"));
	        	menu.setName(menuList.getString("NAME"));
	        	list.add(menu);
	        }
	        return list;
	        
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
