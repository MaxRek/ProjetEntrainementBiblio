package com.example.model;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Auteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String nationalite;

	public Auteur() {}

	public Auteur(String nom, String prenom, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nationalite=" + nationalite + "]";
	}
	
	
	
	
}
