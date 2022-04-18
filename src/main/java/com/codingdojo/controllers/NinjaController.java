package com.codingdojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Ninja;
import com.codingdojo.services.DojoService;
import com.codingdojo.services.NinjaService;

@Controller 
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	public NinjaController(NinjaService ninjaService,DojoService dojoService)
	{
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	@GetMapping("/ninja")
	public String index(Model model) {
		model.addAttribute("dojo", dojoService.FindAll());
		model.addAttribute("ninja", new Ninja());
		return "ninja";
	}
	
	@PostMapping("/create_ninja")
	public String create(@ModelAttribute("ninja") Ninja ninja, BindingResult res) {
		if(res.hasErrors()) {
			return "/ninja";
		}
		ninjaService.Create(ninja);
		return "redirect:/show_dojo/"+ninja.getDojo().getId();
	}
	
	
};
