package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AFFECT_MISS_DEP database table.
 * 
 */
@Entity
@Table(name="AFFECT_MISS_DEP")
@NamedQuery(name="AffectMissDep.findAll", query="SELECT a FROM AffectMissDep a")
public class AffectMissDep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AFFECT_MISS_DEP_IDAFFECTATION_GENERATOR", sequenceName="AFFECT_MISS_DEP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AFFECT_MISS_DEP_IDAFFECTATION_GENERATOR")
	@Column(name="ID_AFFECTATION")
	private long idAffectation;
	
	
	@ManyToOne
	@JoinColumn(name="CODE_DEP")
	private Departement departement;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_AFFECTATION")
	private Date dateAffectation;

	//bi-directional many-to-one association to Missionaire
	@ManyToOne
	@JoinColumn(name="ID_MISSIONAIRE")
	private Missionaire missionaire;

	public AffectMissDep() {
	}

	public long getIdAffectation() {
		return this.idAffectation;
	}

	public void setIdAffectation(long idAffectation) {
		this.idAffectation = idAffectation;
	}

	
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Date getDateAffectation() {
		return this.dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public Missionaire getMissionaire() {
		return this.missionaire;
	}

	public void setMissionaire(Missionaire missionaire) {
		this.missionaire = missionaire;
	}

}