package dev.dto;

import javax.validation.constraints.NotBlank;

public class PatchCollegueRequestDto {

	
	@NotBlank
	private String photoUrl;
    @NotBlank
	private String email;


	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}


