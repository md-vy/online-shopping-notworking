package com.StudentBack.BShopTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.StudentBack.BShopDAO.CategoryDAO;
import com.StudentBack.BShopDTO.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.StudentBack");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		
	}
	
	
	@Test
	public void testAddCategory() {
		
		category= new Category();
		
		category.setName("Television");
		category.setDescription("This is some dscription for television!");
		category.setImageURL("CAT_1.png");
		
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		
	}
	
//	@Test
//	public void testGetCategory() {
//		
//		category = categoryDAO.get(1);
//		assertEquals("Successfully fetched a single category from the table!", "Television", category.getName());
//		
//	}
//	
	
//	@Test
//	public void testUpdateCategory() {
//		
//		category = categoryDAO.get(1);
//		category.setName("TV");
//		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));
//		
//	}
//	@Test
//	public void testDeleteCategory() {
//		
//		category = categoryDAO.get(1);
//		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));
//		
//	}
	
	
//	@Test
//	public void testlistCategory() {
//		
//		assertEquals("Successfully deleted a single category in the table!", 1, categoryDAO.list().size());
//		
//	}
	
	@Test
	public void testCRUDCategory() {
		
category= new Category();
		
		category.setName("Television");
		category.setDescription("This is some dscription for television!");
		category.setImageURL("CAT_2.png");
		
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
	
category= new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some dscription for laptop!");
		category.setImageURL("CAT_3.png");
		
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		
		
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a single category in the table!", true, categoryDAO.update(category));
		
//		category = categoryDAO.get(1);
//		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));
		
		assertEquals("Successfully fetched list category in the table!", 2, categoryDAO.list().size());
	
		
		
	}



}
