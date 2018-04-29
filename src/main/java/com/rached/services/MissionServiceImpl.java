package com.rached.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Mission;
@Service
@Qualifier("missionServiceImpl")
public class MissionServiceImpl implements MissionServices {

	@Autowired
	MissionRepository missions;
	@Override
	public List<Mission> getAllRecords() {
		List<Mission> res = new ArrayList<Mission>();
		Iterator<Mission>it = missions.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Mission getRecordById(Long id) {
		return missions.findOne(id);
	}

	@Override
	public Mission insertRecord(Mission elem) {
		return missions.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		missions.delete(id);

	}

	@Override
	public Mission updateRecord(Mission elem) {
		return missions.save(elem);
	}

	@Override
	public Mission getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		missions.delete(valueOf);

	}

	@Override
	public List<Mission> getAllMissionsOfDepartement(String codeDep) {
		return missions.getAllMissionsOfDepartement(codeDep);
	}

	@Override
	public Long getLatestCodeMOfDepartement(String codeDep) {
		return missions.getLatestCodeMissionOfDep(codeDep);
	}

	@Override
	public Mission getMissByNum(long numMiss,String codeDep) {
		return missions.getMissionByNum(numMiss,codeDep);
	}



}
