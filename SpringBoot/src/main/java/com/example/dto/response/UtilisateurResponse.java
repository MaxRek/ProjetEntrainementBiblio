package com.example.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.model.Utilisateur;

public class UtilisateurResponse {
	private int id;
	private String login;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public static UtilisateurResponse convert(Utilisateur utilisateur) {
		UtilisateurResponse resp = new UtilisateurResponse();
		
		BeanUtils.copyProperties(utilisateur, resp);
		
		return resp;
	}
}
