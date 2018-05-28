package com.rached.services;

import java.util.List;

import com.rached.model.Mission;

public interface MissionServices extends Services<Mission> {
	List<Mission> getAllMissionsOfDepartement(String codeDep);
	Long getLatestCodeMOfDepartement(String codeDep);
	Mission getMissByNum(long numMiss,String codeDep);
	// BI

}
