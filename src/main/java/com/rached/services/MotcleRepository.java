package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Motcle;

public interface MotcleRepository extends CrudRepository<Motcle , Serializable> {
	@Query("select m from Motcle m where m.theme.idtheme = ?1")
	List<Motcle>getMCOfTheme(long idth); 
}
