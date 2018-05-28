package com.rached.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.AffectMissDep;
import com.rached.model.Missionaire;
import com.rached.services.DepartementServices;
import com.rached.services.MissionaireServices;

@RestController
@RequestMapping("/api/missionaires")

public class MissionairesController {
	@Autowired
	@Qualifier("missionaireServicesImpl")
	private MissionaireServices implmiss;
	@Autowired
	@Qualifier("departementServiceImpl")
	private DepartementServices deps;
	// not having any missions bettween the two dates
	@RequestMapping(value="/getallMissionairesNHAM/{dateDep}/{dateArr}/{codeDep}",method= RequestMethod.GET )
	public List<Missionaire>getallMissionairesNHAM(@PathVariable("dateDep") Date deb,@PathVariable("dateArr") Date end,@PathVariable("codeDep")String dep){
		return implmiss.getAllMissNotHavingMissions(deb, end, deps.getRecordBycode(dep));
	}
	
	@RequestMapping(value="/getCurrentDepOFMIssionaire/{idMiss}",method= RequestMethod.GET )
	public AffectMissDep getCurrentDepOFMIssionaire(@PathVariable("idMiss") long idMiss){
		return implmiss.getCurrentDepOFMIssionaire(idMiss);
	}
	
	@RequestMapping(value="/getAllAffectationOfMissionaire/{idMiss}",method= RequestMethod.GET )
	public List<AffectMissDep>getAllAffectationOfMissionaire(@PathVariable("idMiss") long idMiss){
		return implmiss.getAllAffectationOfMissionaire(idMiss);
	}
	@RequestMapping(value="/getallMissionairesOfDEP/{codeDep}",method= RequestMethod.GET )
	public List<Missionaire>getAllMissionairesOfDep(@PathVariable("codeDep") String codeDep){
		return implmiss.getAllMissionairesDep(codeDep);
	}
	
	@RequestMapping(value="/allMissionairesOfDEP/{codeDep}",method= RequestMethod.GET )
	public List<AffectMissDep>getAllMissionaires(@PathVariable("codeDep") String codeDep){
		return implmiss.getMissionairesOfDepartement(codeDep);
	}
	@RequestMapping(value = "/findMissionaire/{code}", method = RequestMethod.GET)
	public Missionaire getMissionaire(@PathVariable("code") Long id) {
		return implmiss.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/findMissionaireByCIN/{cin}", method = RequestMethod.GET)
	public Missionaire getMissionaireBYCIN(@PathVariable("cin") Long cin) {
		return implmiss.getMissByCIN(cin);
	}
	
	@RequestMapping(value = "/insertMissionaire", method = RequestMethod.POST )
	public AffectMissDep insertMissionaire(@RequestBody AffectMissDep elem) {
		elem.setDateAffectation(Date.valueOf(LocalDate.now()));
		Missionaire m = implmiss.insertRecord(elem.getMissionaire());
		System.out.println(m+"");
		elem.setMissionaire(implmiss.getMissByCIN(m.getCin()));
		return implmiss.insertMissionaireWithAffectation(elem);
	}
	@RequestMapping(value = "/updateAffectMissionaire", method = RequestMethod.POST)
	public AffectMissDep updateMissionaireAffectation(@RequestBody AffectMissDep elem) {
	     elem.setDateAffectation(Date.valueOf(LocalDate.now()));
		 return implmiss.updateMissDep(elem);
	}
	
	@RequestMapping(value = "/updateMissionaire", method = RequestMethod.POST)
	public Missionaire updateMissionaire(@RequestBody Missionaire elem) {
		 return implmiss.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteMissionaire/{code}/{codeAff}", method = RequestMethod.GET)
	public void deleteMissionaire(@PathVariable("code") int code,@PathVariable("codeAff") int codeAff) {
		implmiss.deleteAffectation(codeAff);
		implmiss.deleteRecord(Long.valueOf(code));
	}
}
