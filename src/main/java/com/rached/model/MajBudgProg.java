package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MAJ_BUDG_PROG database table.
 * 
 */

@Entity
@Table(name="MAJ_BUDG_PROG")
@NamedQuery(name="MajBudgProg.findAll", query="SELECT m FROM MajBudgProg m")
public class MajBudgProg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAJ_BUDG_PROG_IDMAJBUDGPRG_GENERATOR", sequenceName="MAJ_BUDGJPRJ_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAJ_BUDG_PROG_IDMAJBUDGPRG_GENERATOR")
	
	@Column(name="IDMAJ_BUDG_PRG")
	private long idmajBudgPrg;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_MAJ_BUDG_PROG")
	private Date dateMajBudgProg;

	@Column(name="REF_BUDGET")
	private long refBudget;

	@Column(name="VALEUR_MAJ_BUDG_PROG")
	private double valeurMajBudgProg;

	//bi-directional many-to-one association to Projet
	@ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	@JoinColumn(name="IDBUDG_PROG")
	private AvoirBudgProg budgetprojet;

	@Column(name="ETAT")
	private String etat;
	
	public MajBudgProg() {
	}

	public long getIdmajBudgPrg() {
		return this.idmajBudgPrg;
	}

	public void setIdmajBudgPrg(long idmajBudgPrg) {
		this.idmajBudgPrg = idmajBudgPrg;
	}

	public Date getDateMajBudgProg() {
		return this.dateMajBudgProg;
	}

	public void setDateMajBudgProg(Date dateMajBudgProg) {
		this.dateMajBudgProg = dateMajBudgProg;
	}

	public long getRefBudget() {
		return this.refBudget;
	}

	public void setRefBudget(long refBudget) {
		this.refBudget = refBudget;
	}

	public double getValeurMajBudgProg() {
		return this.valeurMajBudgProg;
	}

	public void setValeurMajBudgProg(double valeurMajBudgProg) {
		this.valeurMajBudgProg = valeurMajBudgProg;
	}

	public AvoirBudgProg getBudgetprojet() {
		return budgetprojet;
	}

	public void setBudgetprojet(AvoirBudgProg budgetprojet) {
		this.budgetprojet = budgetprojet;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MajBudgProg [idmajBudgPrg=" + idmajBudgPrg + ", dateMajBudgProg=" + dateMajBudgProg + ", refBudget="
				+ refBudget + ", valeurMajBudgProg=" + valeurMajBudgProg + ", budgetprojet=" + budgetprojet + ", etat="
				+ etat + "]";
	}



}