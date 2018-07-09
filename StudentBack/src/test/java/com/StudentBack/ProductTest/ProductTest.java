package com.StudentBack.ProductTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.StudentBack.Product.Product;
import com.StudentBack.ProductDAO.ProductDAO;

public class ProductTest {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.StudentBack");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		
		
	}
	
//	@Test
//	public void testCRUDproduct() {
//		
//      product= new Product();
//		
//		product.setName("Oppo Selfie S53");
//		product.setBrand("Oppo");
//		product.setDescription("This is some description for oppo phones!");
//		product.setUnitPrice(25000);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		
//		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
//	
//		
//		product = productDAO.get(2);
//		product.setName("Samsung Galaxy S7");
//		assertEquals("Something went wrong while updating the record!", true, productDAO.update(product));
//		
//		product = productDAO.get(1);
//		assertEquals("Something went wrong while deleting the record!", true, productDAO.delete(product));
//		
//		assertEquals("Something went wrong while fetching list of products in the record!", 6, productDAO.list().size());
//	
//		
//		
//	}
	
	
	@Test
	public void testListActiveProducts() {
		
		assertEquals("Something went wrong while fetching list of products in the record!", 5, productDAO.listActiveProducts().size());
	}
	@Test
	public void testListActiveProductsByCategory() {
		
		assertEquals("Something went wrong while fetching list of products in the record!",3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching list of products in the record!", 2, productDAO.listActiveProductsByCategory(1).size());
		}
	
	
	@Test
	public void testGetLatestActiveProduct() {
		
		assertEquals("Something went wrong while fetching list of products in the record!",3, productDAO.getLatestActiveProducts(3).size());
		}
	
	
	
	}
	
