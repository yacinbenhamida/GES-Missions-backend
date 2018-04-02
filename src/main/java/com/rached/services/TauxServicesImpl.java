package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Taux;
@Service
@Qualifier("tauxServicesImpl")
public class TauxServicesImpl implements Services<Taux> {

	@Autowired
	TauxRepository repo;
	@Override
	public List<Taux> getAllRecords() {
		List<Taux> res = new ArrayList<Taux>();
		Iterator<Taux>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Taux getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Taux insertRecord(Taux elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		repo.delete(id);
	}

	@Override
	public Taux updateRecord(Taux elem) {
		return repo.save(elem);
	}

	@Override
	public Taux getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
			repo.delete(valueOf);
		
	}

}
