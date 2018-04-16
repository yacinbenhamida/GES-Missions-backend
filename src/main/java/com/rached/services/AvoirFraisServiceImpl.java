package com.rached.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rached.model.AvoirFrai;
import com.rached.model.Concerne;
import com.rached.model.Pays;
import com.rached.model.Support;
import com.rached.model.TypeFrai;
@Service
@Qualifier("avoirFraisServiceImpl")
public class AvoirFraisServiceImpl implements AvoirFraiService {

	@Autowired
	AvoirFraisRepository frais;
	
	@Autowired
	TypeFraiRepository typefrais;
	
	@Autowired
	OrdreConcernePaysRepository concerne;
	
	@Autowired
	SupportRepository support;
	@Override
	public List<AvoirFrai> getAllRecords() {
		List<AvoirFrai> res = new ArrayList<AvoirFrai>();
		Iterator<AvoirFrai>it = frais.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public AvoirFrai getRecordById(Long id) {
		return frais.findOne(id);
	}

	@Override
	public AvoirFrai insertRecord(AvoirFrai elem) {
		return frais.save(elem);
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		frais.delete(id);
	}

	@Override
	public AvoirFrai updateRecord(AvoirFrai elem) {
		return frais.save(elem);
	}

	@Override
	public AvoirFrai getRecordBycode(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long valueOf) {
		frais.delete(valueOf);

	}
	// type frais
	@Override
	public TypeFrai insertType(TypeFrai type) {
		return typefrais.save(type);
	}

	@Override
	public TypeFrai updateType(TypeFrai type) {
		return typefrais.save(type);
	}

	@Override
	public void deleteType(long idtype) {
		// TODO Auto-generated method stub
		typefrais.delete(idtype);
	}

	@Override
	public TypeFrai getTypeById(long idtype) {
		return typefrais.findOne(idtype);
	}

	@Override
	public List<TypeFrai> getAllTypes() {
		List<TypeFrai> res = new ArrayList();
		Iterator<TypeFrai>it = typefrais.findAll().iterator();
		while(it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	@Override
	public AvoirFrai getAvFraisInsere(AvoirFrai av) {
		return null;
		//return frais.getA(av.getCodeProg(), av.getCodeSupport(), av.getObservation(), av.getSupport(), av.getValeurPrevue(), av.getValeurReel(), av.getTypeFrai());
	}

	@Override
	public List<AvoirFrai> getAvFraisOfORD(long idord) {
		return frais.getAllFraisOfOrdre(idord);
	}

	@Override
	public List<AvoirFrai> getAllFraisDiversOfOrdre(long idordre) {
		return frais.getAllFraisDiversOfOrdre(idordre);
	}

	@Override
	public AvoirFrai getFraisMissionOfConcerne(Concerne c) {
		return frais.getFraisMissionOfConcerne(c,c.getIdconcerne());
	}

	@Override
	public Support getSuppByCode(String code) {
		return support.getSuppByCode(code);
	}





}
