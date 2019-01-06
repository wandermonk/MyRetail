package com.target.myretail.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * SwaggerUIController - Fallback controller class to the swagger documentation UI.
 */
@Controller
public class SwaggerUIController {

	@RequestMapping("/")
	public String home() {
		return "redirect:swagger-ui.html";
	}
}
