package com.rached.services;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.OrdreMission;

public interface OrdreMissRepository extends CrudRepository<OrdreMission, Serializable> {
	@Query("select o from OrdreMission o,Mission m where o.mission = m AND m.departement.codeDep = ?1 AND o.etat='E' ")
	List<OrdreMission> getAllOrdresOfDep(String codeDep);
	
	@Query("select o from OrdreMission o where o.mission.numMission = ?1")
	List<OrdreMission> getAllOrdresOfMission(long codeMiss);
	
	@Query("select MAX(o.numOrdre) from OrdreMission o where o.mission.numMission = ?1")
	Long getLatestNumOrdre(long nummiss);
	
	@Query("select o from OrdreMission o where o.mission.numMission = ?2 AND o.numOrdre=?1")
	OrdreMission getOrdreMissionOf(long numord,long numMiss) ;
	
	@Query("select o from OrdreMission o where o.numOrdre=?1")
	OrdreMission getOrdreMissionByNum(long numOrd);
	
	
	@Query("select DISTINCT(om) from OrdreMission om,Mission m, Pays p,Concerne c"
			+ " WHERE om.mission=m AND c.ordre = om AND c.pays.idpays=?1 AND m.dateDepartP BETWEEN ?2 AND ?3 AND"
			+ " m.dateArriveP BETWEEN ?2 AND ?3  AND m.departement.codeDep = ?4")
	List<OrdreMission> getAllMissionsBTDAC(long idpays,Date deb,Date fin,String codeDep);
}
