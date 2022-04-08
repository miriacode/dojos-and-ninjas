package com.codingdojo.miriam.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.miriam.models.Dojo;
import com.codingdojo.miriam.models.Ninja;
import com.codingdojo.miriam.services.Services;

@Controller
public class IndexController {

	private final Services services;
	
	public IndexController(Services services) {
		this.services = services;
	}

	@GetMapping("")
	public String show_index(Model model) {
		
		List<Dojo> dojos = services.get_all_dojos();
		List<Ninja> ninjas = services.get_all_ninjas();
		model.addAttribute("ninjas",ninjas);
		model.addAttribute("dojos", dojos);
		
		return "index.jsp";
	}
	
}
