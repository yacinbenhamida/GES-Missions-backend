package com.rached.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Departement;
import com.rached.model.UserStruct;
import com.rached.model.Utilisateur;
import com.rached.services.DepartementServiceImpl;
import com.rached.services.DepartementServices;
import com.rached.services.Services;
import com.rached.services.UtilisateurServiceImpl;
import com.rached.services.UtilisateurServices;
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	@Qualifier("utilisateurServiceImpl")
	private UtilisateurServices impl;

	@Autowired
	@Qualifier("departementServiceImpl")
	private DepartementServices depserv;
	

	@RequestMapping(value="/getUsOfUser/{code}",method=RequestMethod.GET)
	public UserStruct getUsOfUser(@PathVariable("code") Long code){
		return impl.getUsOfUser(code);
	}
	@RequestMapping(value="/allUsers",method=RequestMethod.GET)
	public List<Utilisateur>getAllusers(){
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/findUser/{code}", method = RequestMethod.GET)
	public Utilisateur getUser(@PathVariable("code") Long code) {
		return impl.getRecordById(Long.valueOf(code));
	}
	
	@RequestMapping(value = "/findDepOfUser/{code}", method = RequestMethod.GET)
	public Departement getDepOfUser(@PathVariable("code") Long code) {
		Utilisateur u = impl.getRecordById(code);
		System.out.println("user "+u);
		//System.out.println("departement : "+impl.getDepOfUser(u));
		return impl.getDepOfUser(u);
	}
	
	@RequestMapping(value = "/insertUser", method =  RequestMethod.POST  )
	public Utilisateur insertUser(@RequestBody Utilisateur elem) {
		return impl.insertRecord(elem);
	}
	
	@RequestMapping(value = "/affectuser", method = RequestMethod.POST)
	public UserStruct affectUser(@RequestBody UserStruct us) {
		Departement d = depserv.getRecordBycode(us.getDepartement().getCodeDep());
		Utilisateur u = impl.getRecordById(us.getUtilisateur().getCodeUtilisateur());
		us.setDepartement(d);
		us.setUtilisateur(u);
		us.setDateAffectation(Date.valueOf(LocalDate.now()));
		return impl.insertuserStruct(us);
	}
	
	@RequestMapping(value = "/userStruct", method = RequestMethod.POST)
	public UserStruct insertUserStruct(@RequestBody UserStruct us) {
		//Departement d = depserv.getRecordBycode(us.getDepartement().getCodeDep());
		System.out.println("us  " +us+"");
		impl.insertRecord(us.getUtilisateur());
		Utilisateur u = impl.gettUserByLogin(us.getUtilisateur().getLogin());
		//us.setDepartement(d);
		us.setDateAffectation(Date.valueOf(LocalDate.now()));
		us.setUtilisateur(u);
		return impl.insertuserStruct(us);
	}
	
	
	@RequestMapping(value="/verifLoginUser/{login}/{password}",method = RequestMethod.GET)
	public Utilisateur getLoginCredentialsUser(@PathVariable("login")long login ,@PathVariable("password")String pw) {
		return impl.verifyLoginCredentials(login,pw);
	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public UserStruct updateUser(@RequestBody UserStruct elem) {	
		System.out.println("userstruct : "+elem);
		return impl.updateUs(elem);
	}
	@RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
	public Utilisateur updateUsers(@RequestBody Utilisateur u) {	
		return impl.updateRecord(u);
	}
	@RequestMapping(value = "/deleteUser/{code}", method = RequestMethod.GET)
	public void deleteUser(@PathVariable("code") int code) {
		//Utilisateur u = impl.getRecordById(code);
		impl.deleteRecord(Long.valueOf(code));
		}
	
	@RequestMapping(value = "/deleteUserStruct/{code}", method = RequestMethod.GET)
	public void deleteUserStruct(@PathVariable("code") Long code) {
			UserStruct us =impl.getUstbyId(code);
			impl.deleteUs(us);
		}
	
	@RequestMapping(value = "/AllUserStructs/{code}", method = RequestMethod.GET)
	public List<UserStruct> getAllUserStructs(@PathVariable("code") Long code) {
		Utilisateur u = impl.getRecordById(code);
		return impl.getUsOfUser(u);
	}

}
