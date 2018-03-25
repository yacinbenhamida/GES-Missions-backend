package com.rached.services;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rached.model.TypeFrai;

public interface TypeFraiRepository extends CrudRepository<TypeFrai, Serializable> {
	@Query("select t from TypeFrai t where t.codeTypefr = ?1")
	TypeFrai getTypeByCode(String code);
}
