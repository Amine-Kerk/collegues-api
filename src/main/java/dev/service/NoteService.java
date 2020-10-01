package dev.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.NoteResponseDto;
import dev.entite.Note;
import dev.repository.CollegueRepo;
import dev.repository.NoteRepo;


@Service
public class NoteService {

	
	private NoteRepo noteRepo ;
	private CollegueRepo collegueRepo;
	
	public NoteService(NoteRepo noteRepo, CollegueRepo collegueRepo) {
		super();
		this.noteRepo = noteRepo;
		this.collegueRepo = collegueRepo;
	}
	
	
	//cration d'une note
	
	public Note creerNote (String text ,String matriculeCollegue) {
		
		Note note = new Note();
		
		note.setText(text);
		note.setDate(LocalDateTime.now());
		note.setCollegue(collegueRepo.findByMatricule(matriculeCollegue).orElseThrow(
				()-> new RuntimeException("ERROR : CE MATRICULE NE CORRESPOND A AUCUN COLLEGUE ")));
		noteRepo.save(note);	
		return note;
	}
	
	
	//liste des notes 
	
    public List <NoteResponseDto> listerNotes (String matricule){
    	   List<Note> listN = noteRepo.findAllByMatricule(matricule);
    	   List<NoteResponseDto> listResponse = new ArrayList<>();
    	
    	for (Note note : listN) {
    		listResponse.add(new NoteResponseDto(note));
    	}
    	return listResponse;
    }
    
    
    //supprimer note
    
    public Boolean supprimerNote (Integer id) {
    	Optional<Note> noteOp = noteRepo.findById(id);
    	if (noteOp.isEmpty()) {
    		return false;
    	}else {
    		noteRepo.delete(noteOp.get());
    		return true;
    	}
    }
	
}
