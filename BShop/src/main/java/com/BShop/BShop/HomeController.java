package com.BShop.BShop;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.StudentBack.BShopDAO.CategoryDAO;
import com.StudentBack.BShopDTO.Category;
import com.StudentBack.DAO.StudentDAO;
import com.StudentBack.model.Student;

@Controller
public class HomeController {
	
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/","/home", "/index", "/mhome"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("title", "Home");
		
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
	
	@RequestMapping(value = {"/show/all/{id}/products"}, method = RequestMethod.GET)
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
}
