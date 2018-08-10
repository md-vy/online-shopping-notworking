package com.BShop.BShop;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.BShop.exception.ProductNotFoundException;
import com.StudentBack.BShopDAO.CategoryDAO;
import com.StudentBack.BShopDTO.Category;
import com.StudentBack.DAO.StudentDAO;
import com.StudentBack.Product.Product;
import com.StudentBack.ProductDAO.ProductDAO;
import com.StudentBack.model.Student;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/","/home", "/index", "/mhome"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("title", "Home");
		
		
		logger.info("Inside PageController index method-INFO");
		logger.debug("Inside PageController index method-DEBUG");
		
		//passing the list of categories
		model.addAttribute("categories", categoryDAO.list());
		
		model.addAttribute("userClickHome", true);
			return "home";
		
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register( Model model) {
	model.addAttribute("student", new Student());
	model.addAttribute("title", "Registration");
	model.addAttribute("userClickRegistration", true);
			return "home";
	/* public ModelAndView registration() {
		ModelAndView model= new ModelAndView("home");
		model.addObject("student", new Student());
	    model.addObject("title", "Registration");
	    model.addObject("userClickRegistration", true);
	    return model;*/
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about( Model model) {
	model.addAttribute("student", new Student());
	model.addAttribute("title", "About Us");
	model.addAttribute("userClickAbout", true);
			return "home";
	}
			
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
			public String contact( Model model) {
			model.addAttribute("student", new Student());
			model.addAttribute("title", "Contact Us");
			model.addAttribute("userClickContact", true);
					return "home";		
					
	}
	
	/*
	 * Methods to load all the products and based on category
	 * */
	@RequestMapping(value = {"/show/all/products"}, method = RequestMethod.GET)
	public String showAllProducts(Locale locale, Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("title", "All Products");
		
		//passing the list of categories
		model.addAttribute("categories", categoryDAO.list());
		
		model.addAttribute("userClickAllProducts", true);
			return "home";
		
			
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"}, method = RequestMethod.GET)
	public String showCategoryProducts(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", new Student());
		
		//categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		model.addAttribute("title", category.getName());
		
		//passing the list of categories
		model.addAttribute("categories", categoryDAO.list());
		
		//passing the single category object
		model.addAttribute("category", category);
		
		model.addAttribute("userClickCategoryProducts", true);
			return "home";
		
	}
	
	
	@RequestMapping(value = "/regis", method = RequestMethod.POST)
	public String regis(@ModelAttribute("student")Student student, Model model) {
	model.addAttribute("student", new Student());
	
	studentDAO.addStudent(student);
			return "home";
	}
	
	// Viewing a single product
	@RequestMapping(value = "/show/{id}/product")
	public String showSingleProducts(@PathVariable int id, Model model) throws ProductNotFoundException {
		
		Product product = productDAO.get(id);
		if(product==null)throw new ProductNotFoundException();
		
		//update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		//--------------------------
		
		model.addAttribute("title",product.getName());
		model.addAttribute("product",product); 
		
		model.addAttribute("userClickShowProduct",true);
		
		
		return "home";
	}
	/* Having similar mapping to our flow id
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("title", "All Products");*/
	
	/*Login*/
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login(@RequestParam(name= "error", required=false)String error,
			@RequestParam(name= "logout", required=false)String logout,Model model) {
		
		if(error!=null) {
			model.addAttribute("message", "Invalid Username and Password");
		}
		
		if(logout!=null) {
			model.addAttribute("logout", "User has successfully logged-out!");
		}
		model.addAttribute("title", "Login");
		return "login";
	}
	
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDenied( Model model) {
	model.addAttribute("title", "403 - Access Denied");
	model.addAttribute("errorTitle", "Access Denied");
	model.addAttribute("errorDescription", "You are not authorized to view this page!");
			return "error";
	}
	
	//Logout
	@RequestMapping(value = "/perform-logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
	model.addAttribute("title", "403 - Access Denied");
	model.addAttribute("errorTitle", "Access Denied");
	model.addAttribute("errorDescription", "You are not authorized to view this page!");
	
	//fetch the authentication
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	if(auth!=null) {
		
		new SecurityContextLogoutHandler().logout(request, response, auth);
		
	}

	    
	
			return "redirect:/login?logout";
	}
	
	
	
}
