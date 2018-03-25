package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.*;
@Service
@Qualifier("categorieServiceImpl")
public class CategorieServiceImpl implements Services<Categorie> {
	@Autowired
	CategorieRepository repository;

	@Override
	public List<Categorie> getAllRecords() {
		List<Categorie> res = new ArrayList();
		Iterator<Categorie>it = repository.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Categorie getRecordById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Categorie insertRecord(Categorie elem) {
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
	public Categorie updateRecord(Categorie elem) {
		if(repository.exists(elem.getIdcat())) {
			 return repository.save(elem);
			}
		return null;
	}

	@Override
	public Categorie getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repository.delete(valueOf);
		
	}
}
