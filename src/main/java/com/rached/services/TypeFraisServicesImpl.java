package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.rached.model.TypeFrai;
@Service
@Qualifier("typeFraisServicesImpl")
public class TypeFraisServicesImpl implements Services<TypeFrai> {

	@Autowired
	TypeFraiRepository repo;
	@Override
	public List<TypeFrai> getAllRecords() {
		List<TypeFrai> res = new ArrayList<TypeFrai>();
		Iterator<TypeFrai>it = repo.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public TypeFrai getRecordById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public TypeFrai insertRecord(TypeFrai elem) {
		return repo.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		repo.delete(id);
		
	}

	@Override
	public TypeFrai updateRecord(TypeFrai elem) {
		return repo.save(elem);
	}

	@Override
	public TypeFrai getRecordBycode(String id) {
		return repo.getTypeByCode(id);
	}

	@Override
	public void deleteRecord(Long valueOf) {
		repo.delete(valueOf);
	}

}
