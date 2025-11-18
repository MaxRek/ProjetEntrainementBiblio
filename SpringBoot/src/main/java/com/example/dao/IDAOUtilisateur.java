package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.response.UtilisateurProjectionResponse;
import com.example.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{
	public Optional<Utilisateur> findByLogin(String login);
	
	// @Query("select u from Utilisateur u")
    public List<UtilisateurProjectionResponse> findAllProjectedBy();

    public <T> List<T> findAllProjectedBy(Class<T> clz);
}
