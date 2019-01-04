package com.target.myretail.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerUIController {

	@RequestMapping("/")
	public String home() {
		return "redirect:swagger-ui.html";
	}
}
