package com.rached.services;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Departement;
import com.rached.model.Mission;
import com.rached.model.OrdreMission;

public interface MissionRepository extends CrudRepository<Mission, Serializable> {
	@Query("select m from Mission m where m.departement.codeDep = ?1")
	List<Mission>getAllMissionsOfDepartement(String codeDep);
	@Query("select MAX(m.numMission) from Mission m where m.departement.codeDep = ?1")
	Long getLatestCodeMissionOfDep(String codeDep);
	@Query("select m from Mission m where m.numMission = ?1 AND m.departement.codeDep = ?2")
	Mission getMissionByNum(long numMiss,String codeDep);
	//B.I.

}
