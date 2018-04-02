package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Groupe;
// uncompleted
@Service
@Qualifier("groupeServiceImpl")
public class GroupeServiceImpl implements GroupeServices {

	@Autowired
	GroupeRepository repo;
	@Override
	public List<Groupe> getAllRecords() {
		List<Groupe> res = new ArrayList<Groupe>();
		Iterator<Groupe>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Groupe getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Groupe insertRecord(Groupe elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		repo.delete(id);
	}

	@Override
	public Groupe updateRecord(Groupe elem) {
		return repo.save(elem);
	}

	@Override
	public Groupe getRecordBycode(String id) {
		return repo.getRecByCode(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		// TODO Auto-generated method stub
		repo.delete(valueOf);
	}

}
