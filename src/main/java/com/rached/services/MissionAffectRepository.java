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
	
	@Query("SELECT am from AffectMissDep am where am.missionaire.idMissionaire = ?1")
	List<AffectMissDep> getAllAffectationOfMissionaire(long idMissionaire);
	@Query("SELECT a from Missionaire m, AffectMissDep a WHERE a.missionaire = m AND m.idMissionaire = ?1 "
			+ "AND a.dateAffectation = (select MAX(aff.dateAffectation) from AffectMissDep aff where aff.missionaire.idMissionaire = ?1)"
			+ " AND a.idAffectation = (SELECT DISTINCT(MAX(b.idAffectation)) FROM AffectMissDep b WHERE b.missionaire.idMissionaire = ?1)")
	AffectMissDep getCurrentDepOfMissionaire(long idMissionaire);
}
