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

import com.example.model.Collection;
import com.example.service.CollectionService;
import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/collection")
@CrossOrigin(origins = "http://localhost:4200")
public class CollectionRestController {

	@Autowired
	CollectionService srv;

	@JsonView(Views.Collection.class)
	@GetMapping
	public List<Collection> allCollections() {
		return srv.getAll();
	}

	@JsonView(Views.Collection.class)
	@GetMapping("/{id}")
	public Collection ficheCollection(@PathVariable Integer id, Collection collection) {
		return srv.getById(id);
	}

	@PostMapping
	public Collection ajoutCollection(@RequestBody Collection collection) {
		return srv.create(collection);
	}

	@JsonView(Views.Collection.class)
	@PutMapping("/{id}")
	public Collection modifierCollection(@PathVariable Integer id, @RequestBody Collection collection) {
		collection.setId(id);
		return (Collection) srv.update(collection);
	}

	@JsonView(Views.Collection.class)
	@DeleteMapping("/{id}")
	public void supprimerCollection(@PathVariable Integer id) {
		srv.deleteById(id);
	}

}
