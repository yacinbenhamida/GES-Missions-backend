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

import com.rached.model.AvoirBudgDep;
import com.rached.model.AvoirBudgProg;
import com.rached.model.Departement;
import com.rached.model.MajBudgDep;
import com.rached.model.MajBudgProg;
import com.rached.model.Projet;
import com.rached.model.Utilisateur;
import com.rached.services.AvoirBudgDepServices;
import com.rached.services.AvoirBudgProgServices;
import com.rached.services.DepartementServices;
import com.rached.services.ProjetServices;
import com.rached.services.UtilisateurServices;

@RestController
@RequestMapping("/api/budgets")

public class BudgetController {
	@Autowired
	@Qualifier("utilisateurServiceImpl")
	private UtilisateurServices userimpl;
	
	@Autowired
	@Qualifier("avoirBudgProgServicesImpl")
	AvoirBudgProgServices impl;
	
	@Autowired
	@Qualifier("avoirBudgDepServicesImpl")
	AvoirBudgDepServices impldep;
	
	@Autowired
	@Qualifier("projetServicesImpl")
	private ProjetServices implprj;
	
	@Autowired
	@Qualifier("departementServiceImpl")
	private DepartementServices depserv;
	@RequestMapping(value = "/insertBudgetProjet", method = RequestMethod.POST )
	public MajBudgProg insertBudgetProjet(@RequestBody AvoirBudgProg elem) {
		MajBudgProg maj = new MajBudgProg();
		Projet p = implprj.getRecordById(elem.getProjet().getIdprojet());
		elem.setProjet(p);
		elem.setTotalBudget(elem.getMontantBudg());
		maj.setBudgetprojet(elem);
		maj.setDateMajBudgProg(elem.getDateBudg());
		maj.setRefBudget(elem.getRefBudgProg());
		maj.setValeurMajBudgProg(elem.getMontantBudg());
		maj.setEtat("N");
		 impl.insertRecord(elem);
		 AvoirBudgProg b = impl.getBudgProgByRef(elem.getRefBudgProg());
		 maj.setBudgetprojet(b);
		return  impl.insertMajBudgProg(maj);
	}
	@RequestMapping(value = "/insertBudgetDep", method = RequestMethod.POST )
	public MajBudgDep insertBudgetDep(@RequestBody AvoirBudgDep elem) {
		Departement d = depserv.getRecordBycode(elem.getDepartement().getCodeDep());		
		MajBudgDep maj = new MajBudgDep();
		AvoirBudgDep b = new AvoirBudgDep();		
		maj.setDateMaj(elem.getDateBudg());
		maj.setRefBudgMission(elem.getRefBudgMission());
		maj.setRefBudgTransport(elem.getRefBudgTransport());
		maj.setValeurBudgMission(elem.getMontantBudgMission());
		maj.setValeurBudgTransport(elem.getMontantBudgTransport());
		maj.setEtat("N");
	     elem.setTotalMission(elem.getMontantBudgMission());
	     elem.setTotalTransport(elem.getTotalTransport());
		 impldep.insertRecord(elem);
		b = impldep.getBudgDepByRefs(elem.getRefBudgMission(), elem.getRefBudgTransport());
		b.setDepartement(d);
		maj.setBudget(b);
		return  impldep.insertMajBudgDep(maj);
	}
	
		// to verify if dep have a first budget introduction
		// for inserbudg dep
		@RequestMapping(value="/allMajsBudgProgOfdep/{codeDep}",method = RequestMethod.GET)
		public List<MajBudgDep> getAllBudgDepMajBudgDepOfDep(@PathVariable("codeDep")String codeDep){
			Departement dep = depserv.getRecordBycode(codeDep);
			return impldep.getAllMajsOfDepOnBudgdep(dep);
		}
		
