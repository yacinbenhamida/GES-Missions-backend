package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.Categorie;
import com.rached.model.Zonepays;
import com.rached.services.Services;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
	@Autowired
	@Qualifier("zoneServiceImpl")
	private Services<Zonepays> impl;
	
	@RequestMapping(value="/allZones",method= RequestMethod.GET )
	public List<Zonepays>getAllZones(){
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/findzone/{code}", method = RequestMethod.GET)
	public Zonepays getZone(@PathVariable("code") Long id) {
		return impl.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertZone", method = RequestMethod.POST )
	public Zonepays insertZone(@RequestBody Zonepays elem) {
		//System.out.println(""+elem.toString());
		return impl.insertRecord(elem);
	}
	@RequestMapping(value = "/updateZone", method = RequestMethod.POST)
	public Zonepays updateZone(@RequestBody Zonepays elem) {
		 return impl.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteZone/{code}", method = RequestMethod.GET)
	public void deleteZone(@PathVariable("code") int code) {
		impl.deleteRecord(Long.valueOf(code));
	}
}
