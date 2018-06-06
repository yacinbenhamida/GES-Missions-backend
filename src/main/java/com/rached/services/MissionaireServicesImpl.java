package com.rached.services;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.rached.model.AffectMissDep;
import com.rached.model.Departement;
import com.rached.model.Missionaire;
@Service
@Qualifier("missionaireServicesImpl")
public class MissionaireServicesImpl implements MissionaireServices {

	@Autowired
	MissionaireRepository missionaires;
	
	@Autowired
	MissionAffectRepository affectation;
	
	@Override
	public List<Missionaire> getAllRecords() {
		List<Missionaire> res = new ArrayList<Missionaire>();
		Iterator<Missionaire>it = missionaires.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Missionaire getRecordById(Long id) {
		return missionaires.findOne(id);
	}

	@Override
	public Missionaire insertRecord(Missionaire elem) {
		return missionaires.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		missionaires.delete(id);

	}

	@Override
	public Missionaire updateRecord(Missionaire elem) {
		return missionaires.save(elem);
	}

	@Override
	public Missionaire getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		missionaires.delete(valueOf);
	}

	@Override
	public AffectMissDep insertMissionaireWithAffectation(AffectMissDep aff) {
		return affectation.save(aff);
	}
	@Override
	public List<AffectMissDep> getMissionairesOfDepartement(String codeDep) {
		return affectation.getMissOfDep(codeDep);
	}
	@Override
	public AffectMissDep updateMissDep(AffectMissDep aff) {
		return affectation.save(aff);
	}
	@Override
	public Missionaire getMissByCIN(long cin) {
		return missionaires.getMissByCIN(cin);
	}

	@Override
	public void deleteAffectation(long codeAff) {
		AffectMissDep aff = getAffById(codeAff);
		affectation.delete(aff);		
	}
	@Override
	public AffectMissDep getAffById(long id) {
		return affectation.findOne(id);
	}

	@Override
	public List<Missionaire> getAllMissionairesDep(String codeDep) {
		return affectation.getAllMissOfDep(codeDep);
	}
	@Override
	public List<Missionaire> getAllMissNotHavingMissions(Date deb, Date end, Departement d) {
		return missionaires.getAllMissNotHavingMissions(deb, end, d);
	}

	@Override
	public List<AffectMissDep> getAllAffectationOfMissionaire(long idMissionaire) {
		return affectation.getAllAffectationOfMissionaire(idMissionaire);
	}
	
	@Override
	public AffectMissDep getCurrentDepOFMIssionaire(long idMissionaire) {
		return affectation.getCurrentDepOfMissionaire(idMissionaire);
	}
}