		//update MAj record after initial insert
		@RequestMapping(value="/updateInitialBudgDep",method = RequestMethod.POST)
		public void updateInitialBudgDep(@RequestBody AvoirBudgDep newbudg){
			System.out.println("transmitted "+newbudg);
			newbudg.setTotalMission(newbudg.getMontantBudgMission());
			newbudg.setTotalTransport(newbudg.getMontantBudgTransport());
			impldep.updateRecord(newbudg);
			
			MajBudgDep maj = new MajBudgDep();
			maj.setIdMajBdugDep(impldep.getMajOfBudgDep(newbudg.getIdBudgDep()).getIdMajBdugDep());
			maj.setBudget(newbudg);
			maj.setDateMaj(newbudg.getDateBudg());
			maj.setEtat("N");
			maj.setRefBudgMission(newbudg.getRefBudgMission());
			maj.setRefBudgTransport(newbudg.getRefBudgTransport());
			maj.setValeurBudgMission(newbudg.getMontantBudgMission());
			maj.setValeurBudgTransport(newbudg.getMontantBudgTransport());
			impldep.updateMajBudgDep(maj);
		}
	
	@RequestMapping(value = "/getBudgetProjet/{code}", method = RequestMethod.GET )
	public AvoirBudgProg getBudgetProjet(@PathVariable("code") Long code) {
		return impl.getRecordById(code);
	}
	// get budget of input project id
	@RequestMapping(value = "/getBudgetOfprojet/{codeproj}", method = RequestMethod.GET )
	public AvoirBudgProg getBudgetOfProjet(@PathVariable("codeproj") Long code) {
		return impl.getBudgetOfProj(implprj.getRecordById(code));
	}	
	
	
	@RequestMapping(value = "/getBudgetDep/{code}/{year}", method = RequestMethod.GET )
	public AvoirBudgDep getBudgetDep(@PathVariable("code") String code,@PathVariable("year") int annee) {
		Departement d = depserv.getRecordBycode(code);
		return impldep.getBudgOfdep(d,annee);
	}
	@RequestMapping(value = "/allDepBudgets", method = RequestMethod.GET )
	public List<AvoirBudgDep> allBudgetsOfdep() {
		return impldep.getAllRecords();
	}
	@RequestMapping(value = "/allProjBudgets", method = RequestMethod.GET )
	public List<AvoirBudgProg> allBudgets() {
		return impl.getAllRecords();
	}
	@RequestMapping(value = "/deleteBudgprojet/{code}", method = RequestMethod.GET)
	public void deleteBudgetPrj(@PathVariable("code") Long id) {
		impl.deleteRecord(id);
	}
	@RequestMapping(value = "/deleteBudgdep/{code}", method = RequestMethod.GET)
	public void deleteBudgetDep(@PathVariable("code") Long id) {
		impldep.deleteRecord(id);
	}
	
	@RequestMapping(value = "/updateBudgetProj", method = RequestMethod.POST )
	public MajBudgProg updateBudgetProj(@RequestBody AvoirBudgProg elem) {
		AvoirBudgProg bnew = impl.getBudgetOfProj(elem.getProjet());
		bnew.setMontantBudg(bnew.getMontantBudg() + elem.getMontantBudg());
		impl.updateRecord(bnew);
		MajBudgProg maj = new MajBudgProg();
		maj.setBudgetprojet(bnew);
		maj.setDateMajBudgProg(Date.valueOf(LocalDate.now()));
		maj.setRefBudget(elem.getRefBudgProg());
		maj.setValeurMajBudgProg(elem.getMontantBudg());
		maj.setEtat("N");
		return impl.insertMajBudgProg(maj);
	}
	@RequestMapping(value="/allMajsBudgProgOfUser/{codedep}/{idUser}",method = RequestMethod.GET)
	public List<MajBudgProg> getAllBudgDepMajBudgProgOfUser(@PathVariable("codedep")String codeDep,@PathVariable("idUser")Long codeUs){
		Utilisateur u = userimpl.getRecordById(Long.valueOf(codeUs));
		Departement d = depserv.getRecordBycode(codeDep);
		return impl.getMajsDoneByUser(u, d);
	}
	// to verify if project have a first budget introduction
	// for inserbudg projet
	@RequestMapping(value="/allMajsBudgProgOfprojet/{codeDep}/{codeproj}",method = RequestMethod.GET)
	public List<MajBudgProg> getAllBudgDepMajBudgProgOfDep(@PathVariable("codeDep")String codeDep,@PathVariable("codeproj")Long codeproj){
		Departement dep = depserv.getRecordBycode(codeDep);
		Projet p = implprj.getRecordById(codeproj);
		return impl.getAllMajsOnProjet(dep, p);
	}
	// if ordonnateur wants to edit his current budget demand
	@RequestMapping(value="/updateInitialBudgProg",method = RequestMethod.POST)
	public void updateInitialBudgProg(@RequestBody AvoirBudgProg newbudg){
		System.out.println("transmitted "+newbudg);
		AvoirBudgProg  projinit = impl.getRecordById(newbudg.getIdbudgProg());
		MajBudgProg majinit = impl.getBprojByIdbudg(newbudg.getIdbudgProg());
		System.out.println("codemaj"+majinit.getIdmajBudgPrg());
		//updating...
		majinit.setValeurMajBudgProg(newbudg.getMontantBudg());
		majinit.setRefBudget(newbudg.getRefBudgProg());
		majinit.setDateMajBudgProg(Date.valueOf(LocalDate.now()));
		majinit.setEtat("N");
		
		projinit.setDateBudg(Date.valueOf(LocalDate.now()));
		projinit.setMontantBudg(newbudg.getMontantBudg());
		projinit.setRefBudgProg(newbudg.getRefBudgProg());
		projinit.setTotalBudget(newbudg.getMontantBudg());	
		majinit.setBudgetprojet(projinit);
		 majinit.setIdmajBudgPrg(majinit.getIdmajBudgPrg());
		 impl.updateRecord(projinit);
		 
	}
	
