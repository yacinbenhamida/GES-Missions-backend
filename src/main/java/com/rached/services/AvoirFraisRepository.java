package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rached.model.AvoirFrai;
import com.rached.model.Concerne;


public interface AvoirFraisRepository extends CrudRepository<AvoirFrai, Serializable> {
	
	@Query("select a from AvoirFrai a where a.ordreMission.idOrdre = ?1 AND a.ordreMission.mission.departement.codeDep = ?2")
	List<AvoirFrai> getAllFraisOfOrdre(long idordre,String codeDep);
	
	@Query("select a from AvoirFrai a where a.ordreMission.idOrdre = ?1 AND a.typeFrai.codeTypefr != '0808'")
	List<AvoirFrai> getAllFraisDiversOfOrdre(long idordre);
	
	@Query("select a from AvoirFrai a,OrdreMission o,Concerne c,Pays p where c = :conc AND c.idconcerne = :idc AND o=c.ordre"
			+ " AND a.ordreMission = o AND a.ordreMission = c.ordre AND a.typeFrai.codeTypefr='0808' AND c.pays = p "
			+ " AND o.mission.departement.codeDep = :codeDep AND o.idOrdre = :idordre")
	AvoirFrai getFraisMissionOfConcerne(@Param("conc")Concerne c,@Param("idc")long idc,@Param("codeDep")String codeDep,@Param("idordre") long idOrdre);
	
	@Query("SELECT NVL(SUM(a.valeurPrevue),0) FROM AvoirFrai a,OrdreMission o WHERE a.ordreMission.mission.departement.codeDep=?1 AND "
			+ " SUBSTR(to_char(a.ordreMission.dateDepP,'dd/mm/yyyy'),7,5)=to_char(?2) "
			+ " AND SUBSTR(to_char(a.ordreMission.dateArrP,'dd/mm/yyyy'),7,5)=to_char(?2)"
			+ " AND a.typeFrai.codeTypefr = '0808' AND (o.etat='PA' OR o.etat='S') AND a.ordreMission = o AND (a.support.codeSupport = 'I' OR a.support.codeSupport = 'J')")
	double getTotalFraisMissionPromis(String codeDep,int year); // organisme
	
	@Query("SELECT NVL(SUM(a.valeurPrevue),0) FROM AvoirFrai a,OrdreMission o WHERE a.ordreMission.mission.departement.codeDep=?1 AND "
			+ " SUBSTR(to_char(a.ordreMission.dateDepP,'dd/mm/yyyy'),7,5)=to_char(?2) "
			+ " AND SUBSTR(to_char(a.ordreMission.dateArrP,'dd/mm/yyyy'),7,5)=to_char(?2)"
			+ " AND a.typeFrai.codeTypefr = '0606' AND (o.etat='PA' OR o.etat='S') AND a.ordreMission = o AND (a.support.codeSupport = 'I' OR a.support.codeSupport = 'J')")
	double getTotalFraisTransportPromis(String codeDep,int year); // organisme 
	
	
	@Query("SELECT NVL(SUM(a.valeurPrevue),0) FROM AvoirFrai a,OrdreMission o WHERE a.ordreMission.mission.departement.codeDep=?1  "
			+ " AND a.projet.idprojet = ?3"
			+ " AND SUBSTR(to_char(a.ordreMission.dateDepP,'dd/mm/yyyy'),7,5)=to_char(?2) "
			+ " AND SUBSTR(to_char(a.ordreMission.dateArrP,'dd/mm/yyyy'),7,5)=to_char(?2)"
			+ " AND (o.etat='PA' OR o.etat='S') AND a.ordreMission = o AND (a.support.codeSupport = 'A' OR a.support.codeSupport = 'M')")
	double getToalFraisPECProjetPromis(String codeDep,int year,long idprojet); //projet
}
