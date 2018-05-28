package com.rached.services;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Serializable>{
	@Query("select u from Utilisateur u where u.login = ?1 and u.motDePasse = ?2")
	Utilisateur findUserByCodeProfileAndName(long login,String pw);
	
	
	@Query ("select MAX(u.codeUtilisateur) from Utilisateur u")
	Long findLastaddedUser();
	
	@Query("select distinct(u) from Utilisateur u where u.login=?1" )
	Utilisateur findUserByLogin(long login);
 
}
