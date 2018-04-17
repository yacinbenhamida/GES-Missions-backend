package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rached.model.OrdreMission;
import com.rached.services.MissionServices;
import com.rached.services.MissionaireServices;
import com.rached.services.OrdreMissService;

@RestController
@RequestMapping("/api/ordremissions")
public class OrdreMissionsController {
	@Autowired
	@Qualifier("ordreMissionServiceImpl")
	private OrdreMissService implordre;
	@Autowired
	@Qualifier("missionServiceImpl")
	private MissionServices implmiss;
	@Autowired
	@Qualifier("missionaireServicesImpl")
	private MissionaireServices implmissionaire;
	
	@RequestMapping(value="/getOrdresvalides/{codeDep}",method= RequestMethod.GET )
	public List<OrdreMission> getOrdresAcetatV(@PathVariable("codeDep") String codeDep){
		return implordre.getOrdresetatV(codeDep);
	}
	@RequestMapping(value="/latestOrdMiss/{idMiss}",method= RequestMethod.GET )
	public Long getLetestOrdreMissionsIndex(@PathVariable("idMiss") long idMiss){
		return implordre.getLatestNumOrdre(idMiss);
	}
	
	@RequestMapping(value="/allOrdresMissionsOfMiss/{idMiss}",method= RequestMethod.GET )
	public List<OrdreMission>getAllOrdresMissionsOfMiss(@PathVariable("idMiss") long idMiss){
		return implordre.getAllOrdresOfMission(idMiss);
	}
	
	@RequestMapping(value="/allOrdresMissionsOfDep/{codeDep}",method= RequestMethod.GET )
	public List<OrdreMission>getAllOrdresMissions(@PathVariable("codeDep") String codeDep){
		return implordre.getAllOrdresOfDep(codeDep);
	}
	@RequestMapping(value = "/findOrdreMiss/{code}/{numMission}", method = RequestMethod.GET)
	public OrdreMission getOrdMission(@PathVariable("code") Long id,@PathVariable("numMission") Long numMis) {
		return implordre.getOrdMOfMission(id, numMis);
	}
	@RequestMapping(value = "/insertOrdreMission", method = RequestMethod.POST )
	public OrdreMission insertOrdMission(@RequestBody OrdreMission elem) {
		System.out.println("ordre : "+ elem);
		elem.setMissionaire(implmissionaire.getMissByCIN(elem.getMissionaire().getCin()));
		elem.setMission(implmiss.getMissByNum(elem.getMission().getNumMission()));
		elem.setEtat("E");
		return implordre.insertRecord(elem);
	}
	
	
	@RequestMapping(value = "/updateOrdMission", method = RequestMethod.POST)
	public OrdreMission updateOrdMission(@RequestBody OrdreMission elem) {
		elem.setMission(implmiss.getMissByNum(elem.getMission().getNumMission()));
		elem.setMissionaire(implmissionaire.getMissByCIN(elem.getMissionaire().getCin()));
		 return implordre.updateRecord(elem);
	}
	
	@RequestMapping(value = "/deleteOrdMission/{code}", method = RequestMethod.GET)
	public void deleteMission(@PathVariable("code") int code) {
		implordre.deleteRecord(Long.valueOf(code));
	}
}
