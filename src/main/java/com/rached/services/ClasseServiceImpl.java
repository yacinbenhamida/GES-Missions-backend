package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.*;
@Service
@Qualifier("classeServiceImpl")
public class ClasseServiceImpl implements Services<Classe> {
	@Autowired
	ClasseRepository repository;

	@Override
	public List<Classe> getAllRecords() {
		List<Classe> res = new ArrayList();
		Iterator<Classe>it = repository.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Classe getRecordById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Classe insertRecord(Classe elem) {
		if(elem!=null) {		
			return repository.save(elem);
		}
		return null;
	}

	@Override
	public void deleteRecord(int id) {
		if(repository.exists(id)) {
			repository.delete(id);
		}
	}

	@Override
	public Classe updateRecord(Classe elem) {
		if(repository.exists(elem.getIdclasse())) {
			 return repository.save(elem);
			}
		return null;
	}

	@Override
	public Classe getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repository.delete(valueOf);
		
	}
}
