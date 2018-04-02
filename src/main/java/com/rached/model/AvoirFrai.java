package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the AVOIR_FRAIS database table.
 * 
 */
@Entity
@Table(name="AVOIR_FRAIS")
@NamedQuery(name="AvoirFrai.findAll", query="SELECT a FROM AvoirFrai a")
public class AvoirFrai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AVOIR_FRAIS_IDAVOIRFRAIS_GENERATOR", sequenceName="AVFRAIS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AVOIR_FRAIS_IDAVOIRFRAIS_GENERATOR")
	@Column(name="ID_AVOIRFRAIS")
	private long idAvoirfrais;
	
	@Column(name="CODE_PROG")
	private long codeProg;

	@Column(name="CODE_SUPPORT")
	private String codeSupport;

	@Column(name="OBSERVATION")
	private String observation;

	@Column(name="SUPPORT")
	private String support;

	@Column(name="VALEUR_PREVUE")
	private long valeurPrevue;

	@Column(name="NOM_ORG_AR")
	private String nomOrgAr;
	
	@Column(name="NOM_ORG_FR")
	private String nomOrgFr;
	//bi-directional many-to-one association to TypeFrai
	@ManyToOne
	@JoinColumn(name="IDTYPEFRAIS")
	private TypeFrai typeFrai;

	@ManyToOne
	@JoinColumn(name="ID_ORDREMISS")
	private OrdreMission ordreMission;
	
	public AvoirFrai() {
	}
	
	public long getIdAvoirfrais() {
		return this.idAvoirfrais;
	}

	public void setIdAvoirfrais(long idAvoirfrais) {
		this.idAvoirfrais = idAvoirfrais;
	}

	public long getCodeProg() {
		return this.codeProg;
	}

	public void setCodeProg(long codeProg) {
		this.codeProg = codeProg;
	}

	public String getCodeSupport() {
		return this.codeSupport;
	}

	public void setCodeSupport(String codeSupport) {
		this.codeSupport = codeSupport;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getSupport() {
		return this.support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public long getValeurPrevue() {
		return this.valeurPrevue;
	}

	public void setValeurPrevue(long valeurPrevue) {
		this.valeurPrevue = valeurPrevue;
	}


	public TypeFrai getTypeFrai() {
		return this.typeFrai;
	}

	public void setTypeFrai(TypeFrai typeFrai) {
		this.typeFrai = typeFrai;
	}

	

	public String getNomOrgAr() {
		return nomOrgAr;
	}

	public void setNomOrgAr(String nomOrgAr) {
		this.nomOrgAr = nomOrgAr;
	}

	public String getNomOrgFr() {
		return nomOrgFr;
	}

	public void setNomOrgFr(String nomOrgFr) {
		this.nomOrgFr = nomOrgFr;
	}

	public OrdreMission getOrdreMission() {
		return ordreMission;
	}

	public void setOrdreMission(OrdreMission ordreMission) {
		this.ordreMission = ordreMission;
	}

	@Override
	public String toString() {
		return "AvoirFrai [idAvoirfrais=" + idAvoirfrais + ", codeProg=" + codeProg + ", codeSupport=" + codeSupport
				+ ", observation=" + observation + ", support=" + support + ", valeurPrevue=" + valeurPrevue
				+ ", valeurReel="  + "ordre miss "+ ordreMission.getNumOrdre();
	}
	
}