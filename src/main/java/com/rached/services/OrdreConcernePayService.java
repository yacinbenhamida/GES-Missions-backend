package com.rached.services;

import java.util.List;

import com.rached.model.Concerne;

public interface OrdreConcernePayService extends Services<Concerne> {
	List<Concerne> getAllConcerneoford(long idordre,String codeDep);
}
