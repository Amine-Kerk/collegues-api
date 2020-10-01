package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entite.Note;

public interface NoteRepo extends JpaRepository<Note, Integer> {

	
	@Query("select n from Note n JOIN FETCH n.collegue c where c.matricule =?1 ")
	List<Note> findAllByMatricule(String matricule);
}
