package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Concerne;
import com.rached.model.Pays;
import com.rached.services.OrdreConcernePayServiceImpl;
import com.rached.services.OrdreMissService;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/concerne")

public class ConcerneController {
	@Autowired
	@Qualifier("ordreConcernePayServiceImpl")
	private OrdreConcernePayServiceImpl impl;
	
	@Autowired
	@Qualifier("ordreMissionServiceImpl")
	private OrdreMissService implordre;
	
	@Autowired
	@Qualifier("paysServicesImpl")
	private Services<Pays> implpays;
	
	@RequestMapping(value="/allConcernes",method= RequestMethod.GET )
	public List<Concerne>getAllConc(){
		return impl.getAllRecords();
	}
	
	@RequestMapping(value="/allConcernesOfOrdre/{id}/{codeDep}",method= RequestMethod.GET )
	public List<Concerne>getAllConcerneOfOrdre(@PathVariable("id") Long id,@PathVariable("codeDep")String codeDep){
		return impl.getAllConcerneoford(id,codeDep);
	}
	
	@RequestMapping(value = "/findConcerne/{code}", method = RequestMethod.GET)
	public Concerne getConc(@PathVariable("code") Long id) {
		return impl.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertConcerne", method = RequestMethod.POST )
	public Concerne insertConc(@RequestBody Concerne elem) {
		elem.setOrdre(implordre.getRecordById(elem.getOrdre().getIdOrdre()));
		elem.setPays(implpays.getRecordById(elem.getPays().getIdpays()));
		return impl.insertRecord(elem);
	}
	@RequestMapping(value = "/updateConcerne", method = RequestMethod.POST)
	public Concerne updateConc(@RequestBody Concerne elem) {
		elem.setOrdre(implordre.getRecordById(elem.getOrdre().getIdOrdre()));
		elem.setPays(implpays.getRecordById(elem.getPays().getIdpays()));
		 return impl.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteConcerne/{code}", method = RequestMethod.GET)
	public void deleteConc(@PathVariable("code") Long code) {
		impl.deleteRecord(Long.valueOf(code));
	}
}
