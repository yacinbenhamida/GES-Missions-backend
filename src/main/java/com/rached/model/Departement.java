package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the DEPARTEMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Departement.findAll", query="SELECT d FROM Departement d")
public class Departement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE_DEP")
	private String codeDep;

	@Column(name="COMPTEUR_MISSIONS")
	private BigDecimal compteurMissions;

	@Column(name="LIB_DEP_AR")
	private String libDepAr;

	@Column(name="LIB_DEP_FR")
	private String libDepFr;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_TYPE_DEP")
	private TypeDep typedep;

	
	//bi-directional many-to-one association to AvoirBudgDep
	@OneToMany(mappedBy="departement")
	@JsonIgnore
	private List<AvoirBudgDep> avoirBudgDeps;
	
	//bi-directional many-to-one association to UserStruct
	@OneToMany(mappedBy="departement")
	@JsonIgnore
	private List<UserStruct> userStructs = new ArrayList<UserStruct>();

	@OneToMany(mappedBy="departement",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Projet> projets = new ArrayList<Projet>();
	

	@OneToMany(mappedBy="departement",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<AffectMissDep> affectations = new ArrayList<AffectMissDep>();
	
	
	@OneToMany(mappedBy="departement",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Mission> missions = new ArrayList<Mission>();
	
	
	public Departement() {
	}

	public TypeDep getTypedep() {
		return typedep;
	}

	public void setTypedep(TypeDep typedep) {
		this.typedep = typedep;
	}

	public String getCodeDep() {
		return this.codeDep;
	}

	public void setCodeDep(String codeDep) {
		this.codeDep = codeDep;
	}

	public BigDecimal getCompteurMissions() {
		return this.compteurMissions;
	}

	public void setCompteurMissions(BigDecimal compteurMissions) {
		this.compteurMissions = compteurMissions;
	}

	public String getLibDepAr() {
		return this.libDepAr;
	}

	public void setLibDepAr(String libDepAr) {
		this.libDepAr = libDepAr;
	}

	public String getLibDepFr() {
		return this.libDepFr;
	}

	public void setLibDepFr(String libDepFr) {
		this.libDepFr = libDepFr;
	}

	public List<AvoirBudgDep> getAvoirBudgDeps() {
		return this.avoirBudgDeps;
	}

	public void setAvoirBudgDeps(List<AvoirBudgDep> avoirBudgDeps) {
		this.avoirBudgDeps = avoirBudgDeps;
	}

	
	
	public List<AffectMissDep> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<AffectMissDep> affectations) {
		this.affectations = affectations;
	}

	public AvoirBudgDep addAvoirBudgDep(AvoirBudgDep avoirBudgDep) {
		getAvoirBudgDeps().add(avoirBudgDep);
		avoirBudgDep.setDepartement(this);

		return avoirBudgDep;
	}

	public AvoirBudgDep removeAvoirBudgDep(AvoirBudgDep avoirBudgDep) {
		getAvoirBudgDeps().remove(avoirBudgDep);
		avoirBudgDep.setDepartement(null);

		return avoirBudgDep;
	}



	public UserStruct addUserStruct(UserStruct userStruct) {
		getUserStructs().add(userStruct);
		userStruct.setDepartement(this);

		return userStruct;
	}

	public UserStruct removeUserStruct(UserStruct userStruct) {
		getUserStructs().remove(userStruct);
		userStruct.setDepartement(null);

		return userStruct;
	}


	public AffectMissDep addAffectation(AffectMissDep affectMissDep) {
		getAffectations().add(affectMissDep);
		affectMissDep.setDepartement(this);

		return affectMissDep;
	}

	public AffectMissDep removeAffectation(AffectMissDep affectMissDep) {
		getAffectations().remove(affectMissDep);
		affectMissDep.setDepartement(null);

		return affectMissDep;
	}
	
	public List<UserStruct> getUserStructs() {
		return userStructs;
	}

	public void setUserStructs(List<UserStruct> userStructs) {
		this.userStructs = userStructs;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	
	
	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Mission addMission(Mission mission) {
		getMissions().add(mission);
		mission.setDepartement(this);

		return mission;
	}

	public Mission removeMission(Mission mission) {
		getMissions().remove(mission);
		mission.setDepartement(null);

		return mission;
	}
	
	@Override
	public String toString() {
		return "Departement [codeDep=" + codeDep + ", compteurMissions=" + compteurMissions + ", libDepAr=" + libDepAr
				+ ", libDepFr=" + libDepFr + "]";
	}
	
	

}