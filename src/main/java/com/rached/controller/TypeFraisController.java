package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.TypeFrai;
import com.rached.services.TypeFraisServicesImpl;

@RestController
@RequestMapping("/api/typefrais")

public class TypeFraisController {
	@Autowired
	@Qualifier("typeFraisServicesImpl")
	TypeFraisServicesImpl impl;
	@RequestMapping(value="/allTypes",method= RequestMethod.GET )
	public List<TypeFrai>getAllTypes(){
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/findType/{code}", method = RequestMethod.GET)
	public TypeFrai getType(@PathVariable("code") String id) {
		return impl.getRecordBycode(id);
	}
	@RequestMapping(value = "/insertType", method = RequestMethod.POST )
	public TypeFrai insertTypeFrais(@RequestBody TypeFrai elem) {
		return impl.insertRecord(elem);
	}
	@RequestMapping(value = "/updateType", method = RequestMethod.POST)
	public TypeFrai updateTF(@RequestBody TypeFrai elem) {
		 return impl.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteType/{code}", method = RequestMethod.GET)
	public void deleteTF(@PathVariable("code") int code) {
		impl.deleteRecord(Long.valueOf(code));
	}
}
