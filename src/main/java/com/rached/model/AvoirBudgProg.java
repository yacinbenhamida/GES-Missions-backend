package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the AVOIR_BUDG_PROG database table.
 * 
 */
@Entity
@Table(name="AVOIR_BUDG_PROG")
@NamedQuery(name="AvoirBudgProg.findAll", query="SELECT a FROM AvoirBudgProg a")
public class AvoirBudgProg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AVOIR_BUDG_PROG_IDBUDGPROG_GENERATOR", sequenceName="AV_BUDG_PROG_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AVOIR_BUDG_PROG_IDBUDGPROG_GENERATOR")
	@Column(name="IDBUDG_PROG")
	private long idbudgProg;

	@Column(name="ANNEE_ATTR")
	private int anneeAttr;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_BUDG")
	private Date dateBudg;

	@Column(name="MONTANT_BUDG")
	private double montantBudg;

	@Column(name="REF_BUDG_PROG")
	private long refBudgProg;

	@Column(name="TOTAL_BUDGET")
	private double totalBudget;
	
	//bi-directional many-to-one association to MajBudgProg
	@OneToMany(mappedBy="budgetprojet",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<MajBudgProg> majBudgProgs;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="IDPROJET")
	private Projet projet;

	
	public AvoirBudgProg() {
	}

	public long getIdbudgProg() {
		return this.idbudgProg;
	}

	public void setIdbudgProg(long idbudgProg) {
		this.idbudgProg = idbudgProg;
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

	public double getMontantBudg() {
		return this.montantBudg;
	}

	public void setMontantBudg(double montantBudg) {
		this.montantBudg = montantBudg;
	}

	public long getRefBudgProg() {
		return this.refBudgProg;
	}

	public void setRefBudgProg(long refBudgProg) {
		this.refBudgProg = refBudgProg;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<MajBudgProg> getMajBudgProgs() {
		return majBudgProgs;
	}

	public void setMajBudgProgs(List<MajBudgProg> majBudgProgs) {
		this.majBudgProgs = majBudgProgs;
	}

	public MajBudgProg addMajBudgProg(MajBudgProg majBudgProg) {
		getMajBudgProgs().add(majBudgProg);
		majBudgProg.setBudgetprojet(this);

		return majBudgProg;
	}
	
	

	public double getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(double totalBudget) {
		this.totalBudget = totalBudget;
	}

	public MajBudgProg removeMajBudgProg(MajBudgProg majBudgProg) {
		getMajBudgProgs().remove(majBudgProg);
		majBudgProg.setBudgetprojet(null);

		return majBudgProg;
	}
	@Override
	public String toString() {
		return "AvoirBudgProg [idbudgProg=" + idbudgProg + ", anneeAttr=" + anneeAttr + ", dateBudg=" + dateBudg
				+ ", montantBudg=" + montantBudg + ", refBudgProg=" + refBudgProg + ", projet=" + projet + "]";
	}



}