package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Pays;
@Service
@Qualifier("paysServicesImpl")
public class PaysServicesImpl implements Services<Pays> {

	@Autowired
	private PaysRepository repo;
	@Override
	public List<Pays> getAllRecords() {
		List<Pays> res = new ArrayList<Pays>();
		Iterator<Pays>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Pays getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Pays insertRecord(Pays elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		Pays zp = repo.findOne(id);
		repo.delete(zp);	
	}

	@Override
	public Pays updateRecord(Pays elem) {
		return repo.save(elem);
	}

	@Override
	public Pays getRecordBycode(String id) {
		return repo.findOne(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repo.delete(valueOf);
		
	}

}
