package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Editeur;

public interface IDAOEditeur extends JpaRepository<Editeur, Integer> {

    public List<Editeur> findByNomContaining(String recherche);
}
