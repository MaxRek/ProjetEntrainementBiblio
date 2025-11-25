package com.example.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Auteur;
import com.example.service.AuteurService;
import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auteur")
public class AuteurRestController {
    private final static Logger log = LoggerFactory.getLogger(AuteurRestController.class);


	@Autowired
	AuteurService auteurSrv;
	
	@JsonView(Views.Auteur.class)
	@GetMapping
	public List<Auteur> allAuteurs(){
		log.info("methode AuteurRestController.allAuteurs()");
		return auteurSrv.findAll();
	}
	
	@JsonView(Views.Auteur.class)
	@GetMapping("/{id}")
	public Auteur ficheAuteur(@PathVariable Integer id, Auteur auteur){
		log.info("methode AuteurRestController.ficheAuteur(id) avec id = "+id);

		return auteurSrv.findById(id);
	}
	
	@PostMapping
	public Auteur ajoutAuteur(@RequestBody Auteur auteur)
	{
		log.info("methode AuteurRestController.ajoutAuteur()");

		return auteurSrv.create(auteur);
	}

	@JsonView(Views.Auteur.class)
	@PutMapping("/{id}")
	public Auteur modifierAuteur(@PathVariable Integer id,@RequestBody Auteur auteur)
	{
		log.info("methode AuteurRestController.modifierAuteur(id) avec id = "+id);

		auteur.setId(id);
		return (Auteur) auteurSrv.update(auteur);
	}

	@JsonView(Views.Auteur.class)
	@DeleteMapping("/{id}")
	public void supprimerAuteur(@PathVariable Integer id) {
		log.info("methode AuteurRestController.supprimerAuteur()");

		auteurSrv.deleteById(id);
	}
}
