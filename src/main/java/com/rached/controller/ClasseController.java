package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Classe;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/classes")

public class ClasseController {
	@Autowired
	@Qualifier("classeServiceImpl")
	private Services<Classe> implclasse;
	
	@RequestMapping(value="/allClasses",method= RequestMethod.GET )
	public List<Classe>getAllClasses(){
		return implclasse.getAllRecords();
	}
	@RequestMapping(value = "/findClasse/{code}", method = RequestMethod.GET)
	public Classe getClasse(@PathVariable("code") Long id) {
		return implclasse.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertClasse", method = RequestMethod.POST )
	public Classe insertClasse(@RequestBody Classe elem) {
		//System.out.println(""+elem.toString());
		return implclasse.insertRecord(elem);
	}
	@RequestMapping(value = "/updateClasse", method = RequestMethod.POST)
	public Classe updateClasse(@RequestBody Classe elem) {
		 return implclasse.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteClasse/{code}", method = RequestMethod.GET)
	public void deleteClasse(@PathVariable("code") Long code) {
		implclasse.deleteRecord(Long.valueOf(code));
	}
}
