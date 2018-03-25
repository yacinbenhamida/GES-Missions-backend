package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONCERNE database table.
 * 
 */
@Entity
@NamedQuery(name="Concerne.findAll", query="SELECT c FROM Concerne c")
public class Concerne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONCERNE_IDCONCERNE_GENERATOR", sequenceName="CONCERNE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCERNE_IDCONCERNE_GENERATOR")
	private long idconcerne;

	@Column(name="FRAIS_DIVERS")
	private long fraisDivers;

	@Column(name="FRAIS_MISSION")
	private long fraisMission;

	@Column(name="FRAIS_TRANSPORT")
	private long fraisTransport;

	@Column(name="MOY_TRANSPORT")
	private String moyTransport;

	@Column(name="NB_JOURS_P")
	private long nbJoursP;

	@Column(name="NB_JOURS_R")
	private long nbJoursR;
	
	@Column(name="VILLE")
	private String ville;
	
	@ManyToOne
	@JoinColumn(name="ID_ORDRE")
	private OrdreMission ordre;
	@ManyToOne
	@JoinColumn(name="IDPAYS")
	private Pays pays;
	
	public Concerne() {
	}

	public long getIdconcerne() {
		return this.idconcerne;
	}

	public void setIdconcerne(long idconcerne) {
		this.idconcerne = idconcerne;
	}

	public long getFraisDivers() {
		return this.fraisDivers;
	}

	public void setFraisDivers(long fraisDivers) {
		this.fraisDivers = fraisDivers;
	}

	public long getFraisMission() {
		return this.fraisMission;
	}

	public void setFraisMission(long fraisMission) {
		this.fraisMission = fraisMission;
	}

	public long getFraisTransport() {
		return this.fraisTransport;
	}

	public void setFraisTransport(long fraisTransport) {
		this.fraisTransport = fraisTransport;
	}

	

	public String getMoyTransport() {
		return this.moyTransport;
	}

	public void setMoyTransport(String moyTransport) {
		this.moyTransport = moyTransport;
	}

	public long getNbJoursP() {
		return this.nbJoursP;
	}

	public void setNbJoursP(long nbJoursP) {
		this.nbJoursP = nbJoursP;
	}

	public long getNbJoursR() {
		return this.nbJoursR;
	}

	public void setNbJoursR(long nbJoursR) {
		this.nbJoursR = nbJoursR;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public OrdreMission getOrdre() {
		return ordre;
	}

	public void setOrdre(OrdreMission ordre) {
		this.ordre = ordre;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	
	

}