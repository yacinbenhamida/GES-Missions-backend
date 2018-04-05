package com.rached.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rached.model.AvoirFrai;
import com.rached.model.Concerne;
import com.rached.services.AvoirFraisServiceImpl;
import com.rached.services.OrdreConcernePayServiceImpl;
import com.rached.services.OrdreMissionServiceImpl;
import com.rached.services.TypeFraisServicesImpl;

@RestController
@RequestMapping("/api/avoirfrais")
public class AvoirFraisController {
	@Autowired
	@Qualifier("avoirFraisServiceImpl")
	private AvoirFraisServiceImpl frais;
	
	@Autowired
	@Qualifier("typeFraisServicesImpl")
	private TypeFraisServicesImpl typefrais;
	
	
	@Autowired
	@Qualifier("ordreMissionServiceImpl")
	private OrdreMissionServiceImpl ordremiss;
	
	@Autowired
	@Qualifier("ordreConcernePayServiceImpl")
	private OrdreConcernePayServiceImpl concerne;
	
	
	
	@RequestMapping(value="/allFraisoford/{idordre}",method= RequestMethod.GET )
	public List<AvoirFrai>getAllFraisOfORDRE(@PathVariable("idordre")long idOrdre){
		return frais.getAvFraisOfORD(idOrdre);
	}
	@RequestMapping(value="/allFraisDiversoford/{idordre}",method= RequestMethod.GET )
	public List<AvoirFrai>getAllFraisDiversOfORDRE(@PathVariable("idordre")long idOrdre){
		return frais.getAllFraisDiversOfOrdre(idOrdre);
	}
	
	@RequestMapping(value="/allFraisMissionofConcerne/{idconcerne}",method= RequestMethod.GET )
	public AvoirFrai getAllFraisMissOfCONCERNE(@PathVariable("idconcerne")long idc){
		Concerne c = concerne.getRecordById(idc);
		return frais.getFraisMissionOfConcerne(c);
	}
	@RequestMapping(value="/allFrais",method= RequestMethod.GET )
	public List<AvoirFrai>getAllFrais(){
		return frais.getAllRecords();
	}
	@RequestMapping(value = "/findFrais/{code}", method = RequestMethod.GET)
	public AvoirFrai getAvoirFrai(@PathVariable("code") Long id) {
		return frais.getRecordById(Long.valueOf(id));
	}
	@RequestMapping(value = "/insertAvoirFrai", method = RequestMethod.POST )
	public AvoirFrai insertAvoirFrai(@RequestBody AvoirFrai elem) {
		
		elem.setOrdreMission(ordremiss.getRecordById(elem.getOrdreMission().getIdOrdre()));
		elem.setTypeFrai(typefrais.getRecordBycode(elem.getTypeFrai().getCodeTypefr()));
		return frais.insertRecord(elem);
	}
	@RequestMapping(value = "/updateAvoirFrai", method = RequestMethod.POST)
	public AvoirFrai updateClasse(@RequestBody AvoirFrai elem) {
		elem.setTypeFrai(typefrais.getRecordBycode(elem.getTypeFrai().getCodeTypefr()));
		 return frais.updateRecord(elem);
	}
	@RequestMapping(value = "/deleteAvoirFrai/{code}", method = RequestMethod.GET)
	public void deleteClasse(@PathVariable("code") Long code) {
		frais.deleteRecord(Long.valueOf(code));
	}
}
