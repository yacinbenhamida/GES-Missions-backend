package com.rached.services;

import java.util.List;

import com.rached.model.AffectMissDep;
import com.rached.model.Missionaire;

public interface MissionaireServices extends Services<Missionaire> {
	AffectMissDep insertMissionaireWithAffectation(AffectMissDep aff);
	List<AffectMissDep> getMissionairesOfDepartement(String codeDep);
	AffectMissDep updateMissDep(AffectMissDep aff);
	Missionaire getMissByCIN(long cin);
	void deleteAffectation(long codeAff);
	AffectMissDep getAffById(long id);
	List<Missionaire> getAllMissionairesDep(String codeDep);
}
