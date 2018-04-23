package com.rached.services;

import java.sql.Date;
import java.util.List;

import com.rached.model.Mission;
import com.rached.model.Missionaire;
import com.rached.model.OrdreMission;

public interface OrdreMissService extends Services<OrdreMission> {
	List<OrdreMission> getAllOrdresOfDep(String codeDep);
	List<OrdreMission> getAllOrdresOfMission(long codeMiss);
	Long getLatestNumOrdre(long nummiss);
	OrdreMission getOrdMOfMission(long numOrdre,long numMISS);
	OrdreMission getOrdByNum(long numOrd);
	List<OrdreMission> getAllMissBTDAC(long idpays,Date deb,Date fin,String codeDep);
	List<OrdreMission> getAllMissBTDA(Date deb,Date fin,String codeDep);
	List<OrdreMission> getOrdresetatV(String codeDep);
}
