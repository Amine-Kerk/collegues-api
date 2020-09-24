package dev.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.dto.CreerCollegueRequestDto;

import dev.entite.Collegue;
import dev.repository.CollegueRepo;

@Service
public class CollegueService {
	
	private CollegueRepo collegueRepo;
	
	
	

	public CollegueService(CollegueRepo collegueRepo) {
		super();
		this.collegueRepo = collegueRepo;
	}



//recuperer le nom depuis la bdd
	public List <String> rechercherParNom (String nom) {
		
		return collegueRepo.findByNom(nom);
	}

//recuperer par matricule depuis la bdd
	public Optional<Collegue> getByMatricule(String matricule) {
		return collegueRepo.findByMatricule(matricule);
	}
	
	/**
	 * 
	 * @param id identifiant du collegue recherché
	 * @return un objet Collegue correspondant au collegue
	 */

	public Optional<Collegue> getById(Integer id) {
		return collegueRepo.findById(id);
	}
	



//ajout en base
	@Transactional
	public Collegue creerCollegue(CreerCollegueRequestDto dto) {
       Collegue collegue = new Collegue();
       collegue.setNom(dto.getNom());
       collegue.setPrenom(dto.getPrenoms());
       collegue.setDateDeNaissance(dto.getDateDeNaissance());
       collegue.setPhotoUrl(dto.getPhotoUrl());
       
       //logique métier (génération du matricule)
       
       collegue.setMatricule(UUID.randomUUID().toString());
       collegue.setEmail(dto.getPrenoms()+"."+dto.getNom()+"@dev.fr");
       
       //=> envoyer un email aux RH par exemple
       
      return this.collegueRepo.save(collegue);// insert into collegue
       
	}
	
	@Transactional
	public Collegue updateCollegue(String matricule, String email, String photoUrl) {
		collegueRepo.update(matricule, email, photoUrl);
		return collegueRepo.findByMatricule(matricule)
				.orElseThrow(() -> new RuntimeException("erreur : actualisation Collegue"));
	}



    
	@Transactional
	public String removeCollegue(Integer id) {
		
		Optional<Collegue> collegueToRemove=this.getById(id);
		if(collegueToRemove.isPresent()) {
			collegueRepo.delete(collegueToRemove.get());
			return "Suppression reussie";
		}
		return "id non trouvé";
	}


	
	
	



	
}
