package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the PROJET database table.
 * 
 */
@Entity
@Table(name="projet")
@NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJET_IDPROJET_GENERATOR", sequenceName="PROJ_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJET_IDPROJET_GENERATOR")
	private long idprojet;
	
	@ManyToOne
	@JoinColumn(name="code_dep")
	private Departement departement;

	@Column(name="CODE_PROJET")
	private Long codeProjet;

	@Column(name="LIB_PROJ_AR")
	private String libProjAr;

	@Column(name="LIB_PROJ_FR")
	private String libProjFr;


	//bi-directional many-to-one association to UserStruct
	@OneToMany(mappedBy="projet",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AvoirBudgProg> avoirBudgProg = new ArrayList<AvoirBudgProg>();
    

	public Projet() {
	}

	public  List<AvoirBudgProg> getAvoirBudgProg() {
		return avoirBudgProg;
	}

	public void setAvoirBudgProg( List<AvoirBudgProg> avoirBudgProg) {
		this.avoirBudgProg = avoirBudgProg;
	}

	public long getIdprojet() {
		return this.idprojet;
	}

	public void setIdprojet(long idprojet) {
		this.idprojet = idprojet;
	}

	

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Long getCodeProjet() {
		return this.codeProjet;
	}

	public void setCodeProjet(Long codeProjet) {
		this.codeProjet = codeProjet;
	}

	public String getLibProjAr() {
		return this.libProjAr;
	}

	public void setLibProjAr(String libProjAr) {
		this.libProjAr = libProjAr;
	}

	public String getLibProjFr() {
		return this.libProjFr;
	}

	public void setLibProjFr(String libProjFr) {
		this.libProjFr = libProjFr;
	}

	

	public AvoirBudgProg addAvoirBudgetProjet(AvoirBudgProg budg) {
		getAvoirBudgProg().add(budg);
		budg.setProjet(this);
		return budg;
	}

	public AvoirBudgProg removeAvoirBudgetProjet(AvoirBudgProg budg) {
		getAvoirBudgProg().remove(budg);
		budg.setProjet(null);
		return budg;
	}
	
	@Override
	public String toString() {
		return "Projet [idprojet=" + idprojet + ", departement=" + departement + ", codeProjet=" + codeProjet
				+ ", libProjAr=" + libProjAr + ", libProjFr=" + libProjFr + ", budget=" + avoirBudgProg + "]";
	}

}