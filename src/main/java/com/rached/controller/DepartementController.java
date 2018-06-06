package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Departement;
import com.rached.model.TypeDep;
import com.rached.services.DepartementServices;
@RestController
@RequestMapping("/api/departement")

public class DepartementController {

	@Autowired
	@Qualifier("departementServiceImpl")
	private DepartementServices implserv;
	
	@RequestMapping(value="/allDeparts",method= RequestMethod.GET )
	public List<Departement>getAllDeparts(){
		return implserv.getAllRecords();
	}
	
	@RequestMapping(value="/allDepartsOftype/{codetype}",method= RequestMethod.GET )
	public List<Departement>getAllDepartsOftype(@PathVariable("codetype") long code){
		TypeDep type = new TypeDep();
		type = implserv.getTypeDepByid(code);
		return implserv.getAllDepsOfType(type);
	}
	@RequestMapping(value="/allDepartsOfMinis/{codetype}",method= RequestMethod.GET )
	public List<Departement>getAllDepartsOfMinis(@PathVariable("codetype") long code){
		return implserv.getAllDepsOfMinistere(code);
	}
	@RequestMapping(value = "/findDepart/{code}", method = RequestMethod.GET)
	public Departement getDepart(@PathVariable("code") String code) {
		return implserv.getRecordBycode(code);
	}
	@RequestMapping(value = "/findLatestDepart/{code}/{typedep}", method = RequestMethod.GET)
	public String getLatestDepart(@PathVariable("code") String code,@PathVariable("typedep") String typedep) {
		return implserv.getMaxIdDep(code,typedep);
	}
	@RequestMapping(value = "/insertDepart", method = RequestMethod.POST )
	public Departement insertDepart(@RequestBody Departement elem) {
		TypeDep t = implserv.getTypeDepByid(elem.getTypedep().getIdtypedep());
		elem.setTypedep(t);
		return implserv.insertRecord(elem);
	}
	@RequestMapping(value = "/updateDepart", method = RequestMethod.POST)
	public Departement updateDepart(@RequestBody Departement elem) {
		 return implserv.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteDepart/{code}", method = RequestMethod.GET)
	public void deleteDepart(@PathVariable("code") String code) {
		implserv.deleteDepartement(code);
	}
	

	@RequestMapping(value="/allTypeDeps",method= RequestMethod.GET )
	public List<TypeDep>getAllTypeDeparts(){
		return implserv.getAllTypeDeps();
	}
}
