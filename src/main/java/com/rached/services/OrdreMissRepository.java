package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.OrdreMission;

public interface OrdreMissRepository extends CrudRepository<OrdreMission, Serializable> {
	@Query("select o from OrdreMission o,Mission m where o.mission = m AND m.departement.codeDep = ?1")
	List<OrdreMission> getAllOrdresOfDep(String codeDep);
	
	@Query("select o from OrdreMission o where o.mission.numMission = ?1")
	List<OrdreMission> getAllOrdresOfMission(long codeMiss);
	
	@Query("select MAX(o.numOrdre) from OrdreMission o where o.mission.numMission = ?1")
	Long getLatestNumOrdre(long nummiss);
	
	@Query("select o from OrdreMission o where o.mission.numMission = ?2 AND o.numOrdre=?1")
	OrdreMission getOrdreMissionOf(long numord,long numMiss) ;
}
