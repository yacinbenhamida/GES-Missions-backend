package com.rached.services;

import java.util.List;

import com.rached.model.AvoirBudgProg;
import com.rached.model.Departement;
import com.rached.model.MajBudgProg;
import com.rached.model.Projet;
import com.rached.model.Utilisateur;

public interface AvoirBudgProgServices extends Services<AvoirBudgProg> {
	MajBudgProg insertMajBudgProg(MajBudgProg maj);
	List<MajBudgProg> getAllMajsbudgetprojet();
	AvoirBudgProg getBudgProgByRef(Long ref);
	AvoirBudgProg getBudgetOfProj(Projet proj);
	List<MajBudgProg> getAllMajsbudgetprojetOfDep(String codeDep);
	List<MajBudgProg> getMajsDoneByUser(Utilisateur u,Departement d);
	List<MajBudgProg> getAllMajsOnProjet(Departement dep,Projet p);
	MajBudgProg getBprojByIdbudg(long idbudg);
	void deleteMajBudgprj(long idMaj);
	
	MajBudgProg getMajDepBudgByID(Long id);
	MajBudgProg updateMajBudgProg(MajBudgProg maj);
	void cancelMajBprog(MajBudgProg maj);
	List<AvoirBudgProg> getAllBudgetsProgOfDep(String codeDep, int year);
	
}
