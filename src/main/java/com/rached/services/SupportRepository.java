package com.rached.services;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.Support;

public interface SupportRepository extends CrudRepository<Support, Serializable> {
	@Query("select s from Support s where s.codeSupport = ?1")
	Support getSuppByCode(String code);
}
