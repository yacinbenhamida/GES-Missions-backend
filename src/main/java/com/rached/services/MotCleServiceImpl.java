package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Motcle;
@Service
@Qualifier("motclesServiceImpl")
public class MotCleServiceImpl implements MotCleService {
	@Autowired
	private MotcleRepository repo;
	@Override
	public List<Motcle> getAllRecords() {
		List<Motcle> res = new ArrayList<Motcle>();
		Iterator<Motcle>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Motcle getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Motcle insertRecord(Motcle elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		Motcle zp = repo.findOne(id);
		repo.delete(zp);	
	}

	@Override
	public Motcle updateRecord(Motcle elem) {
		return repo.save(elem);
	}

	@Override
	public Motcle getRecordBycode(String id) {
		return repo.findOne(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repo.delete(valueOf);	
	}

	@Override
	public List<Motcle> getMcsOfTheme(long idtheme) {
		return repo.getMCOfTheme(idtheme);
	}


}
