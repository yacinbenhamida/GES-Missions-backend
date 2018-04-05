package com.rached.services;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Departement;
import com.rached.model.Missionaire;

public interface MissionaireRepository extends CrudRepository<Missionaire, Serializable> {
	@Query("select m from Missionaire m where m.cin = ?1")
	Missionaire getMissByCIN(long cin);
	
	@Query("select DISTINCT(m) FROM Missionaire m, OrdreMission o,AffectMissDep aff, Departement d where o.missionaire = m AND (o.dateDepP"
			+ " NOT IN(select o.dateDepP from OrdreMission o where o.dateDepP BETWEEN ?1 AND ?2) AND o.dateArrP"
			+ " NOT IN(select o.dateArrP from OrdreMission o where o.dateArrP BETWEEN ?1 AND ?2 ) ) "
			+ " OR (SELECT COUNT(o.numOrdre) FROM OrdreMission o where o.missionaire = m) = 0"
			+ " AND aff.missionaire = m AND aff.departement = d AND d = ?3"
			+ " ")
	List<Missionaire> getAllMissNotHavingMissions(Date deb, Date end,Departement d);
}
