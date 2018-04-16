package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;



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
	@ManyToOne
	@JoinColumn(name="CODE_PROG")
	private Projet projet;

	@Column(name="CODE_SUPPORT")
	private String codeSupport;

	@Column(name="OBSERVATION")
	private String observation;

	@Column(name="VALEUR_PREVUE")
	private double valeurPrevue;

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
	
	@ManyToOne
	@JoinColumn(name="SUPPORT")
	private Support support;
	
	
	public AvoirFrai() {
	}
	
	public long getIdAvoirfrais() {
		return this.idAvoirfrais;
	}

	public void setIdAvoirfrais(long idAvoirfrais) {
		this.idAvoirfrais = idAvoirfrais;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
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

	public Support getSupport() {
		return this.support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public double getValeurPrevue() {
		return this.valeurPrevue;
	}

	public void setValeurPrevue(double valeurPrevue) {
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
		return "AvoirFrai [idAvoirfrais=" + idAvoirfrais + ", codeProg=" + projet.getLibProjAr() + ", codeSupport=" + codeSupport
				+ ", observation=" + observation + ", support=" + support + ", valeurPrevue=" + valeurPrevue
				+ ", valeurReel="  + "ordre miss "+ ordreMission.getNumOrdre();
	}
	
}