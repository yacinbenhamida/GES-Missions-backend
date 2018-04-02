package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.AvoirFrai;
import com.rached.model.Concerne;
import com.rached.model.TypeFrai;

public interface AvoirFraisRepository extends CrudRepository<AvoirFrai, Serializable> {
	
	@Query("select a from AvoirFrai a where a.ordreMission.idOrdre = ?1")
	List<AvoirFrai> getAllFraisOfOrdre(long idordre);
	
	@Query("select a from AvoirFrai a where a.ordreMission.idOrdre = ?1 AND a.typeFrai.codeTypefr != '0808'")
	List<AvoirFrai> getAllFraisDiversOfOrdre(long idordre);
	
	@Query("select a from AvoirFrai a,OrdreMission o,Concerne c where c = ?1 AND o=c.ordre"
			+ " AND a.ordreMission = o AND a.typeFrai.codeTypefr='0808'")
	AvoirFrai getFraisMissionOfConcerne(Concerne c);
}
