package com.makersacademy.acebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
	@GetMapping(value = "/")
	public String index() {
		return "posts/home";
	}
}
