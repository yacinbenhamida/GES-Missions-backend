package com.rached.services;

import java.util.List;

import com.rached.model.OrdreMission;

public interface OrdreMissService extends Services<OrdreMission> {
	List<OrdreMission> getAllOrdresOfDep(String codeDep);
	List<OrdreMission> getAllOrdresOfMission(long codeMiss);
	Long getLatestNumOrdre(long nummiss);
	OrdreMission getOrdMOfMission(long numOrdre,long numMISS);
}
