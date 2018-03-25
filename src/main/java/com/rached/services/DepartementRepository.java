package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rached.model.Departement;
import com.rached.model.TypeDep;

public interface DepartementRepository extends CrudRepository<Departement, Serializable>{
	@Query("select d from Departement d where d.typedep = ?1")
	List<Departement> getAllDepsOfType(TypeDep type);
	//@Query("select d from Departement d where d.codeDep LIKE %?1% AND d.typedep.idtypedep != 5")
	@Query(value = "SELECT * FROM DEPARTEMENT where REGEXP_LIKE(CODE_DEP, :codem) AND ID_TYPE_DEP != 5",nativeQuery=true)
	Iterable<Departement> getAllDepsOfMinistere(@Param("codem")String codem);
	
	@Query(value = "SELECT MAX(CODE_DEP) FROM DEPARTEMENT where REGEXP_LIKE(CODE_DEP, :codem) "
			+ "AND SUBSTR(CODE_DEP,3,1)=:codetype AND ID_TYPE_DEP != 5 AND ID_TYPE_DEP= :codetype",nativeQuery=true)
	String getMaxIDdepartement(@Param("codem")String codem,@Param("codetype")String codetype);

	@Query(value="select d from Departement d where d.codeDep = ?1")
	Departement getDepByCode(String codeDep);
}
