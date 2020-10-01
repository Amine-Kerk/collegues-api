package dev.dto;

import javax.validation.constraints.NotBlank;

public class NoteRequestDto {

	

	@NotBlank
	private String text;

	private String matriculeCollegue;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMatriculeCollegue() {
		return matriculeCollegue;
	}

	public void setMatriculeCollegue(String matriculeCollegue) {
		this.matriculeCollegue = matriculeCollegue;
	}
	
	
}
