package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rached.model.AvoirFrai;
import com.rached.model.Concerne;


public interface AvoirFraisRepository extends CrudRepository<AvoirFrai, Serializable> {
	
	@Query("select a from AvoirFrai a where a.ordreMission.idOrdre = ?1")
	List<AvoirFrai> getAllFraisOfOrdre(long idordre);
	
	@Query("select a from AvoirFrai a where a.ordreMission.idOrdre = ?1 AND a.typeFrai.codeTypefr != '0808'")
	List<AvoirFrai> getAllFraisDiversOfOrdre(long idordre);
	
	@Query("select a from AvoirFrai a,OrdreMission o,Concerne c,Pays p where c = :conc AND c.idconcerne = :idc AND o=c.ordre"
			+ " AND a.ordreMission = o AND a.ordreMission = c.ordre AND a.typeFrai.codeTypefr='0808' AND c.pays = p")
	AvoirFrai getFraisMissionOfConcerne(@Param("conc")Concerne c,@Param("idc")long idc);
}
