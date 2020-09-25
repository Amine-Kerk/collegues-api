package dev.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import dev.dto.CreerCollegueRequestDto;
import dev.dto.CreerCollegueResponseDto;
import dev.dto.PatchCollegueRequestDto;

import dev.entite.Collegue;
import dev.service.CollegueService;
@CrossOrigin
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
	
	
	/**
	 * url : [SERVER]/collegue/getMatricule?nom={nom}
	 * @return un json de tous les matricules en bdd 
	 */

	//get/collegues/matricules
	@GetMapping("{matricule}")
	public ResponseEntity<?> findByMatricule(@PathVariable String matricule) {
		Optional <Collegue> byMatricule = collegueService.getByMatricule(matricule);

		if(byMatricule.isPresent()) {
			return ResponseEntity.ok(byMatricule.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	// POST /collegues
	@PostMapping
		public CreerCollegueResponseDto creerNouveauCollegue(@RequestBody @Valid CreerCollegueRequestDto dto) {
			Collegue collegueCree = this.collegueService.creerCollegue(dto);
			
			return new CreerCollegueResponseDto(collegueCree.getMatricule(), collegueCree.getEmail());
		}
		
	
//PATCH /collegues/matricules
	@PatchMapping("/{matricule}")
	public ResponseEntity<?> uptadeCollegue(@PathVariable String matricule,@RequestBody @Valid PatchCollegueRequestDto dto, BindingResult resValid) {

		Collegue editCollegue = collegueService.updateCollegue(matricule, dto.getEmail(),dto.getPhotoUrl());
		return ResponseEntity.ok(editCollegue);
	}


	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeCollegue(@PathVariable Integer id) {
		return ResponseEntity.ok(collegueService.removeCollegue(id));
		
	}

	
		

}
