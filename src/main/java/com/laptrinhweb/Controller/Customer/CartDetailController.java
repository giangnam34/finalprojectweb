package com.laptrinhweb.Controller.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.laptrinhweb.Service.Implementation.UserDetailService;

@Controller
public class CartDetailController {
	@Autowired
	UserDetailService userDetailService;
	
	@GetMapping("/cartdetail")
	public String cartdetail(Authentication authentication, Model model) {
		if (authentication != null) model.addAttribute("userLogged", userDetailService.detailUser(authentication.getName()));
		return "shopping-cart";
	}
}
