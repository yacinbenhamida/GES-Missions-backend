package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Categorie;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
	@Autowired
	@Qualifier("categorieServiceImpl")
	private Services<Categorie> implcat;
	
	@RequestMapping(value="/allCategories",method= RequestMethod.GET )
	public List<Categorie>getAllCats(){
		return implcat.getAllRecords();
	}
	@RequestMapping(value = "/findcat/{code}", method = RequestMethod.GET)
	public Categorie getCat(@PathVariable("code") Long id) {
		return implcat.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertCat", method = RequestMethod.POST )
	public Categorie insertCat(@RequestBody Categorie elem) {
		//System.out.println(""+elem.toString());
		return implcat.insertRecord(elem);
	}
	@RequestMapping(value = "/updateCat", method = RequestMethod.POST)
	public Categorie updateCat(@RequestBody Categorie elem) {
		 return implcat.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteCat/{code}", method = RequestMethod.GET)
	public void deleteCat(@PathVariable("code") int code) {
		implcat.deleteRecord(Long.valueOf(code));
	}
}
