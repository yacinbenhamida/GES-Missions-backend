package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ORDRE_MISSION database table.
 * 
 */
@Entity
@Table(name="ORDRE_MISSION")
@NamedQuery(name="OrdreMission.findAll", query="SELECT o FROM OrdreMission o")
public class OrdreMission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDRE_MISSION_IDORDRE_GENERATOR", sequenceName="ORDREMISS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDRE_MISSION_IDORDRE_GENERATOR")
	@Column(name="ID_ORDRE")
	private long idOrdre;
	
	@Column(name="AVANCE")
	private long avance;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ARR_P")
	private Date dateArrP;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ARR_R")
	private Date dateArrR;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEP_P")
	private Date dateDepP;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEP_R")
	private Date dateDepR;

	@Column(name="ETAT")
	private String etat;
	
	@ManyToOne
	@JoinColumn(name="ID_MISSION")
	private Mission mission;
	
	@ManyToOne
	@JoinColumn(name="ID_MISSIONAIRE")
	private Missionaire missionaire;

	@OneToMany(mappedBy="ordre",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Concerne> concerne = new ArrayList<Concerne>();
	
	@Column(name="NUM_ORDRE")
	private long numOrdre;

	private long timbre;

	public OrdreMission() {
	}

	public long getIdOrdre() {
		return this.idOrdre;
	}

	public void setIdOrdre(long idOrdre) {
		this.idOrdre = idOrdre;
	}

	public long getAvance() {
		return this.avance;
	}

	public void setAvance(long avance) {
		this.avance = avance;
	}

	public Date getDateArrP() {
		return this.dateArrP;
	}

	public void setDateArrP(Date dateArrP) {
		this.dateArrP = dateArrP;
	}

	public Date getDateArrR() {
		return this.dateArrR;
	}

	public void setDateArrR(Date dateArrR) {
		this.dateArrR = dateArrR;
	}

	public Date getDateDepP() {
		return this.dateDepP;
	}

	public void setDateDepP(Date dateDepP) {
		this.dateDepP = dateDepP;
	}

	public Date getDateDepR() {
		return this.dateDepR;
	}

	public void setDateDepR(Date dateDepR) {
		this.dateDepR = dateDepR;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Missionaire getMissionaire() {
		return missionaire;
	}

	public void setMissionaire(Missionaire missionaire) {
		this.missionaire = missionaire;
	}

	public long getNumOrdre() {
		return this.numOrdre;
	}

	public void setNumOrdre(long numOrdre) {
		this.numOrdre = numOrdre;
	}

	public long getTimbre() {
		return this.timbre;
	}

	public void setTimbre(long timbre) {
		this.timbre = timbre;
	}

	public List<Concerne> getConcerne() {
		return concerne;
	}

	public void setConcerne(List<Concerne> concerne) {
		this.concerne = concerne;
	}
	
	public Concerne addConcerne(Concerne concerne) {
		getConcerne().add(concerne);
		concerne.setOrdre(this);

		return concerne;
	}

	public Concerne removeConcerne(Concerne concerne) {
		getConcerne().remove(concerne);
		concerne.setOrdre(null);

		return concerne;
	}

	@Override
	public String toString() {
		return "OrdreMission [idOrdre=" + idOrdre + ", avance=" + avance + ", dateArrP=" + dateArrP + ", dateArrR="
				+ dateArrR + ", dateDepP=" + dateDepP + ", dateDepR=" + dateDepR + ", etat=" + etat + ", mission="
				+ mission + ", missionaire=" + missionaire + ", numOrdre=" + numOrdre + ", timbre=" + timbre + "]";
	}

}