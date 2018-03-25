package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.AvoirBudgDep;
import com.rached.model.AvoirBudgProg;
import com.rached.model.Departement;
import com.rached.model.Projet;

public interface AvoirBudgProjetRepository extends CrudRepository<AvoirBudgProg, Serializable> {
	@Query("select a from AvoirBudgProg a,Projet p where a.projet = p and p.idprojet = ?1")
	AvoirBudgProg getBudgetOfproject(Long idProjet);
	@Query(nativeQuery = true,value = "SELECT * FROM AVOIR_BUDG_PROG WHERE REF_BUDG_PROG = ?1")
	AvoirBudgProg getBudgetByCode(long l);
	@Query("select MAX(u.idbudgProg) from AvoirBudgProg u")
	Long getLatestBudget();
	@Query("select a from AvoirBudgProg a where a.projet = ?1")
	List<AvoirBudgProg> getAllBudgetsOfProg(Projet p);
	
	@Query("select a FROM AvoirBudgProg a WHERE a.refBudgProg = ?1")
	AvoirBudgProg getBudgProgByRef(Long ref);
	
	@Query("select a FROM AvoirBudgProg a,MajBudgProg m where a.projet = ?1 AND m.budgetprojet=a AND m.etat='S'")
	AvoirBudgProg getBudgOfProg(Projet proj);
	
}
