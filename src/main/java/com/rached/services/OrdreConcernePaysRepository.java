package com.rached.services;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.rached.model.Concerne;

public interface OrdreConcernePaysRepository extends CrudRepository<Concerne, Serializable> {
		@Query("select c from Concerne c where c.ordre.idOrdre = ?1 AND c.ordre.mission.departement.codeDep = ?2")
		List<Concerne> getAllConcerneoford(long idordre,String codeDep);
		@Query("select c.pays.libPaysAr as nomPays ,COUNT(c) as valueP  FROM "
				+ " Concerne c where c.ordre.mission.departement.codeDep = ?1 "
				+ " AND SUBSTR(to_char(c.ordre.dateArrP,'dd/mm/yyyy'),7,5)=to_char(?2) "
				+ " AND SUBSTR(to_char(c.ordre.dateDepP,'dd/mm/yyyy'),7,5)=to_char(?2) GROUP BY c.pays.libPaysAr")
		List<Results> getPaysStats(String codeDep,int year);
		
		static interface Results {
		   String getnomPays();
		   Integer getvalueP();
		}
}
