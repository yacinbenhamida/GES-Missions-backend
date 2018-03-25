package com.rached.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rached.model.AvoirBudgDep;
import com.rached.model.Departement;
import com.rached.model.Fonction;
import com.rached.model.MajBudgDep;
import com.rached.model.TypeDep;
@Service
@Qualifier("departementServiceImpl")
public class DepartementServiceImpl implements DepartementServices{
	@Autowired
	DepartementRepository repository;
	
	@Autowired
	AvoirBudgDepartementRepository budgrepo;
	
	@Autowired
	MajBudgDepartementRepository budgrepoupdate;
	
	@Autowired
	TypeDepRepository typedeprepo;
	
	@Override
	public List<Departement> getAllRecords() {
		List<Departement> res = new ArrayList();
		Iterator<Departement>it = repository.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Departement getRecordById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Departement insertRecord(Departement elem) {
		if(elem!=null) {		
			return repository.save(elem);
		}
		return null;
	}

	@Override
	public void deleteRecord(int id) {
		if(repository.exists(id)) {
			repository.delete(id);
		}
	}

	@Override
	public Departement updateRecord(Departement elem) { 
		 return repository.save(elem);		
	}
	@Override
	public Departement getRecordBycode(String id) {
		return repository.findOne(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repository.delete(valueOf);
		
	}

	@Override
	public void deleteDepartement(String code) {
		repository.delete(code);	
	}

	@Override
	public AvoirBudgDep insertBudgetDep(AvoirBudgDep budget) {
		return budgrepo.save(budget);
	}

	@Override
	public AvoirBudgDep getBudgDep(Long id) {
		return budgrepo.findOne(id);
	}

	@Override
	public MajBudgDep  updateBudgDep( AvoirBudgDep budget) {
		MajBudgDep maj = new MajBudgDep();
		String date = String.valueOf(LocalDate.now());
		maj.setDateMaj(Date.valueOf(LocalDate.now())); //(Integer.valueOf(date.substring(6, 10)));
		maj.setBudget(budget);
		maj.setRefBudgMission(budget.getRefBudgMission());
		maj.setValeurBudgMission(maj.getValeurBudgMission());
		maj.setValeurBudgTransport(budget.getMontantBudgTransport());
		maj.setRefBudgTransport(budget.getRefBudgTransport());
		budgrepo.save(budget);
		return budgrepoupdate.save(maj);	 	
	}

	@Override
	public List<AvoirBudgDep> getAllBudgDeps() {
		List<AvoirBudgDep> res = new ArrayList();
		Iterator<AvoirBudgDep>it = budgrepo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}
		@Override
		public List<MajBudgDep> getAllBudgMaj() {
			List<MajBudgDep> res = new ArrayList();
			Iterator<MajBudgDep>it = budgrepoupdate.findAll().iterator();
			while(it.hasNext()) {
				res.add(it.next());
			}
			return res;
		}

		@Override
		public List<TypeDep> getAllTypeDeps() {
			List<TypeDep> res = new ArrayList();
			Iterator<TypeDep>it = typedeprepo.findAll().iterator();
			while(it.hasNext()) {
				res.add(it.next());
			}
			return res;
		}

		@Override
		public TypeDep getTypeDepByid(long id) {
			
			return typedeprepo.findOne(id);
		}
		@Override
		public List<Departement> getAllDepsOfType(TypeDep type) {
			return repository.getAllDepsOfType(type);
		}
		@Override
		public List<Departement> getAllDepsOfMinistere(Long codeminis) {
			String str ="^"+String.valueOf(codeminis);
			List<Departement>lstdep= new ArrayList<Departement>();
			Iterator<Departement> get = repository.getAllDepsOfMinistere(str).iterator();
			while(get.hasNext()) {
				lstdep.add(get.next());
			}
			return lstdep;
		}
		@Override
		public String getMaxIdDep(String codem,String codetype) {
			String str ="^"+String.valueOf(codem);
			return repository.getMaxIDdepartement(codem,String.valueOf(codetype));
		}
}
