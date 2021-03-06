package dev.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.sun.istack.NotNull;

//classe qui heberge les information json pour l'ajout


public class CreerCollegueRequestDto {
	
	@NotBlank
private String nom;
	@NotBlank
private String prenoms;
	@NotNull
	@Past
private LocalDate dateDeNaissance;
	@NotBlank
private String photoUrl;


public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenoms() {
	return prenoms;
}
public void setPrenoms(String prenoms) {
	this.prenoms = prenoms;
}
public LocalDate getDateDeNaissance() {
	return dateDeNaissance;
}
public void setDateDeNaissance(LocalDate dateDeNaissance) {
	this.dateDeNaissance = dateDeNaissance;
}
public String getPhotoUrl() {
	return photoUrl;
}
public void setPhotoUrl(String photoUrl) {
	this.photoUrl = photoUrl;
}



}
