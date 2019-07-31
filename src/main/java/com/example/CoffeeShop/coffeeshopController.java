package com.example.CoffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class coffeeshopController {

	@Autowired
	private ProductDao dao;

	@Autowired
	private UserDao dao2;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/products")
	public ModelAndView list() {
		List<Product> leListOfProduct = dao.findAll();
// shortcut syntax		
		return new ModelAndView("list", "products", leListOfProduct);
	}

	@RequestMapping("/products/register-user")
	public ModelAndView userlist() {
		List<User> leListOfUser = dao2.findAll();
// shortcut syntax		
		return new ModelAndView("userlist", "users", leListOfUser);
	}

	@PostMapping("/submit-registration")
	public ModelAndView addSubmit(User users) {
		dao2.create(users);
		ModelAndView mav = new ModelAndView("thank-you");
		mav.addObject("name1", users.getFirstname());
		mav.addObject("name2", users.getLastname());

		return mav;

	}

}
