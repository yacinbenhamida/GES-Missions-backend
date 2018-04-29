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
import com.rached.model.Departement;
import com.rached.model.Mission;
import com.rached.model.Missionaire;
import com.rached.model.Theme;
import com.rached.services.DepartementServices;
import com.rached.services.MissionServices;
import com.rached.services.MissionaireServices;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/missions")
public class MissionsController {
	@Autowired
	@Qualifier("missionServiceImpl")
	private MissionServices implmiss;

	@Autowired
	@Qualifier("departementServiceImpl")
	private DepartementServices impldep;
	@Autowired
	@Qualifier("themeServiceImpl")
	private Services<Theme> impltheme;
	@RequestMapping(value="/allMissionsOfDep/{codeDep}",method= RequestMethod.GET )
	public List<Mission>getAllMissions(@PathVariable("codeDep") String codeDep){
		return implmiss.getAllMissionsOfDepartement(codeDep);
	}
	@RequestMapping(value="/LatestMissionOfdep/{codeDep}",method= RequestMethod.GET )
	public Long getLatestMissDep(@PathVariable("codeDep") String codeDep){
		return implmiss.getLatestCodeMOfDepartement(codeDep);
	}
	// 
	@RequestMapping(value = "/findMissionByNum/{code}/{codeDep}", method = RequestMethod.GET)
	public Mission getMissionByNum(@PathVariable("code") Long id,@PathVariable("codeDep")String codeDep) {
		return implmiss.getMissByNum(Long.valueOf(id),codeDep);
	}
	
	@RequestMapping(value = "/findMission/{code}", method = RequestMethod.GET)
	public Mission getMission(@PathVariable("code") Long id) {
		return implmiss.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertMission", method = RequestMethod.POST )
	public Mission insertMission(@RequestBody Mission elem) {
		Departement dep = impldep.getRecordBycode(elem.getDepartement().getCodeDep());
		elem.setDepartement(dep);
		Theme th = impltheme.getRecordById(elem.getTheme().getIdtheme());
		elem.setTheme(th);
		return implmiss.insertRecord(elem);
	}
	@RequestMapping(value = "/updateMission", method = RequestMethod.POST)
	public Mission updateMission(@RequestBody Mission elem) {
		 return implmiss.updateRecord(elem);
	}
	
	@RequestMapping(value = "/deleteMission/{code}", method = RequestMethod.GET)
	public void deleteMission(@PathVariable("code") int code) {
		implmiss.deleteRecord(Long.valueOf(code));
	}
}
