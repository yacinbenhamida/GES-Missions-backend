package com.rached.services;

import java.util.List;

import com.rached.model.Departement;
import com.rached.model.UserStruct;
import com.rached.model.Utilisateur;

public interface UtilisateurServices extends Services<Utilisateur>{
	Utilisateur verifyLoginCredentials(long login,String pw);
	UserStruct insertuserStruct(UserStruct us);
	Utilisateur latestUser();
	UserStruct updateUs(UserStruct us);
	List<UserStruct> getUsOfUser(Utilisateur u);
	Departement getDepOfUser(Utilisateur u);
	void deleteUs(UserStruct u);
	UserStruct getUstbyId(Long id);
	Utilisateur gettUserByLogin(long login);
	UserStruct getUsById (long id);
	UserStruct getUsOfUser(long id);
}
