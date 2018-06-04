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
	
	/*@Query("select DISTINCT(m) FROM Missionaire m, OrdreMission o,AffectMissDep aff, Departement d where o.missionaire = m AND "
			+ "( ( o.dateDepP NOT IN(select c.dateDepP from OrdreMission c where c.dateDepP BETWEEN ?1 AND ?2) AND o.dateArrP"
			+ " NOT IN(select f.dateArrP from OrdreMission f where f.dateArrP BETWEEN ?1 AND ?2 ) ) "
			+ " OR (SELECT COUNT(b.numOrdre) FROM OrdreMission b where b.missionaire = m) = 0  "
			+ " OR (SELECT i from OrdreMission i where i.missionaire = m )=null )"
			+ " AND aff.missionaire = m AND aff.departement = d AND d = ?3 AND aff.departement = ?3 AND o.mission.departement = ?3)")
	*//*
	@Query("select DISTINCT(m) FROM Missionaire m, OrdreMission o,AffectMissDep a where a.departement = ?3 AND o.mission.departement = ?3"
			+ " AND a.missionaire = m AND o.missionaire = m AND ( ( o.dateDepP NOT IN(select c.dateDepP from OrdreMission c where c.dateDepP BETWEEN ?1 AND ?2 AND c.mission.departement = ?3) AND o.dateArrP" 
			 + " NOT IN(select f.dateArrP from OrdreMission f where f.dateArrP BETWEEN ?1 AND ?2 AND f.mission.departement = ?3) AND "
			 + " (SELECT COUNT(p.numOrdre) FROM OrdreMission p where p.missionaire = m AND p.mission.departement = ?3) > 0 )"
			 + " OR ( (SELECT COUNT(b.numOrdre) FROM OrdreMission b where b.missionaire = m AND b.mission.departement = ?3) = 0  ) OR ((SELECT count(g.numOrdre) from OrdreMission g where g.mission.departement = ?3) =0 "
			 + " AND a.departement = ?3 AND a.missionaire = m  ) )  ")*/
	/*@Query("select DISTINCT(m) FROM Missionaire m, OrdreMission o,AffectMissDep a where a.departement = ?3 AND o.mission.departement = ?3"
			+ " AND a.missionaire = m AND o.missionaire = m AND ( ( o.dateDepP NOT IN(select c.dateDepP  from OrdreMission c where c.dateArrP>=?2 OR   c.dateDepP<= ?1 AND c.mission.departement = ?3) AND"
			+ " o.dateArrP NOT IN(select cd.dateArrP  from OrdreMission cd where cd.dateArrP >= ?2 OR   cd.dateDepP <= ?1 AND cd.mission.departement = ?3) AND" 
			 + " (SELECT COUNT(p.numOrdre) FROM OrdreMission p where p.missionaire = m AND p.mission.departement = ?3) > 0 )"
			 + " OR ( (SELECT COUNT(b.numOrdre) FROM OrdreMission b where b.missionaire = m AND b.mission.departement = ?3) = 0  ) OR ((SELECT count(g.numOrdre) from OrdreMission g where g.mission.departement = ?3) =0 "
			 + " AND a.departement = ?3 AND a.missionaire = m  ) )  ")*/
	@Query("SELECT DISTINCT(m) from Missionaire m, OrdreMission o,AffectMissDep a WHERE "
			+ " a.departement = ?3 AND o.mission.departement = ?3 AND a.missionaire = m"
			+ " AND (( o.dateArrP NOT BETWEEN ?1  and  ?2"
			+ " AND o.dateDepP NOT BETWEEN ?1  and ?2)  "
			+ " OR (SELECT COUNT(b.numOrdre) FROM OrdreMission b where b.missionaire = m AND b.mission.departement = ?3) = 0)")
	List<Missionaire> getAllMissNotHavingMissions(Date deb, Date end,Departement d);
}
