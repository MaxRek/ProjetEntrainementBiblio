package com.example.model;

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
import com.example.view.Views;

@Entity
@Table(name="livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(length = 50,nullable = false)
	@JsonView(Views.Common.class)
	private String titre;

	@Column(length = 500,nullable = false)
	@JsonView(Views.Common.class)
	private String résumer;

	@Column(length = 4,nullable = false)
	@JsonView(Views.Common.class)
	private String année;

	@ManyToOne
	@JoinColumn(name="auteur",nullable = false)
	@JsonView(Views.AuteurWithLivre.class)
	private Auteur auteur;

	@ManyToOne
	@JoinColumn(name="editeur",nullable = false)
	@JsonView(Views.EditeurWithLivre.class)
	private Editeur editeur;

	@OneToOne
	@JoinColumn(name="collection",nullable = yes)
	@JsonView(Views.CollectionWithLivre.class)
	private Collection collection;
	
	public Livre() {}
	
	public Livre(Integer id, String titre, String résumer, String année, Auteur auteur, Editeur editeur, Collection collection) {
		this.id = id;
		this.titre = titre;
    	this.resumer = resumer;
    	this.annee = annee;
    	this.auteur = auteur;
   		this.editeur = editeur;
    	this.collection = collection
	}

	public Livre(String titre, String résumer, String année, String auteur, String editeur, String collection) {
		this.titre = titre;
    	this.resumer = resumer;
    	this.annee = annee;
    	this.auteur = auteur;
   		this.editeur = editeur;
    	this.collection = collection
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

	public String getRésumer() {
		return résumer;
	}

	public void setRésumer(String résumer) {
		this.résumer = résumer;
	}

	public String getAnnée() {
		return année;
	}

	public void setAnnée(String année) {
		this.année = année;
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
		return "Livre [id=" + id + ", titre=" + titre + ", résumer=" + résumer + ", année=" + année + ", auteur="
				+ auteur + "]";
	}
}
