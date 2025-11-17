package com.example.rest;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonView;

import com.example.model.Livre;
import com.example.service.LivreService;
import com.example.view.Views;

@RestController
@RequestMapping("/api/livre")
@CrossOrigin("*")
public class LivreRestController {

	@Autowired
	LivreService livreSrv;

	@JsonView(Views.Livre.class)
	@GetMapping
	public List<Livre> allLivres()
	{
		return livreSrv.getAll();
	}

	@JsonView(Views.Livre.class)
	@GetMapping("/{id}")
	public Livre ficheLivre(@PathVariable Integer id, Livre livre) {
		return livreSrv.getById(id);
	}

	@PostMapping
	public Livre ajoutLivre(@RequestBody Livre livre)
	{
		return livreSrv.create(livre);
	}

	@JsonView(Views.Livre.class)
	@PutMapping("/{id}")
	public Livre modifierLivre(@PathVariable Integer id, @RequestBody Livre livre)
	{
		livre.setId(id);
		return (Livre) livreSrv.update(livre);
	}

	@JsonView(Views.Livre.class)
	@DeleteMapping("/{id}")
	public void supprimerLivre(@PathVariable Integer id) {
		livreSrv.deleteById(id);
	}
}
