package com.rached.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rached.model.Departement;
import com.rached.model.Projet;
import com.rached.services.DepartementServices;
import com.rached.services.ProjetServices;

@RestController
@RequestMapping("/api/projets")
public class ProjetController {
	@Autowired
	@Qualifier("projetServicesImpl")
	private ProjetServices impl;
	
	@Autowired
	@Qualifier("departementServiceImpl")
	private DepartementServices impldep;
	
	@RequestMapping(value="/allProjets",method= RequestMethod.GET )
	public List<Projet>getAllProjets(){
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/insertProjet", method = RequestMethod.POST )
	public Projet insertProjet(@RequestBody Projet elem) {
		return impl.insertRecord(elem);
	}
	@RequestMapping(value = "/findProjet/{code}", method = RequestMethod.GET)
	public Projet getProjet(@PathVariable("code") Long id) {
		return impl.getRecordById(Long.valueOf(id));
	}
	
	@RequestMapping(value = "/allProjetsOfDep/{code}", method = RequestMethod.GET)
	public List<Projet> getProjetsOfDepartement(@PathVariable("code") String id) {
		Departement d = impldep.getRecordBycode(id);
		return impl.getAllProjetsofdep(d);
	}
	
	@RequestMapping(value = "/updateProjet", method = RequestMethod.POST)
	public Projet updateProjet(@RequestBody Projet elem) {
		 return impl.updateRecord(elem);
	}
	


	
}
