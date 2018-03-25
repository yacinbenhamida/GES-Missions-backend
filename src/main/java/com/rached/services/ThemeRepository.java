package com.rached.services;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rached.model.Theme;

public interface ThemeRepository extends CrudRepository<Theme, Serializable> {
	
}
