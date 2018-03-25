package com.rached.services;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rached.model.Concerne;

public interface OrdreConcernePaysRepository extends CrudRepository<Concerne, Serializable> {

}
