package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Departement;
import com.rached.model.MajBudgDep;
import com.rached.model.Utilisateur;

public interface MajBudgDepartementRepository extends CrudRepository<MajBudgDep, Serializable> {
	@Query("select m from MajBudgDep m,AvoirBudgDep a where a.departement.codeDep = ?1 AND m.etat='O' AND m.budget = a")
	List<MajBudgDep> getAllMajBudgetsOfdep(String codeDep);
	
	@Query("select m from MajBudgDep m,AvoirBudgDep a,UserStruct u,Departement d "
			+ "where a.departement=?2  AND u.utilisateur = ?1 AND u.departement = d AND a.departement = d  AND m.etat != 'R'")
	List<MajBudgDep> getAllMajBudgDonebyUser(Utilisateur user,Departement dep);
	
	@Query("select m from MajBudgDep m where m.idMajBdugDep = ?1")
	MajBudgDep getMajById(Long id);
	
	@Query("select m from MajBudgDep m,AvoirBudgDep a where  m.budget = a AND a.departement = ?1  AND m.etat != 'R'")
	List<MajBudgDep> getAllMajBudgProgOfDepartement(Departement dep);
	
	@Query("select m from MajBudgDep m where m.budget.idBudgDep = ?1")
	MajBudgDep getMajBudgDepByIdBudget(long codeBudj);
	@Query(nativeQuery=true,
	value="select NVL(SUM(m.VALEUR_BUDG_MISSION),0) from MAJ_BUDG_DEP m,AVOIR_BUDG_DEP d"
			+ "  where  d.CODE_DEP = ?1 AND m.ID_BUDG_DEP=d.ID_BUDG_DEP"
			+ " AND SUBSTR(to_char(m.DATE_MAJ,'dd/mm/yyyy'),7,5)=to_char(?2) AND d.ANNEE_ATTR = ?2"
			+ " AND m.ETAT='S'")
	long getTotalBudgetsObtenusMission(String codeDep,int year);

	@Query(nativeQuery=true,
	value="select NVL(SUM(m.VALEUR_BUDG_TRANSPORT),0) from MAJ_BUDG_DEP m,AVOIR_BUDG_DEP d"
			+ "  where  d.CODE_DEP = ?1 AND m.ID_BUDG_DEP=d.ID_BUDG_DEP"
			+ " AND SUBSTR(to_char(m.DATE_MAJ,'dd/mm/yyyy'),7,5)=to_char(?2) AND d.ANNEE_ATTR = ?2"
			+ " AND m.ETAT='S'")
	double getTotalBudgetsObtenusTransport(String codeDep,int year);
}
