package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.*;
@Service
@Qualifier("fonctionServiceImpl")
public class FonctionServiceImpl implements Services<Fonction>{

	@Autowired
	FonctionRepository fctrepository;

	@Override
	public List<Fonction> getAllRecords() {
		List<Fonction> res = new ArrayList();
		Iterator<Fonction>it = fctrepository.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Fonction getRecordById(Long id) {
		return fctrepository.findOne(id);
	}

	@Override
	public Fonction insertRecord(Fonction elem) {
		if(elem!=null) {		
			return fctrepository.save(elem);
		}
		return null;
	}

	@Override
	public void deleteRecord(int id) {
		if(fctrepository.exists(id)) {		
			fctrepository.delete(id);
		}
	}

	@Override
	public Fonction updateRecord(Fonction elem) {
		if(fctrepository.exists(elem.getIdfct())) {
		 return fctrepository.save(elem);
		}
		return null;
	}

	@Override
	public Fonction getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		fctrepository.delete(valueOf);
		
	}
	
}
