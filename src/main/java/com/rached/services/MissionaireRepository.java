package com.rached.services;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Missionaire;

public interface MissionaireRepository extends CrudRepository<Missionaire, Serializable> {
	@Query("select m from Missionaire m where m.cin = ?1")
	Missionaire getMissByCIN(long cin);
}
