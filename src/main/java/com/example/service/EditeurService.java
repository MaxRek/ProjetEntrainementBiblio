package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IDAOEditeur;
import com.example.model.Editeur;


@Service
public class EditeurService {

    @Autowired
    IDAOEditeur daoEditeur;

    public Editeur getById(Integer id) throws RuntimeException 
    {
        if(id==null) 
		{
			throw new RuntimeException("L'id d'une matiere ne peut pas etre null");	
		}
		Optional <Editeur> opt = daoEditeur.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return opt.get();}
    }

    public List<Editeur> getAll() 
    {
        return daoEditeur.findAll();
    }

    public List<Editeur> getAllByNomLike(String nom) 
    {
        return daoEditeur.findByNomContaining(nom);
    }

    public Editeur create(Editeur editeur)
    {
        return daoEditeur.save(editeur);
    }

    public Editeur update(Editeur editeur)
    {
        return daoEditeur.save(editeur);
    }

    public void deleteById(Integer id)
    {
        daoEditeur.deleteById(id);
    }

    public void delete(Editeur editeur)
    {
        daoEditeur.delete(editeur);
    }
        

}
