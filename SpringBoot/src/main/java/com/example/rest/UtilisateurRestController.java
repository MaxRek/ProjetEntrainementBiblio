package com.example.rest;

import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IDAOUtilisateur;
import com.example.dto.request.AuthUserRequest;
import com.example.dto.request.SubscribeUserRequest;
import com.example.dto.response.UtilisateurProjection2Response;
import com.example.dto.response.UtilisateurProjectionResponse;
import com.example.dto.response.UtilisateurResponse;
import com.example.model.Utilisateur;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurRestController {
	private final static Logger log = LoggerFactory.getLogger(UtilisateurRestController.class);

	@Autowired
	IDAOUtilisateur daoUtilisateur;
	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager am;
	
	@GetMapping("projected-by")
	public List<UtilisateurProjectionResponse> findAllProjectedby(){
		//return this.daoUtilisateur.findAllProjectedBy(UtilisateurProjectionResponse.class);
		return this.daoUtilisateur.findAllProjectedBy();
	}
	
	@GetMapping("projected-by-2")
    public List<UtilisateurProjection2Response> findAllProjectedBy2() {
        return this.daoUtilisateur.findAllProjectedBy(UtilisateurProjection2Response.class);
    }
	
	//@PreAuthorize("hasRole('USER')")
	//@PostAuthorize("hasRole('USER')")

	@GetMapping	
	public List<UtilisateurResponse> findAll(){
		log.info("methode UtilisateurRestController.findAll()");

		// List<Utilisateur> users = this.dao.findAll();

        // System.out.println(users.size());

        // List<Utilisateur> users2 = users.stream()
        //     .filter(user -> user.getId() == 1)
        //     .toList()
        // ;

        // System.out.println(users2.size());
        // System.out.println(users.size());
		
		return this.daoUtilisateur.findAll().stream()
				.map(user-> UtilisateurResponse.convert(user))
				.toList()
			;
	}
	
	@PostMapping
	public int subscribe(@RequestBody SubscribeUserRequest request) {
		log.info("methode UtilisateurRestController.subscribe()");

		Utilisateur utilisateur = new Utilisateur();
		String encodedPassword = this.passwordEncoder.encode(request.getMdp());
		
		BeanUtils.copyProperties(request, utilisateur);
		
		utilisateur.setLogin(request.getLogin());
		utilisateur.setMdp(encodedPassword);

		this.daoUtilisateur.save(utilisateur);
		
		return utilisateur.getId();
	}
	
	@PostMapping("connexion")
	public String connexion(@RequestBody AuthUserRequest request)
	{
		log.info("methode UtilisateurRestController.connexion()");

		Date now = new Date();
        String key = "6E5A7234753778214125442A472D4B6150645367556B58703273357638792F42";
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
        
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getMdp());
        
        this.am.authenticate(auth); 

        return Jwts.builder()
        		.subject(request.getLogin())// <- le username normalement
        		.issuedAt(now)
        		.expiration(new Date(now.getTime() + 300_000)) // valide pendant 5 minutes
        		.signWith(secretKey)
        		.compact() // pour envoyer un string
    		;
	}
}
