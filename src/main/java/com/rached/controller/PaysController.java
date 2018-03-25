package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Pays;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/pays")
public class PaysController {
	@Autowired
	@Qualifier("paysServicesImpl")
	private Services<Pays> impl;
	
	@RequestMapping(value="/allPays",method= RequestMethod.GET )
	public List<Pays>getAllPays(){
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/findPays/{code}", method = RequestMethod.GET)
	public Pays getPays(@PathVariable("code") Long id) {
		return impl.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertPays", method = RequestMethod.POST )
	public Pays insertPays(@RequestBody Pays elem) {
		//System.out.println(""+elem.toString());
		return impl.insertRecord(elem);
	}
	@RequestMapping(value = "/updatePays", method = RequestMethod.POST)
	public Pays updatePays(@RequestBody Pays elem) {
		 return impl.updateRecord(elem);
	}
	@RequestMapping(value = "/deletePays/{code}", method = RequestMethod.GET)
	public void deletePays(@PathVariable("code") int code) {
		impl.deleteRecord(Long.valueOf(code));
	}
}
