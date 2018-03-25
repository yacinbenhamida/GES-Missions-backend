package com.rached.services;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rached.model.Grade;

public interface GradeRepository extends CrudRepository<Grade, Serializable>{

}
