package com.StudentBack.BShopTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.StudentBack.BShopDAO.UserDAO;
import com.StudentBack.BShopDTO.Address;
import com.StudentBack.BShopDTO.Cart;
import com.StudentBack.BShopDTO.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.StudentBack");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234567123");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		// add the user
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAdressLineOne("abc, abc road");
//		address.setAdressLineTwo("near abc");
//		address.setCity("Abc");
//		address.setState("ABC");
//		address.setCountry("AbC");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		// link the user with the address using user id
//		address.setUserId(user.getId());
//		
//		// add the address
//		assertEquals("Failed to add the address!", true, userDAO.addAddress(address));
//		if(user.getRole().equals("USER")) 
//		{
//			//create  a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			// add the cart
//			assertEquals("Failed to add the cart!", true, userDAO.addCart(cart));
//			
//			//add  shipping address for this user
//			address = new Address();
//			address.setAdressLineOne("abc, abc road");
//			address.setAdressLineTwo("near abc");
//			address.setCity("Abc");
//			address.setState("ABC");
//			address.setCountry("AbC");
//			address.setPostalCode("400001");
//			//set shipping to true
//			address.setShipping(true);
//			
//			//link it with the user
//			address.setUserId(user.getId());
//			
//			// add the shipping address
//			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//			
//		}
//	}
	
	
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234567123");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		
//		if(user.getRole().equals("USER")) 
//		{
//			//create  a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			// attach cart with the user
//			user.setCart(cart);
//						
//		}
//		
//		// add the user
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//	}
	
	
//	@Test
//	public void testUpdateCart() {
//	 
//		// fetch the user by its email
//		user=userDAO.getByEmail("hr@gmail.com");
//		
//		// get the cart of the user
//		cart = user.getCart();
//		
//		cart.setGrandTotal(5555);
//		
//		cart.setCartLines(2);
//		
//
//		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
//	}
	
/*	@Test
	public void testAddAddress() {
	 
		// we need to add a user
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234567123");
		user.setRole("USER");
		user.setPassword("123456");
		
		// add the user
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
		
		
		//we are going to add the address
		address = new Address();
		address.setAdressLineOne("abc, abc road");
		address.setAdressLineTwo("near abc");
		address.setCity("Abc");
		address.setState("ABC");
		address.setCountry("AbC");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//attach the user with the address
		address.setUser(user);
		assertEquals("Failed to add address!", true,userDAO.addAddress(address) );
		
		// we are also going to add the shipping address
		address = new Address();
		address.setAdressLineOne("abc, abc road");
		address.setAdressLineTwo("near abc");
		address.setCity("Abc");
		address.setState("ABC");
		address.setCountry("AbC");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
		
		
		//attach the user with the address
				address.setUser(user);
				assertEquals("Failed to add shipping address!", true,userDAO.addAddress(address) );
	}
	*/
	
	/*@Test
	public void testAddAddress() {
			
		user = userDAO.getByEmail("hr@gmail.com");
		
		//we are going to add the address
		address = new Address();
		address.setAdressLineOne("xyz, abc road");
		address.setAdressLineTwo("near abc");
		address.setCity("Xyz");
		address.setState("XYZ");
		address.setCountry("AbC");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//attach the user with the address
		address.setUser(user);
		assertEquals("Failed to add address!", true,userDAO.addAddress(address) );
		
		// we are also going to add the shipping address
		address = new Address();
		address.setAdressLineOne("abc, abc road");
		address.setAdressLineTwo("near abc");
		address.setCity("Abc");
		address.setState("ABC");
		address.setCountry("AbC");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
		
		
		//attach the user with the address
				address.setUser(user);
				assertEquals("Failed to add shipping address!", true,userDAO.addAddress(address) );
	}*/
	
	@Test
	public void testAddAddress() {
			
		user = userDAO.getByEmail("hr@gmail.com");
		assertEquals("Failed to fetch the list of address and size does not match!", 2,userDAO.listShippingAddress(user).size() );
		assertEquals("Failed to fetch the billing address and size does not match!", "Mumbai",userDAO.getBillingAddress(user).getCity() );
	}
	
}
