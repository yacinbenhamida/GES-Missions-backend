package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.AvoirBudgDep;
import com.rached.model.Departement;
import com.rached.model.MajBudgDep;
import com.rached.model.MajBudgProg;
import com.rached.model.Projet;
import com.rached.model.Utilisateur;

public interface MajBudgDepartementRepository extends CrudRepository<MajBudgDep, Serializable> {
	@Query("select m from MajBudgDep m,AvoirBudgDep a where a.departement.codeDep = ?1 AND m.etat='O' AND m.budget = a")
	List<MajBudgDep> getAllMajBudgetsOfdep(String codeDep);
	
	@Query("select m from MajBudgDep m,AvoirBudgDep a,UserStruct u,Departement d "
			+ "where a.departement=?2  AND u.utilisateur = ?1 AND u.departement = d AND a.departement = d")
	List<MajBudgDep> getAllMajBudgDonebyUser(Utilisateur user,Departement dep);
	
	@Query("select m from MajBudgDep m where m.idMajBdugDep = ?1")
	MajBudgDep getMajById(Long id);
	
	@Query("select m from MajBudgDep m,AvoirBudgDep a where  m.budget = a AND a.departement = ?1 ")
	List<MajBudgDep> getAllMajBudgProgOfDepartement(Departement dep);
	
	@Query("select m from MajBudgDep m where m.budget.idBudgDep = ?1")
	MajBudgDep getMajBudgDepByIdBudget(long codeBudj);
}
