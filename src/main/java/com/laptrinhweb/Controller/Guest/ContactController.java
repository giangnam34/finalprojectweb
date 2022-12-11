package com.laptrinhweb.Controller.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.laptrinhweb.Service.Implementation.UserDetailService;

@Controller
public class ContactController {
	@Autowired
	UserDetailService userDetailService;
	
	@GetMapping("/contact")
	public String Contact(Authentication authentication, Model model) {
		if (authentication != null) model.addAttribute("userLogged", userDetailService.detailUser(authentication.getName()));
		return "contact";
	}
}
