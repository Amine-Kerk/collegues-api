package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.repository.CollegueRepo;

@Service
public class CollegueService {
	
	private CollegueRepo collegueRepo;
	
	
	

	public CollegueService(CollegueRepo collegueRepo) {
		super();
		this.collegueRepo = collegueRepo;
	}




	public List <String> rechercherParNom (String nom) {
		
		return collegueRepo.findByNom(nom);
	}
}
