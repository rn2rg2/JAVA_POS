package com.kosa.pos.dao;

import java.util.List;
import java.util.Map;

import com.kosa.pos.dto.Review;

public interface ReviewDAO {
public List<Review> findByMenuId(int id);
public Map<String, Double> reviewCountandAvgFindByMenuId(int id);
}
