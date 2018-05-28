package com.rached.services;


import java.util.List;

import com.rached.model.Concerne;
import com.rached.services.OrdreConcernePaysRepository.Results;

public interface OrdreConcernePayService extends Services<Concerne> {
	List<Concerne> getAllConcerneoford(long idordre,String codeDep);
	List<Results>getPaysStats(String codeDep,int year);
}
