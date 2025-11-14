package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Auteur;

public interface IDAOAuteur extends JpaRepository<Auteur, Integer>{

}
