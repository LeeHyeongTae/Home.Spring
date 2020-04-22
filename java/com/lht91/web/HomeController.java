package com.lht91.web;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootConfiguration
@Controller
public class HomeController {
	@GetMapping("/")
	public String Hello() {
		return "lotto/buy.html";
	}
}