package com.rached.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.OrdreMission;
import com.rached.services.AvoirBudgDepServices;
import com.rached.services.OrdreConcernePayService;
import com.rached.services.OrdreMissService;
import com.rached.services.OrdreConcernePaysRepository.Results;
/*
 * DEDICATED SERVICE TO REPORTS 
 * SERVICE DEDIE POUR LA GENERATION DES RAPPORTS 
 */
@RestController
@RequestMapping("/api/reports")
public class ReportingController {
	
	// les missions faites pour un pays donnée
	// scheduled missions for a given country
	@Autowired
	@Qualifier("ordreMissionServiceImpl")
	OrdreMissService missions;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("avoirBudgDepServicesImpl")
	AvoirBudgDepServices budgdep;
	@Autowired
	@Qualifier("ordreConcernePayServiceImpl")
	OrdreConcernePayService concerne;
	// get all missions of given country between 2 dates 
	@RequestMapping(value="/getMissionsBTDAC/{idpays}/{deb}/{fin}/{codeDep}",method= RequestMethod.GET )
	public List<OrdreMission>getMissionsBTDAC(@PathVariable("idpays")long idpays,
			@PathVariable("deb")Date debut,@PathVariable("fin")Date fin,@PathVariable("codeDep")String codeDep){
		return missions.getAllMissBTDAC(idpays, debut, fin,codeDep);
	}
	
	// get all missions of current dep between 2 dates 
		@RequestMapping(value="/getMissionsBTDA/{deb}/{fin}/{codeDep}",method= RequestMethod.GET )
		public List<OrdreMission>getMissionsBTDA(@PathVariable("deb")Date debut,@PathVariable("fin")Date fin,@PathVariable("codeDep")String codeDep){
			return missions.getAllMissBTDA(debut, fin,codeDep);
		}
		
		@RequestMapping(value="/getAllyears/{codeDep}",method = RequestMethod.GET)
		public List<Integer>getYears(@PathVariable("codeDep")String codeDep){
			return budgdep.getYears(codeDep);
		}
		
		@RequestMapping(value="/getPaysStats/{codeDep}/{year}",method = RequestMethod.GET)
		public List<Results>getPaysStats(@PathVariable("codeDep")String codeDep,@PathVariable("year")int year){
			return concerne.getPaysStats(codeDep,year);
		}
}	
