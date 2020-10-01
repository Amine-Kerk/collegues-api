package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.NoteRequestDto;
import dev.dto.NoteResponseDto;
import dev.entite.Note;
import dev.service.NoteService;


@RestController
@CrossOrigin
@RequestMapping("notes")
public class NoteCtrl {

	private NoteService noteService;

	public NoteCtrl(NoteService noteService) {
		super();
		this.noteService = noteService;
	}
	
	//Post/notes
	@PostMapping
	public ResponseEntity<?> creerNote(@RequestBody @Valid NoteRequestDto dto, BindingResult resValid) {
		if (!resValid.hasErrors()) {

			Note note = noteService.creerNote(dto.getText(), dto.getMatriculeCollegue());

			return ResponseEntity.ok(note);
		} else {
			return ResponseEntity.badRequest().body("tous les champs sont obligatoires !");
		}
	}
	
	@GetMapping("/{matricule}")
	public List<NoteResponseDto> listerNotes(@PathVariable String matricule) {
		return noteService.listerNotes(matricule);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> effacerNotes(@PathVariable Integer id) {

		Boolean isRemoved = noteService.supprimerNote(id);

		if (!isRemoved) {
			return new ResponseEntity<>("Pas de Note avec l'id : " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("Note de l'id " + id + "éffacée", HttpStatus.OK);

	}

	
}