	@RequestMapping(value="/deleteMajBudgProgOfUser/{idmaj}",method = RequestMethod.GET)
	public void rmBudgProgMajBudgProgOfUS(@PathVariable("idmaj")Long idmaj){
		MajBudgProg maj = impl.getMajDepBudgByID(idmaj);
		 impl.cancelMajBprog(maj);
	}
	
	@RequestMapping(value="/saveMajBudgPROG/{idmaj}",method = RequestMethod.GET)
	public void saveChangementBudgProg(@PathVariable("idmaj")Long idmaj){
		MajBudgProg maj = impl.getMajDepBudgByID(idmaj);
		 maj.setEtat("O");
		 impl.updateMajBudgProg(maj);
	}
	
	//accept maj bug projet par OM
	@RequestMapping(value="/acceptMajBudgPROGM/{idmaj}",method=RequestMethod.GET)
	public void acceptChangementBudgProgByMinistere(@PathVariable("idmaj")Long idmaj) {
		 MajBudgProg maj = impl.getMajDepBudgByID(idmaj);
		 maj.setEtat("S");
		 impl.updateMajBudgProg(maj);
		 
		 AvoirBudgProg budget = maj.getBudgetprojet();
		 budget.setMontantBudg(budget.getMontantBudg() + maj.getValeurMajBudgProg());
		 impl.updateRecord(budget);
	}
	
	//refuse maj bug projet par OM
	@RequestMapping(value="/declineMajBudgPROGM/{idmaj}",method=RequestMethod.GET)
	public void declineChangementBudgProgByMinistere(@PathVariable("idmaj")Long idmaj) {
		 MajBudgProg maj = impl.getMajDepBudgByID(idmaj);
		 impl.cancelMajBprog(maj);
		
	}
	
	//accept maj dep par OM
		@RequestMapping(value="/acceptMajDEPM/{idmaj}",method=RequestMethod.GET)
		public void acceptChangementBudgDepByMinistere(@PathVariable("idmaj")Long idmaj) {
			 MajBudgDep maj = impldep.getMajDepBudgByID(idmaj);
			 maj.setEtat("S");
			 impldep.updateMajBudgDep(maj);
			 
			 AvoirBudgDep budget = maj.getBudget();
			 budget.setMontantBudgMission(budget.getMontantBudgMission() + maj.getValeurBudgMission());
			 budget.setMontantBudgTransport(budget.getMontantBudgTransport() + maj.getValeurBudgTransport());
			 impldep.updateRecord(budget);
		}
		
		//refuse maj dep par OM
		@RequestMapping(value="/declineMajBudgDEPM/{idmaj}",method=RequestMethod.GET)
		public void declineChangementBudgDEPByMinistere(@PathVariable("idmaj")Long idmaj) {
			 MajBudgDep maj = impldep.getMajDepBudgByID(idmaj);
			 impldep.cancelMajBdep(maj);
			
		}
		
