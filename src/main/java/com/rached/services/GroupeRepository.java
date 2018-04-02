package com.rached.services;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Groupe;

public interface GroupeRepository extends CrudRepository<Groupe, Serializable> {
	@Query("select g from Groupe g where g.codeGroupe = ?1")
	Groupe getRecByCode(String code);
}
