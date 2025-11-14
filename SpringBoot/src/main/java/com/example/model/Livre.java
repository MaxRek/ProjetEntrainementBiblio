package com.example.model;

import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	@JsonView(Views.Common.class)
	private String titre;

	@Column(length = 500, nullable = false)
	@JsonView(Views.Common.class)
	private String resumer;

	@Column(length = 4, nullable = false)
	@JsonView(Views.Common.class)
	private String annee;

	@ManyToOne
	@JoinColumn(name="auteur", nullable = false)
	@JsonView(Views.AuteurWithLivre.class)
	private Auteur auteur;

	@ManyToOne
	@JoinColumn(name="editeur", nullable = false)
	@JsonView(Views.EditeurWithLivre.class)
	private Editeur editeur;

	@OneToOne
	@JoinColumn(name="collection", nullable = true)
	@JsonView(Views.CollectionWithLivre.class)
	private Collection collection;
	
	public Livre() {}
	
	public Livre(Integer id, String titre, String resumer, String annee, Auteur auteur, Editeur editeur, Collection collection) {
		this.id = id;
		this.titre = titre;
    	this.resumer = resumer;
    	this.annee = annee;
    	this.auteur = auteur;
   		this.editeur = editeur;
    	this.collection = collection;
	}

	public Livre(String titre, String resumer, String annee, Auteur auteur, Editeur editeur, Collection collection) {
		this.titre = titre;
    	this.resumer = resumer;
    	this.annee = annee;
    	this.auteur = auteur;
   		this.editeur = editeur;
    	this.collection = collection;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResumer() {
		return resumer;
	}

	public void setResumer(String resumer) {
		this.resumer = resumer;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", resumer=" + resumer + ", annee=" + annee + ", auteur="
				+ auteur + "]";
	}
}
