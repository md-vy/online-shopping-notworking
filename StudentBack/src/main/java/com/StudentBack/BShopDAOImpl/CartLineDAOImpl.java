package com.StudentBack.BShopDAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.StudentBack.BShopDAO.CartLineDAO;
import com.StudentBack.BShopDTO.Cart;
import com.StudentBack.BShopDTO.CartLine;

public class CartLineDAOImpl implements CartLineDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CartLine get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(CartLine cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CartLine cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CartLine cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId";
 		return sessionFactory.getCurrentSession()
 								.createQuery(query, CartLine.class)
 									.setParameter("cartId", cartId)
										.getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
				
 		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
									.setParameter("available", true)
										.getResultList();	
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {

		String query = "FROM CartLine WHERE cartId = :cartId AND  product.id = :productId";
		try {
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
									.setParameter("productId", productId).getSingleResult(); 
		}
		catch(Exception ex) {
			return null;
		}
	}
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	

	}


