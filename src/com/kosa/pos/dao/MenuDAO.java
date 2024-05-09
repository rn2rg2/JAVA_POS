package com.kosa.pos.dao;

import java.util.List;
import java.util.Optional;

import com.kosa.pos.dto.Menu;
import com.kosa.pos.dto.MenuDetail;
import com.kosa.pos.dto.MenuStatsInfo;

public interface MenuDAO {
public List<Menu> findall();
public Optional<MenuDetail> findById(int menuId);

public List<MenuDetail> findBestMenuAll(String name);
public Optional<MenuStatsInfo> findOrderCountByName(String name);

public List<Menu> findByCategory(String category);

public List<Menu> findAll(String name);
public void insertMenu(Menu menu);
}
