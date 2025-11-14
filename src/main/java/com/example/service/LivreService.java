package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.IDAOLivre;
import com.example.model.Livre;

public class LivreService {

	@Autowired
	IDAOLivre daoLivre;

	public Livre getById(Integer id)
	{
		Optional <Livre> opt = daoLivre.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return opt.get();}
	}

	public List<Livre> getAll()
	{
		return daoLivre.findAll();
	}

	public Livre create(Livre Livre) 
	{
		return daoLivre.save(Livre);
	}

	public Livre update(Livre Livre) 
	{
		return daoLivre.save(Livre);
	}

	public void deleteById(Integer id) 
	{
		daoLivre.deleteById(id);
	}

	public void delete(Livre Livre)
	{
		daoLivre.delete(Livre);
	}
	
}
