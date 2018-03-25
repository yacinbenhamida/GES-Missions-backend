package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the AVOIR_BUDG_DEP database table.
 * 
 */
@Entity
@Table(name="AVOIR_BUDG_DEP")
@NamedQuery(name="AvoirBudgDep.findAll", query="SELECT a FROM AvoirBudgDep a")
public class AvoirBudgDep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AVOIR_BUDG_DEP_IDBUDGDEP_GENERATOR", sequenceName="PROJET_BUDG_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AVOIR_BUDG_DEP_IDBUDGDEP_GENERATOR")
	@Column(name="ID_BUDG_DEP")
	private long idBudgDep;

	@Column(name="ANNEE_ATTR")
	private int anneeAttr;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_BUDG")
	private Date dateBudg;

	@Column(name="MONTANT_BUDG_MISSION")
	private long montantBudgMission;

	@Column(name="MONTANT_BUDG_TRANSPORT")
	private long montantBudgTransport;

	@Column(name="REF_BUDG_MISSION")
	private String refBudgMission;

	@Column(name="REF_BUDG_TRANSPORT")
	private String refBudgTransport;
	
	@Column(name="TOTAL_MISSION")
	private long totalMission;
	
	@Column(name="TOTAL_TRANSPORT")
	private long totalTransport;
	
	//bi-directional many-to-one association to Departement
	@ManyToOne
	@JoinColumn(name="CODE_DEP")
	private Departement departement;

	//bi-directional many-to-one association to MajBudgDep
		@OneToMany(mappedBy="budget")
		@JsonIgnore
		private List<MajBudgDep> majBudgDeps = new ArrayList<MajBudgDep>();
	
	public AvoirBudgDep() {
	}

	public long getIdBudgDep() {
		return this.idBudgDep;
	}

	public void setIdBudgDep(long idBudgDep) {
		this.idBudgDep = idBudgDep;
	}

	public int getAnneeAttr() {
		return this.anneeAttr;
	}

	public void setAnneeAttr(int anneeAttr) {
		this.anneeAttr = anneeAttr;
	}

	public Date getDateBudg() {
		return this.dateBudg;
	}

	public void setDateBudg(Date dateBudg) {
		this.dateBudg = dateBudg;
	}

	public long getMontantBudgMission() {
		return this.montantBudgMission;
	}

	public void setMontantBudgMission(long montantBudgMission) {
		this.montantBudgMission = montantBudgMission;
	}

	public long getMontantBudgTransport() {
		return this.montantBudgTransport;
	}

	public void setMontantBudgTransport(long montantBudgTransport) {
		this.montantBudgTransport = montantBudgTransport;
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

	public Departement getDepartement() {
		return this.departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public List<MajBudgDep> getMajBudgDeps() {
		return this.majBudgDeps;
	}

	public void setMajBudgDeps(List<MajBudgDep> majBudgDeps) {
		this.majBudgDeps = majBudgDeps;
	}

	
	
	public long getTotalMission() {
		return totalMission;
	}

	public void setTotalMission(long totalMission) {
		this.totalMission = totalMission;
	}

	public long getTotalTransport() {
		return totalTransport;
	}

	public void setTotalTransport(long totalTransport) {
		this.totalTransport = totalTransport;
	}

	public MajBudgDep addMajBudgDep(MajBudgDep majBudgDep) {
		getMajBudgDeps().add(majBudgDep);
		majBudgDep.setBudget(this);

		return majBudgDep;
	}

	public MajBudgDep removeMajBudgDep(MajBudgDep majBudgDep) {
		getMajBudgDeps().remove(majBudgDep);
		majBudgDep.setBudget(null);

		return majBudgDep;
	}


	@Override
	public String toString() {
		return "AvoirBudgDep [idBudgDep=" + idBudgDep + ", anneeAttr=" + anneeAttr + ", dateBudg=" + dateBudg
				+ ", montantBudgMission=" + montantBudgMission + ", montantBudgTransport=" + montantBudgTransport
				+ ", refBudgMission=" + refBudgMission + ", refBudgTransport=" + refBudgTransport 
				+ "]";
	}
	
	
	
}