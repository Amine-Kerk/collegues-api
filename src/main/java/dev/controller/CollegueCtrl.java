package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.CreerCollegueRequestDto;
import dev.dto.CreerCollegueResponseDto;
import dev.entite.Collegue;
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
	
	// POST /collegues
		@PostMapping
		public CreerCollegueResponseDto creerNouveauCollegue(@RequestBody @Valid CreerCollegueRequestDto dto) {
			Collegue collegueCree = this.collegueService.creerCollegue(dto);
			
			return new CreerCollegueResponseDto(collegueCree.getMatricule(), collegueCree.getEmail());
		}

}
