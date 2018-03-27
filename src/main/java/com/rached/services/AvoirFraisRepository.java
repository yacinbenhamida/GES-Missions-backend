package com.rached.services;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.AvoirFrai;
import com.rached.model.TypeFrai;

public interface AvoirFraisRepository extends CrudRepository<AvoirFrai, Serializable> {
	@Query("select a from AvoirFrai a where a.codeProg = ?1 AND "
			+ "a.codeSupport = ?2 AND a.observation = ?3 AND a.support = ?4 AND"
			+ " a.valeurPrevue = ?5 AND a.valeurReel = ?6 AND a.typeFrai = ?7")
	AvoirFrai getAvoirFraiInseree(long codeprog,long codesupp,String observation,
			String support,long valprev,long valReel,TypeFrai tf);
}
