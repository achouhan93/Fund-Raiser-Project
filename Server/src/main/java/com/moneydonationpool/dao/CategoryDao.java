package com.moneydonationpool.dao;

import java.util.List;

import com.moneydonationpool.entity.CategoryEntity;
import com.moneydonationpool.entity.CauseEntity;

public interface CategoryDao {

	public List<CategoryEntity> getAllCategories();	
}
