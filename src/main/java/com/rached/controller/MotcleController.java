package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Motcle;
import com.rached.model.Theme;
import com.rached.services.MotCleService;
import com.rached.services.Services;
@RestController
@RequestMapping("/api/motcles")

public class MotcleController {
	@Autowired
	@Qualifier("motclesServiceImpl")
	private MotCleService impl;
	@Autowired
	@Qualifier("themeServiceImpl")
	private Services<Theme> impltheme;
	
	@RequestMapping(value="/allMotclesOfTheme/{idtheme}",method= RequestMethod.GET )
	public List<Motcle>getAllMotclesOfTheme(@PathVariable("idtheme") long code){
		return impl.getMcsOfTheme(code);
	}
	@RequestMapping(value="/allMotcles",method= RequestMethod.GET )
	public List<Motcle>getAllMotcles(){
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/findMotcle/{code}", method = RequestMethod.GET)
	public Motcle getMotcle(@PathVariable("code") Long id) {
		return impl.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertMotcle", method = RequestMethod.POST )
	public Motcle insertMotcle(@RequestBody Motcle elem) {
		System.out.println(""+elem.toString());
		/*Theme th = impltheme.getRecordById(toIntExact(elem.getTheme().getIdtheme()));
		elem.setTheme(th);*/
		return impl.insertRecord(elem);
	}
	@RequestMapping(value = "/updateMotCle", method = RequestMethod.POST)
	public Motcle updateMotcle(@RequestBody Motcle elem) {
		 return impl.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteMotcle/{code}", method = RequestMethod.GET)
	public void deleteMotcle(@PathVariable("code") int code) {
		impl.deleteRecord(Long.valueOf(code));
	}
}
