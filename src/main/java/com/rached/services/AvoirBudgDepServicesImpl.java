package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.AvoirBudgDep;
import com.rached.model.AvoirBudgProg;
import com.rached.model.Departement;
import com.rached.model.MajBudgDep;
import com.rached.model.Utilisateur;
@Service
@Qualifier("avoirBudgDepServicesImpl")
public class AvoirBudgDepServicesImpl implements AvoirBudgDepServices {

	@Autowired
	AvoirBudgDepartementRepository repo;
	@Autowired
	MajBudgDepartementRepository repomaj;
	@Override
	public List<AvoirBudgDep> getAllRecords() {
		List<AvoirBudgDep> res = new ArrayList();
		Iterator<AvoirBudgDep>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public AvoirBudgDep getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public AvoirBudgDep insertRecord(AvoirBudgDep elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		repo.delete(repo.findOne(id));

	}

	@Override
	public AvoirBudgDep updateRecord(AvoirBudgDep elem) {
		return repo.save(elem);
	}

	@Override
	public AvoirBudgDep getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repo.delete(repo.findOne(valueOf));

	}

	@Override
	public MajBudgDep insertMajBudgDep(MajBudgDep maj) {
		return repomaj.save(maj);
	}

	@Override
	public List<MajBudgDep> getAllMajsbudgetdep() {
		List<MajBudgDep> res = new ArrayList();
		Iterator<MajBudgDep>it = repomaj.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public AvoirBudgDep getBudgDepByRefs(String refbmiss, String refbtransp) {
		return repo.getBudgDepByRef(refbmiss, refbtransp);
	}
	@Override
	public AvoirBudgDep getBudgOfdep(Departement dep,int annee) {
		return repo.getBudgOfDep(dep,annee);
	}
	@Override
	public AvoirBudgDep getBudgOfdep(Departement departement) {
		return null;
	}
	@Override
	public List<MajBudgDep> getMajsBudgDepOfDepart(String codeDep) {
		return repomaj.getAllMajBudgetsOfdep(codeDep);
	}
	@Override
	public List<MajBudgDep> getMajsDoneByUser(Utilisateur u, Departement d) { 
		return repomaj.getAllMajBudgDonebyUser(u, d);
	}
	
	@Override
	public MajBudgDep getMajDepBudgByID(Long id) {
		return repomaj.getMajById(id);
	}
	@Override
	public MajBudgDep updateMajBudgDep(MajBudgDep maj) {
		return repomaj.save(maj);
	}
	@Override
	public void cancelMajBdep(MajBudgDep maj) {
		maj.setEtat("R");
		repomaj.save(maj);
		
	}

	@Override
	public List<MajBudgDep> getAllMajsOfDepOnBudgdep(Departement d) {
		return repomaj.getAllMajBudgProgOfDepartement(d);
	}
	
	@Override
	public MajBudgDep getMajOfBudgDep(long idbudg) {
		return repomaj.getMajBudgDepByIdBudget(idbudg);
	}

	@Override
	public double getSumBudgObtenusMissions(String codeDep, int year) {
		return repomaj.getTotalBudgetsObtenusMission(codeDep, year);
	}
	@Override
	public double getSumBudgObtenusTransport(String codeDep, int year) {
		return repomaj.getTotalBudgetsObtenusTransport(codeDep, year);
	}
}
