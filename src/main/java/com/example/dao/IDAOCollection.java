package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Collection;

public interface IDAOCollection extends JpaRepository<Collection, Integer>{

	
}
