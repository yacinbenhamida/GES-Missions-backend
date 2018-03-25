package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.Utilisateur;
import com.rached.model.Zonepays;
@Service
@Qualifier("zoneServiceImpl")
public class ZoneServiceImpl implements Services<Zonepays> {

	@Autowired
	private ZoneRepository repo;
	@Override
	public List<Zonepays> getAllRecords() {
		List<Zonepays> res = new ArrayList();
		Iterator<Zonepays>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Zonepays getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public Zonepays insertRecord(Zonepays elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		Zonepays zp = repo.findOne(id);
		repo.delete(zp);	
	}

	@Override
	public Zonepays updateRecord(Zonepays elem) {
		return repo.save(elem);
	}

	@Override
	public Zonepays getRecordBycode(String id) {
		return repo.findOne(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repo.delete(valueOf);
		
	}

}
