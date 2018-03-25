package com.rached.services;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rached.model.Classe;
import com.rached.model.Fonction;

public interface ClasseRepository extends CrudRepository<Classe, Serializable>{

}
