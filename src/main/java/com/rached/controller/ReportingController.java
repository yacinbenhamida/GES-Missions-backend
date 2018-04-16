package com.rached.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rached.model.Mission;
import com.rached.model.OrdreMission;
import com.rached.services.MissionServices;
import com.rached.services.OrdreMissService;
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
	
	// get all missions of given country between 2 dates 
	@RequestMapping(value="/getMissionsBTDAC/{idpays}/{deb}/{fin}/{codeDep}",method= RequestMethod.GET )
	public List<OrdreMission>getMissionsBTDAC(@PathVariable("idpays")long idpays,
			@PathVariable("deb")Date debut,@PathVariable("fin")Date fin,@PathVariable("codeDep")String codeDep){
		return missions.getAllMissBTDAC(idpays, debut, fin,codeDep);
	}
}	
