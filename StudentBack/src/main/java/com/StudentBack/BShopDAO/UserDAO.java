package com.StudentBack.BShopDAO;

import java.util.List;

import com.StudentBack.BShopDTO.Address;
import com.StudentBack.BShopDTO.Cart;
import com.StudentBack.BShopDTO.User;

public interface UserDAO {

	// add a user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	// alternative
	/*Address getBillingAddress(int userId);
	List<Address> listShippingAddress(int userId);*/
	
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
		
	
}
