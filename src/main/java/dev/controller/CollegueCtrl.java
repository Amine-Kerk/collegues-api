package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.service.CollegueService;

@RestController
@RequestMapping ("collegues")
public class CollegueCtrl {
	
	private CollegueService collegueService;
	
	
	
	
	public CollegueCtrl(CollegueService collegueService) {
		super();
		this.collegueService = collegueService;
	}




	//GET/collegues
	@GetMapping
	public List<String> rechercherMatriculeParNom (@RequestParam String nom) { //requestparam pour extraire le nom
		return this.collegueService.rechercherParNom(nom);
		
	}
}
