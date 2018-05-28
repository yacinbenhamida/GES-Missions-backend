package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.*;
@Service
@Qualifier("gradeServiceImpl")
public class GradeServiceImpl implements Services<Grade> {

	@Autowired
	GradeRepository repository;

	@Override
	public List<Grade> getAllRecords() {
		List<Grade> res = new ArrayList<Grade>();
		Iterator<Grade>it = repository.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Grade getRecordById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Grade insertRecord(Grade elem) {
		if(elem!=null) {		
			return repository.save(elem);
		}return null;
	}

	@Override
	public void deleteRecord(int id) {
		if(repository.exists(id)) {			
			 repository.delete(id);
		}
	}

	@Override
	public Grade updateRecord(Grade elem) {
		if(repository.exists(elem.getIdgrade())) {			 
			 return repository.save(elem);
			}
		return null;
	}

	@Override
	public Grade getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repository.delete(valueOf);
		
	}
}
