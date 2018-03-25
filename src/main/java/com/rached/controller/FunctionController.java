package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rached.model.Fonction;
import com.rached.services.Services;
@RestController
@RequestMapping("/api/fonctions")
public class FunctionController {
	@Autowired
	@Qualifier("fonctionServiceImpl")
	private Services<Fonction> implfonct;
	
	@RequestMapping(value="/allFonctions",method= RequestMethod.GET )
	public List<Fonction>getAllFoncts(){
		return implfonct.getAllRecords();
	}
	@RequestMapping(value = "/findFonction/{code}", method = RequestMethod.GET)
	public Fonction getFonct(@PathVariable("code") Long id) {
		return implfonct.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertFonction", method = RequestMethod.POST )
	public Fonction insertFonct(@RequestBody Fonction elem) {
		//System.out.println(""+elem.toString());
		return implfonct.insertRecord(elem);
	}
	@RequestMapping(value = "/updateFonct", method = RequestMethod.POST)
	public Fonction updateFonct(@RequestBody Fonction elem) {
		 return implfonct.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteFonct/{code}", method = RequestMethod.GET)
	public void deleteFonct(@PathVariable("code") Long code) {
		implfonct.deleteRecord(Long.valueOf(code));
	}
}
