package com.rached.services;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rached.model.Taux;

public interface TauxRepository extends CrudRepository<Taux, Serializable> {

}
