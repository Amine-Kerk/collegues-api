package dev.dto;

import java.time.LocalDateTime;

import dev.entite.Note;

public class NoteResponseDto {

	private Integer id;

	private String text;

	private LocalDateTime date;


	public NoteResponseDto(Note note) {
		id = note.getId();
		text = note.getText();
		date = note.getDate();

	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
