package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.PaysFrai;
@Service
@Qualifier("paysFraiServiceImpl")
public class PaysFraiServiceImpl implements PaysFraiService {
	@Autowired
	PaysFraisRepository frais;
	
	@Override
	public List<PaysFrai> getAllRecords() {
		List<PaysFrai> res = new ArrayList();
		Iterator<PaysFrai>it = frais.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public PaysFrai getRecordById(Long id) {
		return frais.findOne(id);
	}

	@Override
	public PaysFrai insertRecord(PaysFrai elem) {
		return frais.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		frais.delete(id);
	}

	@Override
	public PaysFrai updateRecord(PaysFrai elem) {
		return frais.save(elem);
	}

	@Override
	public PaysFrai getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		// TODO Auto-generated method stub
		frais.delete(valueOf);
	}

}
