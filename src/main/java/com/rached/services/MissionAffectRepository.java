package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.AffectMissDep;
import com.rached.model.Missionaire;

public interface MissionAffectRepository extends CrudRepository<AffectMissDep, Serializable> {
	@Query("SELECT a from Missionaire m,AffectMissDep a WHERE m=a.missionaire AND a.departement.codeDep = ?1")
	List<AffectMissDep> getMissOfDep(String codeDep);
	
	@Query("SELECT m from Missionaire m,AffectMissDep a WHERE m=a.missionaire AND a.departement.codeDep = ?1")
	List<Missionaire> getAllMissOfDep(String codeDep);
}
