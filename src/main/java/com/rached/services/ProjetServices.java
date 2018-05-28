package com.rached.services;

import java.util.List;


import com.rached.model.Departement;
import com.rached.model.Projet;

public interface ProjetServices extends Services<Projet> {
	List<Projet>getAllProjetsofdep(Departement d);
}
