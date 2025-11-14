package com.example.model;

import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="collection")
public class Collection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	protected Integer id;
	@Column()
	@JsonView(Views.Common.class)
    protected String nom;
	
	public Collection() {
		// TODO Auto-generated constructor stub
	}

	public Collection(String nom) {
		super();
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Collection [id=" + id + ", nom=" + nom + "]";
	}

	
	
}
