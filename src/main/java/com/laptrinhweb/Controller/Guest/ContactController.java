package com.laptrinhweb.Controller.Guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	
	@GetMapping("/contact")
	public String Contact() {
		return "contact";
	}
}
