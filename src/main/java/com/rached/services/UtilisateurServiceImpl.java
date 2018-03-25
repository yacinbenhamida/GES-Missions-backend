package com.rached.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Departement;
import com.rached.model.Fonction;
import com.rached.model.UserStruct;
import com.rached.model.Utilisateur;
@Service
@Qualifier("utilisateurServiceImpl")
public class UtilisateurServiceImpl implements UtilisateurServices{
	
	@Autowired 
	UserStructRepository repositoryjoint;

	@Autowired
	UtilisateurRepository repository;
	
	
	@Override
	public List<Utilisateur> getAllRecords() {
		List<Utilisateur> res = new ArrayList();
		Iterator<Utilisateur>it = repository.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Utilisateur getRecordById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Utilisateur insertRecord(Utilisateur elem) {
		return repository.save(elem);
	}
	@Override
	public void deleteRecord(int id) {
		if(repository.exists(id)) {
			repository.delete(id);
		}
		
	}
	@Override
	public Utilisateur updateRecord(Utilisateur elem) {
		if(repository.exists(elem.getCodeUtilisateur())) {		
			 return  repository.save(elem);
			}
		return null;
	}

	@Override
	public Utilisateur getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur verifyLoginCredentials(long login,String pw) {		
		return repository.findUserByCodeProfileAndName(login,pw);
	}

	@Override
	public UserStruct insertuserStruct(UserStruct us) {
		return repositoryjoint.save(us);
	}

	@Override
	public Utilisateur latestUser() {
		
	 Long id =  repository.findLastaddedUser();
	 return repository.findOne(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repository.delete(valueOf);
		
	}

	@Override
	public UserStruct updateUs(Utilisateur u, Departement d) {
		UserStruct us = new UserStruct();
		us.setUtilisateur(u);
		us.setDepartement(d);
	   us.setDateAffectation(Date.valueOf(LocalDate.now()));
	   repository.save(u);
	  return repositoryjoint.save(us);   
	}
	@Override
	public List<UserStruct> getUsOfUser(Utilisateur u) {
		return repositoryjoint.getAllStructsOfUser(u);
	}
	@Override
	public Departement getDepOfUser(Utilisateur u) {
		return repositoryjoint.getDeptOfUser(u);
	}
	@Override
	public void deleteUs(UserStruct u) {
		repositoryjoint.delete(u);	
	}
	@Override
	public UserStruct getUstbyId(Long id) {
		// TODO Auto-generated method stub
		return repositoryjoint.findOne(id);
	}

	@Override
	public Utilisateur gettUserByLogin(long login) {
		return repository.findUserByLogin(login);
	}
}
