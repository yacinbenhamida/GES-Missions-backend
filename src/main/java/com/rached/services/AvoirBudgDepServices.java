package com.rached.services;

import java.util.List;

import com.rached.model.AvoirBudgDep;
import com.rached.model.Departement;
import com.rached.model.MajBudgDep;
import com.rached.model.Utilisateur;

public interface AvoirBudgDepServices extends Services<AvoirBudgDep> {
	MajBudgDep insertMajBudgDep(MajBudgDep maj);
	List<MajBudgDep> getAllMajsbudgetdep();
	AvoirBudgDep getBudgDepByRefs(String refbmiss,String refbtransp);
	AvoirBudgDep getBudgOfdep(Departement dep,int annee);
	AvoirBudgDep getBudgOfdep(Departement departement);
	List<MajBudgDep> getMajsBudgDepOfDepart(String codeDep);
	List<MajBudgDep> getMajsDoneByUser(Utilisateur u,Departement d);
	MajBudgDep getMajDepBudgByID(Long id);
	MajBudgDep updateMajBudgDep(MajBudgDep maj);
	void cancelMajBdep(MajBudgDep maj);
	List<MajBudgDep> getAllMajsOfDepOnBudgdep(Departement d);
	MajBudgDep getMajOfBudgDep(long idbudg);
	// somme des budgets de mission
	double getSumBudgObtenusMissions(String codeDep,int year);
	// somme des budgets de transport
	double getSumBudgObtenusTransport(String codeDep,int year);
	// les années administratives
	List<Integer> getYears(String codeDep);
}
