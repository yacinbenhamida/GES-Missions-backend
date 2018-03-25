package com.rached.services;

import java.util.List;

import com.rached.model.AvoirBudgDep;
import com.rached.model.Departement;
import com.rached.model.MajBudgDep;
import com.rached.model.TypeDep;

public interface DepartementServices extends Services<Departement>{
	void deleteDepartement(String code);
	AvoirBudgDep insertBudgetDep(AvoirBudgDep budget);
	AvoirBudgDep getBudgDep(Long id);
	MajBudgDep updateBudgDep(AvoirBudgDep budget);
	List<AvoirBudgDep> getAllBudgDeps();
	List<MajBudgDep> getAllBudgMaj();
	List<TypeDep> getAllTypeDeps();
	TypeDep getTypeDepByid(long id);
	List<Departement> getAllDepsOfType(TypeDep type);
	List<Departement> getAllDepsOfMinistere(Long codeminis);
	String getMaxIdDep(String codem,String codetyped);
	
}
