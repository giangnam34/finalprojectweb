package com.laptrinhweb.Controller.Guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
	
	@GetMapping("/blog")
	public String Blog() {
		return "blog";
	}
}
