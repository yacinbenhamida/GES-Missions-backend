package com.rached.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Departement;
import com.rached.model.Projet;

public interface ProjetRepository extends CrudRepository<Projet, Serializable> {
	@Query("select p FROM Projet p where p.codeProjet = ?1")
	Projet getProjIdByCode(long code);
	@Query("SELECT p FROM Projet p where p.departement = ?1")
	List<Projet> getAllDepsProjects(Departement d);
}
