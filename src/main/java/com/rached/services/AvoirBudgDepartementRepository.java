package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.AvoirBudgDep;
import com.rached.model.Departement;

public interface AvoirBudgDepartementRepository extends CrudRepository<AvoirBudgDep, Serializable> {
	@Query("select a FROM AvoirBudgDep a WHERE a.refBudgMission = ?1 AND a.refBudgTransport = ?2")
	AvoirBudgDep getBudgDepByRef(String refbmiss,String refbtransp);
	@Query("select a FROM AvoirBudgDep a,MajBudgDep m where a.departement = ?1 AND a.anneeAttr = ?2 AND m.budget = a AND m.etat='S'")
	AvoirBudgDep getBudgOfDep(Departement dep,int année);
	
	

}
