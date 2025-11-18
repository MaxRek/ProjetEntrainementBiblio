package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.IDAOUtilisateur;

@Service
public class JpaUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private IDAOUtilisateur daoUtilisateur;
	
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		return User
				.withUsername(username)
				.password("$2a$10$zFeTn0rQKrsMXIT2I2NAl.70YWXs05/XyJsnSsznDjB4C.T0yv8hC")
				.roles("USER")
				.build()
	}*/

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return this.daoUtilisateur.findByLogin(login)
				.map(user -> User
						.withUsername(login)
						.password(user.getMdp())
						// .authorities("ROLE_USER")
						.roles("USER")
						.build()
						)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"))
		;
	}
	/*return User
	.withUsername(username)
	.password("$2a$10$zFeTn0rQKrsMXIT2I2NAl.70YWXs05/XyJsnSsznDjB4C.T0yv8hC")
	.roles("USER")
	.build();*/
}
