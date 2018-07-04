package com.StudentBack.BShopDAO;

import java.util.List;

import com.StudentBack.BShopDTO.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
