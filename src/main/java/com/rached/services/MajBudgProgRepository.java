package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rached.model.Departement;
import com.rached.model.MajBudgDep;
import com.rached.model.MajBudgProg;
import com.rached.model.Projet;
import com.rached.model.Utilisateur;

public interface MajBudgProgRepository extends CrudRepository<MajBudgProg, Serializable> {
	@Query(nativeQuery=true,value="SELECT m.* FROM MAJ_BUDG_PROG m,PROJET p, AVOIR_BUDG_PROG a "
			+ "where m.IDBUDG_PROG = a.IDBUDG_PROG AND a.IDPROJET = p.IDPROJET "
			+ "  AND REGEXP_LIKE(p.CODE_DEP,:codem) AND m.ETAT = 'O' ")
	List<MajBudgProg> getAllupdatesOnBudgetOfProjetOfDep(@Param("codem")String codeDep);
	
	@Query("select m from MajBudgProg m,AvoirBudgProg a,Projet p,Departement d,UserStruct u WHERE"
			+ " u.utilisateur = ?1 and u.departement = ?2 AND d=?2 AND p.departement = d AND a.projet = p"
			+ " AND m.budgetprojet = a  AND m.etat!='R'")
	List<MajBudgProg> getAllMajBudgProgDonebyUser(Utilisateur user,Departement dep);


	@Query("select m from MajBudgProg m,AvoirBudgProg a,Projet p,Departement d where "
			+ " m.budgetprojet = a  AND a.projet=?2 AND a.projet=p AND p.departement=d AND d=?1 AND m.etat!='R'")
	List<MajBudgProg> getAllMajBudgProgOfProg(Departement dep,Projet prj);

	@Query("select m from MajBudgProg m where m.budgetprojet.idbudgProg = ?1")
	MajBudgProg getMajBudgProgByIdBudget(long idbudg);

}
