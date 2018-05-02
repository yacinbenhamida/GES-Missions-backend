package com.rached.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.AvoirFrai;
import com.rached.model.Missionaire;
import com.rached.model.OrdreMission;
@Service
@Qualifier("ordreMissionServiceImpl")
public class OrdreMissionServiceImpl implements OrdreMissService {

	@Autowired
	OrdreMissRepository ordremissions;
	@Override
	public List<OrdreMission> getAllRecords() {
		List<OrdreMission> res = new ArrayList<OrdreMission>();
		Iterator<OrdreMission>it = ordremissions.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public OrdreMission getRecordById(Long id) {
		return ordremissions.findOne(id);
	}

	@Override
	public OrdreMission insertRecord(OrdreMission elem) {
		return ordremissions.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		ordremissions.delete(id);

	}

	@Override
	public OrdreMission updateRecord(OrdreMission elem) {
		return ordremissions.save(elem);
	}

	@Override
	public OrdreMission getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		ordremissions.delete(valueOf);

	}

	@Override
	public List<OrdreMission> getAllOrdresOfDep(String codeDep) {
		return ordremissions.getAllOrdresOfDep(codeDep);
	}

	@Override
	public List<OrdreMission> getAllOrdresOfMission(long codeMiss,String codeDep) {
		return ordremissions.getAllOrdresOfMission(codeMiss,codeDep);	}

	@Override
	public Long getLatestNumOrdre(long nummiss) {
		return ordremissions.getLatestNumOrdre(nummiss);
	}
	@Override
	public OrdreMission getOrdMOfMission(long numOrdre, long nummis) {
		return ordremissions.getOrdreMissionOf(numOrdre, nummis);
	}

	@Override
	public OrdreMission getOrdByNum(long numOrd) {
		return ordremissions.getOrdreMissionByNum(numOrd);
	}

	@Override
	public List<OrdreMission> getAllMissBTDAC(long idpays, Date deb, Date fin, String codeDep) {
		return ordremissions.getAllMissionsBTDAC(idpays, deb, fin, codeDep);
	}

	@Override
	public List<OrdreMission> getOrdresetatV(String codeDep) {
		return ordremissions.getOrdresetatV("^"+codeDep);
	}

	@Override
	public List<OrdreMission> getAllMissBTDA(Date deb, Date fin, String codeDep) {
		return ordremissions.getAllMissionsBTDA(deb, fin, codeDep);
	}

	@Override
	public List<OrdreMission> getAllOrdresOfDepPourValidationOrdonnateur(String codeDep) {
		return ordremissions.getAllOrdresOfDepPourValidationOrdonnateur(codeDep);
	}

	
	
}
