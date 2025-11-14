package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IDAOAuteur;
import com.example.model.Auteur;

@Service
public class AuteurService {
	
	@Autowired
	IDAOAuteur daoAuteur;
	
	public List<Auteur> findAll(){
		return daoAuteur.findAll();
	}
	
	public Auteur findById(Integer id) {
		return daoAuteur.findById(id).get();
	}
	
	public Auteur create(Auteur auteur) {
		return daoAuteur.save(auteur);
	}
	
	public Auteur update(Auteur auteur) {
		return daoAuteur.save(auteur);
	}
	
	public void deleteById(Integer id) {
		daoAuteur.deleteById(id);
	}
	
	public void delete(Auteur auteur) {
		daoAuteur.delete(auteur);
	}
}
