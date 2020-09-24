package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.entite.Collegue;

public interface CollegueRepo extends JpaRepository <Collegue,Integer> {
	
	//composant qui permet d'interoger avec ma base 
	
	
	@Query("select c.matricule from Collegue c where c.nom=:nom")  //echange avec la base pour recupérer que matricule
	List <String> findByNom(@Param ("nom")String nom);

	
	@Query("select c from Collegue c where c.matricule=?1")       //echange avec la base pour recupérer les infos liés au matricule
	Optional<Collegue> findByMatricule(String matricule);

}
