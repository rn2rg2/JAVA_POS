package com.kosa.pos.dao;

import java.util.List;
import java.util.Optional;

import com.kosa.pos.dto.Menu;
import com.kosa.pos.dto.MenuDetail;
import com.kosa.pos.dto.MenuGetRankNReview;
import com.kosa.pos.dto.MenuRanking;
import com.kosa.pos.dto.MenuStatsInfo;

public interface MenuDAO {
	public List<Menu> findall();

	public Optional<MenuDetail> findById(int menuId);

	public Menu findByName(String menuName);

	public List<MenuGetRankNReview> findBestMenuAll(String name);

	public Optional<MenuStatsInfo> findOrderCountByName(String name);

	public List<Menu> findByCategory(String category);

	public List<Menu> findAll(String name);

	public void insertMenu(Menu menu);

	public void deleteMenu(int menuId);

	public List<MenuRanking> getMenuRanking();

	public int getTotalOrderWithoutDrink();

	public List<Integer> fetchMenuIdByOrderId(int orderId);
	
	public void updateMenu(Menu menu);
}
