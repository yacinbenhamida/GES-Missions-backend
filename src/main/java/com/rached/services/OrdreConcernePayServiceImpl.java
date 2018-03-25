package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.AvoirFrai;
/*
 * joint class between ordre & pays : CONCERNE
 */
import com.rached.model.Concerne;
@Service
@Qualifier("ordreConcernePayServiceImpl")
public class OrdreConcernePayServiceImpl implements OrdreConcernePayService {
	
	@Autowired
	OrdreConcernePaysRepository concerne;
	
	@Override
	public List<Concerne> getAllRecords() {
		List<Concerne> res = new ArrayList<Concerne>();
		Iterator<Concerne>it = concerne.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public Concerne getRecordById(Long id) {
		// TODO Auto-generated method stub
		return concerne.findOne(id);
	}

	@Override
	public Concerne insertRecord(Concerne elem) {
		// TODO Auto-generated method stub
		return concerne.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		concerne.delete(id);
	}

	@Override
	public Concerne updateRecord(Concerne elem) {
		// TODO Auto-generated method stub
		return concerne.save(elem);
	}

	@Override
	public Concerne getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		// TODO Auto-generated method stub
		concerne.delete(valueOf);
	}

}
