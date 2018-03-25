package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MAJ_BUDG_DEP database table.
 * 
 */
@Entity
@Table(name="MAJ_BUDG_DEP")
@NamedQuery(name="MajBudgDep.findAll", query="SELECT m FROM MajBudgDep m")
public class MajBudgDep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAJ_BUDG_DEP_IDMAJBDUGDEP_GENERATOR", sequenceName="PROJET_MAJ_BUDG_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAJ_BUDG_DEP_IDMAJBDUGDEP_GENERATOR")
	@Column(name="ID_MAJ_BDUG_DEP")
	private long idMajBdugDep;
	

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_MAJ")
	private Date dateMaj;

	@Column(name="REF_BUDG_MISSION")
	private String refBudgMission;

	@Column(name="REF_BUDG_TRANSPORT")
	private String refBudgTransport;

	@Column(name="VALEUR_BUDG_MISSION")
	private long valeurBudgMission;

	@Column(name="VALEUR_BUDG_TRANSPORT")
	private long valeurBudgTransport;

	
	@Column(name="ETAT")
	private String etat;
	
	//bi-directional many-to-one association to Departement
	@ManyToOne
	@JoinColumn(name="ID_BUDG_DEP")
	private AvoirBudgDep budget;
	
	public MajBudgDep() {
	}

	public long getIdMajBdugDep() {
		return this.idMajBdugDep;
	}

	public void setIdMajBdugDep(long idMajBdugDep) {
		this.idMajBdugDep = idMajBdugDep;
	}




	@Override
	public String toString() {
		return "MajBudgDep [idMajBdugDep=" + idMajBdugDep + ", dateMaj=" + dateMaj + ", refBudgMission="
				+ refBudgMission + ", refBudgTransport=" + refBudgTransport + ", valeurBudgMission=" + valeurBudgMission
				+ ", valeurBudgTransport=" + valeurBudgTransport + ", etat=" + etat + ", budget=" + budget + "]";
	}

	public Date getDateMaj() {
		return this.dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public String getRefBudgMission() {
		return this.refBudgMission;
	}

	public void setRefBudgMission(String refBudgMission) {
		this.refBudgMission = refBudgMission;
	}

	public String getRefBudgTransport() {
		return this.refBudgTransport;
	}

	public void setRefBudgTransport(String refBudgTransport) {
		this.refBudgTransport = refBudgTransport;
	}

	public long getValeurBudgMission() {
		return this.valeurBudgMission;
	}

	public void setValeurBudgMission(long valeurBudgMission) {
		this.valeurBudgMission = valeurBudgMission;
	}

	public long getValeurBudgTransport() {
		return this.valeurBudgTransport;
	}

	public void setValeurBudgTransport(long valeurBudgTransport) {
		this.valeurBudgTransport = valeurBudgTransport;
	}

	public AvoirBudgDep getBudget() {
		return budget;
	}

	public void setBudget(AvoirBudgDep budget) {
		this.budget = budget;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	

}