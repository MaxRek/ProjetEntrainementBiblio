package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Editeur;
import com.example.service.EditeurService;
import com.example.view.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/editeur")
public class EditeurRestController {

    @Autowired
    EditeurService editeurService;

    @JsonView(Views.Editeur.class)
    @GetMapping
    public List<Editeur> allEditeurs() {
        return editeurService.getAll();
    }

    @JsonView(Views.Editeur.class)
    @GetMapping("/{id}")
    public Editeur ficheEditeur(@PathVariable Integer id, Editeur editeur) {
        return editeurService.getById(id);
    }

    @PostMapping
    public Editeur ajoutEditeur(@RequestBody Editeur editeur) {
        return editeurService.create(editeur);
    }

    @JsonView(Views.Editeur.class)
    @PutMapping("/{id}")
    public Editeur modifierEditeur(@PathVariable Integer id, @RequestBody Editeur editeur) {
        editeur.setId(id);
        return editeurService.update(editeur);
    }

    @JsonView(Views.Editeur.class)
    @DeleteMapping("/{id}")
    public void supprimerEditeur(@PathVariable Integer id) {
        editeurService.deleteById(id);
    }
}
