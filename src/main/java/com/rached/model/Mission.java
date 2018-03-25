package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MISSION database table.
 * 
 */
@Entity
@NamedQuery(name="Mission.findAll", query="SELECT m FROM Mission m")
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MISSION_IDMISSION_GENERATOR", sequenceName="MISSION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MISSION_IDMISSION_GENERATOR")
	@Column(name="ID_MISSION")
	private long idMission;
	
	@ManyToOne
	@JoinColumn(name="CODE_DEP")
	private Departement departement;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ARRIVE_P")
	private Date dateArriveP;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEPART_P")
	private Date dateDepartP;

	@ManyToOne
	@JoinColumn(name="IDTHEME")
	private Theme theme;

	@Column(name="NUM_MISSION")
	private long numMission;

	@Column(name="OBJECTIF_MISSION_AR")
	private String objectifMissionAr;

	@Column(name="OBJECTIF_MISSION_FR")
	private String objectifMissionFr;

	@OneToMany(mappedBy="mission",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<OrdreMission> ordresMission = new ArrayList<OrdreMission>();
	
	public Mission() {
	}

	public long getIdMission() {
		return this.idMission;
	}

	public void setIdMission(long idMission) {
		this.idMission = idMission;
	}


	public Date getDateArriveP() {
		return this.dateArriveP;
	}

	public void setDateArriveP(Date dateArriveP) {
		this.dateArriveP = dateArriveP;
	}

	public Date getDateDepartP() {
		return this.dateDepartP;
	}

	public void setDateDepartP(Date dateDepartP) {
		this.dateDepartP = dateDepartP;
	}


	public long getNumMission() {
		return this.numMission;
	}

	public void setNumMission(long numMission) {
		this.numMission = numMission;
	}

	public String getObjectifMissionAr() {
		return this.objectifMissionAr;
	}

	public void setObjectifMissionAr(String objectifMissionAr) {
		this.objectifMissionAr = objectifMissionAr;
	}

	public String getObjectifMissionFr() {
		return this.objectifMissionFr;
	}

	public void setObjectifMissionFr(String objectifMissionFr) {
		this.objectifMissionFr = objectifMissionFr;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<OrdreMission> getOrdresMission() {
		return ordresMission;
	}

	public void setOrdresMission(List<OrdreMission> ordresMission) {
		this.ordresMission = ordresMission;
	}
	public OrdreMission addOrdreMission(OrdreMission ordre) {
		getOrdresMission().add(ordre);
		ordre.setMission(this);

		return ordre;
	}

	public OrdreMission removeOrdreMission(OrdreMission ordresMission) {
		getOrdresMission().remove(ordresMission);
		ordresMission.setMission(null);

		return ordresMission;
	}
	

}