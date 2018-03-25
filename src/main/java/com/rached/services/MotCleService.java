package com.rached.services;

import java.util.List;

import com.rached.model.Motcle;

public interface MotCleService extends Services<Motcle> {
	List<Motcle>getMcsOfTheme(long idtheme);
}
