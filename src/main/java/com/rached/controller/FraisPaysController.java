package com.rached.controller;
/*
 * 
 * joint table avoir frais , pays CRUD services
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.AvoirFrai;
import com.rached.model.Pays;
import com.rached.model.PaysFrai;
import com.rached.model.TypeFrai;
import com.rached.services.AvoirFraisServiceImpl;
import com.rached.services.OrdreConcernePayServiceImpl;
import com.rached.services.PaysFraiServiceImpl;
import com.rached.services.Services;
import com.rached.services.TypeFraisServicesImpl;

@RestController
@RequestMapping("/api/fraisordremission")
public class FraisPaysController {
	@Autowired
	@Qualifier("paysFraiServiceImpl")
	private PaysFraiServiceImpl implfrais;
	
	@Autowired
	@Qualifier("paysServicesImpl")
	private Services<Pays> implpays;
	
	@Autowired
	@Qualifier("typeFraisServicesImpl")
	TypeFraisServicesImpl impltypefrais;
	
	@Autowired
	@Qualifier("avoirFraisServiceImpl")
	AvoirFraisServiceImpl avoirFrais;
	
	@RequestMapping(value="/allFraispays",method= RequestMethod.GET )
	public List<PaysFrai>getAllPFrais(){
		return implfrais.getAllRecords();
	}
	@RequestMapping(value = "/findFraispays/{code}", method = RequestMethod.GET)
	public PaysFrai getPF(@PathVariable("code") Long id) {
		return implfrais.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertPaysFrais", method = RequestMethod.POST )
	public PaysFrai insertPFrais(@RequestBody PaysFrai elem) {
		elem.setPays(implpays.getRecordById(elem.getPays().getIdpays()));
		elem.setAvoirfrais(avoirFrais.getRecordById(elem.getAvoirfrais().getIdAvoirfrais()));
		return implfrais.insertRecord(elem);
	}
	@RequestMapping(value = "/updatePaysFrais", method = RequestMethod.POST)
	public PaysFrai updatePF(@RequestBody PaysFrai elem) {
		elem.setPays(implpays.getRecordById(elem.getPays().getIdpays()));
		elem.setAvoirfrais(avoirFrais.getRecordById(elem.getAvoirfrais().getIdAvoirfrais()));
		 return implfrais.updateRecord(elem);
	}
	@RequestMapping(value = "/deletePaysFrais/{code}", method = RequestMethod.GET)
	public void deletePF(@PathVariable("code") int code) {
		implfrais.deleteRecord(Long.valueOf(code));
	}
}
