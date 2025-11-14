package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Livre;

public interface IDAOLivre extends JpaRepository<Livre,Integer> {

}
