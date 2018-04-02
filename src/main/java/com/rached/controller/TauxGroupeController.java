package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Groupe;
import com.rached.model.Taux;
import com.rached.services.GroupeServiceImpl;
import com.rached.services.TauxServicesImpl;

@RestController
@RequestMapping("/api/tauxgroupe")
public class TauxGroupeController {

	@Autowired
	@Qualifier("tauxServicesImpl")
	TauxServicesImpl taux;
	
	@Autowired
	@Qualifier("groupeServiceImpl")
	GroupeServiceImpl groupe;
	// groupes
	@RequestMapping(value="/allGroupes",method= RequestMethod.GET )
	public List<Groupe>getAllGroupe(){
		return groupe.getAllRecords();
	}
	@RequestMapping(value = "/findGroupe/{code}", method = RequestMethod.GET)
	public Groupe getGROUPE(@PathVariable("code") Long id) {
		return groupe.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertGroupe", method = RequestMethod.POST )
	public Groupe insertPays(@RequestBody Groupe elem) {
		elem.setTaux(taux.getRecordById(elem.getTaux().getIdTaux()));
		return groupe.insertRecord(elem);
	}
	@RequestMapping(value = "/updateGroupe", method = RequestMethod.POST)
	public Groupe updatePays(@RequestBody Groupe elem) {
		elem.setTaux(taux.getRecordById(elem.getTaux().getIdTaux()));
		 return groupe.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteGroupe/{code}", method = RequestMethod.GET)
	public void deleteGroupe(@PathVariable("code") int code) {
		groupe.deleteRecord(Long.valueOf(code));
	}
	
	// taux
	
	@RequestMapping(value="/allTaux",method= RequestMethod.GET )
	public List<Taux>getAllTaux(){
		return taux.getAllRecords();
	}
	@RequestMapping(value = "/findTaux/{code}", method = RequestMethod.GET)
	public Taux getTaux(@PathVariable("code") Long id) {
		return taux.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertTaux", method = RequestMethod.POST )
	public Taux insertTaux(@RequestBody Taux elem) {
		return taux.insertRecord(elem);
	}
	@RequestMapping(value = "/updateTaux", method = RequestMethod.POST)
	public Taux updateTaux(@RequestBody Taux elem) {
		 return taux.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteTaux/{code}", method = RequestMethod.GET)
	public void deleteTaux(@PathVariable("code") int code) {
		taux.deleteRecord(Long.valueOf(code));
	}
}
