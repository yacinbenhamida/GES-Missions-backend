package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rached.model.Grade;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
	@Autowired
	@Qualifier("gradeServiceImpl")
	private Services<Grade> implgrade;
	
	@RequestMapping(value="/allGrades",method= RequestMethod.GET )
	public List<Grade>getAllFoncts(){
		return implgrade.getAllRecords();
	}
	@RequestMapping(value = "/findGrade/{code}", method = RequestMethod.GET)
	public Grade getFonct(@PathVariable("code") Long id) {
		return implgrade.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertGrade", method = RequestMethod.POST )
	public Grade insertFonct(@RequestBody Grade elem) {
		//System.out.println(""+elem.toString());
		return implgrade.insertRecord(elem);
	}
	@RequestMapping(value = "/updateGrade", method = RequestMethod.POST)
	public Grade updateDepart(@RequestBody Grade elem) {
		 return implgrade.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteGrade/{code}", method = RequestMethod.GET)
	public void deleteDepart(@PathVariable("code") int code) {
		implgrade.deleteRecord(Long.valueOf(code));
	}
}
