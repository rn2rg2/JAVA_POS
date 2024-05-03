package com.kosa.pos.dao;

import java.util.List;
import java.util.Optional;

import com.kosa.pos.dto.Menu;

public interface MenuDAO {
public List<Menu> findall();
public Optional<Menu> findById(int menuId);
}
