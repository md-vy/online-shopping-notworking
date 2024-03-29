package com.StudentBack.BShopDAO;

import java.util.List;

import com.StudentBack.BShopDTO.Category;

public interface CategoryDAO {
	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
