package com.rached.services;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rached.model.Pays;

public interface PaysRepository extends CrudRepository<Pays, Serializable> {

}
