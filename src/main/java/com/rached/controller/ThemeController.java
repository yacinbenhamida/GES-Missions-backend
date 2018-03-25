package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Theme;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {
	@Autowired
	@Qualifier("themeServiceImpl")
	private Services<Theme> impl;
	
	@RequestMapping(value="/allThemes",method= RequestMethod.GET )
	public List<Theme>getAllThemes(){
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/findtheme/{code}", method = RequestMethod.GET)
	public Theme getTheme(@PathVariable("code") Long id) {
		return impl.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertTheme", method = RequestMethod.POST )
	public Theme insertTheme(@RequestBody Theme elem) {
		//System.out.println(""+elem.toString());
		return impl.insertRecord(elem);
	}
	@RequestMapping(value = "/updateTheme", method = RequestMethod.POST)
	public Theme updateTheme(@RequestBody Theme elem) {
		 return impl.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteTheme/{code}", method = RequestMethod.GET)
	public void deleteTheme(@PathVariable("code") int code) {
		impl.deleteRecord(Long.valueOf(code));
	}
}
