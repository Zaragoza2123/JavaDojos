package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Dojo;
import com.codingdojo.services.DojoService;

@Controller
public class DojoController {

	@Autowired
	private DojoService dojoService;
	public DojoController(DojoService dojoService)
	{
		this.dojoService=dojoService;
	}
	@GetMapping("/show_dojo/{id}")
	public String showDojo(Model model,@PathVariable("id") Long id) {
		model.addAttribute("dojo", dojoService.FindOne(id));
		return "show_dojo";
	}
	@GetMapping("/dojo")
	public String index(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "dojo";
	}
	@PostMapping("/create_dojo")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res)
	{
		if(res.hasErrors()) {
			return "dojo";
		}
		dojoService.Create(dojo);
		return"redirect:/show_dojo/"+dojo.getId();
	}
}
