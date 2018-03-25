package com.rached.services;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rached.model.Categorie;

public interface CategorieRepository extends CrudRepository<Categorie, Serializable>{

}
