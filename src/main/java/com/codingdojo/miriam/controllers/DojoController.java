package com.codingdojo.miriam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.miriam.models.Dojo;
import com.codingdojo.miriam.services.Services;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	private final Services services;
	
	public DojoController(Services services) {
		this.services = services;
	}

	@GetMapping("/new")
	public String register(@ModelAttribute("dojo") Dojo dojo, Model model) {
		
		List<Dojo> list_dojos = services.get_all_dojos();
		
		model.addAttribute("dojos", list_dojos);
		
		return "new_dojo.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo,
						 BindingResult result) {
		if(result.hasErrors()) {
			return "new_dojo.jsp";
		} else {
			services.save_dojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo_show = services.find_dojo(id);
		
		model.addAttribute("dojo", dojo_show);
		model.addAttribute("ninjas",dojo_show.getNinjas());
		return "show_dojo.jsp";
	}
}
