package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.AvoirBudgProg;
import com.rached.model.Departement;
import com.rached.model.MajBudgProg;
import com.rached.model.Projet;
import com.rached.model.Utilisateur;
@Service
@Qualifier("avoirBudgProgServicesImpl")
public class AvoirBudgProgServicesImpl implements AvoirBudgProgServices {

	@Autowired
	AvoirBudgProjetRepository repo;
	@Autowired
	MajBudgProgRepository repomaj;
	@Override
	public List<AvoirBudgProg> getAllRecords() {
		List<AvoirBudgProg> res = new ArrayList<AvoirBudgProg>();
		Iterator<AvoirBudgProg>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public AvoirBudgProg getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public AvoirBudgProg insertRecord(AvoirBudgProg elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		repo.delete(repo.findOne(id));

	}

	@Override
	public AvoirBudgProg updateRecord(AvoirBudgProg elem) {
		return repo.save(elem);
	}

	@Override
	public AvoirBudgProg getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repo.delete(repo.findOne(valueOf));

	}

	@Override
	public MajBudgProg insertMajBudgProg(MajBudgProg maj) {
		return repomaj.save(maj);
	}

	@Override
	public List<MajBudgProg> getAllMajsbudgetprojet() {
		List<MajBudgProg> res = new ArrayList<MajBudgProg>();
		Iterator<MajBudgProg>it = repomaj.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}
	@Override
	public AvoirBudgProg getBudgProgByRef(Long ref) {
		return repo.getBudgProgByRef(ref);
	}
	
	@Override
	public AvoirBudgProg getBudgetOfProj(Projet proj) {
		return repo.getBudgOfProg(proj);
	}
	// all maj budg prog under ministry........
	@Override
	public List<MajBudgProg> getAllMajsbudgetprojetOfDep(String codeDep) {
	 String c = '^'+codeDep;
	  return repomaj.getAllupdatesOnBudgetOfProjetOfDep(c);
	}

	@Override
	public List<MajBudgProg> getMajsDoneByUser(Utilisateur u, Departement d) {
		return repomaj.getAllMajBudgProgDonebyUser(u, d);
	}

	@Override
	public MajBudgProg getMajDepBudgByID(Long id) {
		return repomaj.findOne(id);
	}

	@Override
	public MajBudgProg updateMajBudgProg(MajBudgProg maj) {
		return repomaj.save(maj);
	}

	@Override
	public void cancelMajBprog(MajBudgProg maj) {
		maj.setEtat("R");
		repomaj.save(maj);
		
	}

	@Override
	public List<MajBudgProg> getAllMajsOnProjet(Departement dep, Projet p) {
		return repomaj.getAllMajBudgProgOfProg(dep, p);
	}

	@Override
	public MajBudgProg getBprojByIdbudg(long idbudg) {
		return repomaj.getMajBudgProgByIdBudget(idbudg);
	}

	@Override
	public void deleteMajBudgprj(long idMaj) {
		repomaj.delete(idMaj);
		
	}

	@Override
	public List<AvoirBudgProg> getAllBudgetsProgOfDep(String codeDep, int year) {
		return repo.getAllBudgetsProgOfDep(codeDep, year);
	}
}