		// all Maj Budg prog confirmed by OM => sent to controller 
		@RequestMapping(value="/allMajBudgProgController",method=RequestMethod.GET)
		public void getAllChangementBudgPROGConfirmed(@PathVariable("idmaj")Long idmaj) {
			 MajBudgDep maj = impldep.getMajDepBudgByID(idmaj);
			 impldep.cancelMajBdep(maj);
			
		}
	
	@RequestMapping(value = "/updateBudgetDep", method = RequestMethod.POST )
	public MajBudgDep updateBudgetDep(@RequestBody AvoirBudgDep elem) {
		System.out.println(elem+"");
		AvoirBudgDep bnew = impldep.getBudgOfdep(elem.getDepartement(),elem.getAnneeAttr());
		bnew.setMontantBudgMission(bnew.getMontantBudgMission() + elem.getMontantBudgMission());
		bnew.setMontantBudgTransport(bnew.getMontantBudgTransport() + elem.getMontantBudgTransport());
		impldep.updateRecord(bnew);
		MajBudgDep maj = new MajBudgDep();
		maj.setBudget(bnew);
		maj.setDateMaj(Date.valueOf(LocalDate.now()));
		maj.setRefBudgMission(elem.getRefBudgMission());
		maj.setRefBudgTransport(elem.getRefBudgTransport());
		maj.setValeurBudgMission(elem.getMontantBudgMission());
		maj.setValeurBudgTransport(elem.getMontantBudgTransport());
		maj.setEtat("N");
		System.out.println(maj+"");
		return impldep.insertMajBudgDep(maj);
	}
	@RequestMapping(value = "/allMajDepBudgets", method = RequestMethod.GET )
	public List<MajBudgDep> getAllBudgDepMaj() {
		return impldep.getAllMajsbudgetdep();
	}
	// toutes les màaj des projets
	@RequestMapping(value = "/allMajProgBudgetsOfMinistere/{codeminis}", method = RequestMethod.GET )
	public List<MajBudgProg> getAllBudgProgMajOfDep(@PathVariable("codeminis") String codeDep) {
		return impl.getAllMajsbudgetprojetOfDep(codeDep);
	}
	
	@RequestMapping(value="/allMajsBudgDep/{codedep}",method = RequestMethod.GET)
	public List<MajBudgDep> getAllBudgDepMajOfDep(@PathVariable("codedep")String codeDep){
		return impldep.getMajsBudgDepOfDepart(codeDep);
	}
	
	@RequestMapping(value="/allMajsBudgDepOfUser/{codedep}/{idUser}",method = RequestMethod.GET)
	public List<MajBudgDep> getAllBudgDepMajBudgDepOfUser(@PathVariable("codedep")String codeDep,@PathVariable("idUser")Long codeUs){
		Utilisateur u = userimpl.getRecordById(Long.valueOf(codeUs));
		Departement d = depserv.getRecordBycode(codeDep);
		return impldep.getMajsDoneByUser(u, d);
	}
	
	@RequestMapping(value="/deleteMajBudgDepOfUser/{idmaj}",method = RequestMethod.GET)
	public void rmBudgDepMajBudgDepOfUS(@PathVariable("idmaj")Long idmaj){
		MajBudgDep maj = impldep.getMajDepBudgByID(idmaj);
		 impldep.cancelMajBdep(maj);
	}
	
	@RequestMapping(value="/saveMajBudgDEP/{idmaj}",method = RequestMethod.GET)
	public void saveChangementBudgDp(@PathVariable("idmaj")Long idmaj){
		 MajBudgDep maj = impldep.getMajDepBudgByID(idmaj);
		 maj.setEtat("O");
		 impldep.updateMajBudgDep(maj);
	}

	@RequestMapping(value="/getSommeBudgetsMission/{codeDep}/{year}",method = RequestMethod.GET)
	public double sommebudgMission(@PathVariable("codeDep")String codeDep,@PathVariable("year")int year){
		 return impldep.getSumBudgObtenusMissions(codeDep, year);
	}
	@RequestMapping(value="/getSommeBudgetsTransport/{codeDep}/{year}",method = RequestMethod.GET)
	public double sommebudgTransport(@PathVariable("codeDep")String codeDep,@PathVariable("year")int year){
		 return impldep.getSumBudgObtenusTransport(codeDep, year);
	}
}
