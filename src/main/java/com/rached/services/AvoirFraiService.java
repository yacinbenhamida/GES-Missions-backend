package com.rached.services;

import java.util.List;

import com.rached.model.AvoirFrai;
import com.rached.model.Concerne;
import com.rached.model.Support;
import com.rached.model.TypeFrai;

public interface AvoirFraiService extends Services<AvoirFrai> {
	TypeFrai insertType(TypeFrai type);
	TypeFrai updateType(TypeFrai type);
	void deleteType(long idtype);
	TypeFrai getTypeById(long idtype);
	List<TypeFrai> getAllTypes();
	AvoirFrai getAvFraisInsere(AvoirFrai av);
	List<AvoirFrai> getAvFraisOfORD(long idord,String codeDep);
	List<AvoirFrai> getAllFraisDiversOfOrdre(long idordre);
	AvoirFrai getFraisMissionOfConcerne(Concerne c,String codeDep,long idOrdre);
	Support getSuppByCode(String code);
	double getTotalFraisMissionPromis(String codeDep,int year);
	double getTotalFraisTransportPromis(String codeDep,int year);
	double getToalFraisPECProjetPromis(String codeDep,int year,long idProjet);
}
