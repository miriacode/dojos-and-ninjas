package com.codingdojo.miriam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.miriam.models.Dojo;
import com.codingdojo.miriam.models.Ninja;
import com.codingdojo.miriam.services.Services;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	private final Services services;
	
	public NinjaController(Services services) {
		this.services = services;
	}

	@GetMapping("/new")
	public String register(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Ninja> list_ninjas = services.get_all_ninjas();
		
		List<Dojo> list_dojos = services.get_all_dojos();
		
		model.addAttribute("ninjas", list_ninjas);
		model.addAttribute("dojos", list_dojos);
		
		return "new_ninja.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja,
						 BindingResult result) {
		if(result.hasErrors()) {
			return "new_ninja.jsp";
		} else {
			services.save_ninja(ninja);
			return "redirect:/";
		}
	}
}