package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Concerne;
import com.rached.model.OrdreMission;

public interface OrdreConcernePaysRepository extends CrudRepository<Concerne, Serializable> {
		@Query("select c from Concerne c where c.ordre.idOrdre = ?")
		List<Concerne> getAllConcerneoford(long idordre);
}
