package com.rached.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the FONCTION database table.
 * 
 */
@Entity
@Table(name="fonction")
@NamedQuery(name="Fonction.findAll", query="SELECT f FROM Fonction f")
public class Fonction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FONCTION_IDFCT_GENERATOR", sequenceName="FONCT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FONCTION_IDFCT_GENERATOR")
	private long idfct;

	@Column(name="LIB_FCT_AR")
	private String libFctAr;

	@Column(name="LIB_FCT_FR")
	private String libFctFr;

	@Column(name="CODE_FONCTION")
	private int codeFonction;

	//bi-directional many-to-one association to Missionaire
	@OneToMany(mappedBy="fonction")
	@JsonIgnore
	private List<Missionaire> missionaires;	
	
	public Fonction() {
	}

	public long getIdfct() {
		return this.idfct;
	}

	public void setIdfct(long idfct) {
		this.idfct = idfct;
	}

	public String getLibFctAr() {
		return this.libFctAr;
	}

	public void setLibFctAr(String libFctAr) {
		this.libFctAr = libFctAr;
	}

	public String getLibFctFr() {
		return this.libFctFr;
	}

	public void setLibFctFr(String libFctFr) {
		this.libFctFr = libFctFr;
	}

	public int getCodeFonction() {
		return codeFonction;
	}

	public void setCodeFonction(int codeFonction) {
		this.codeFonction = codeFonction;
	}

	public List<Missionaire> getMissionaires() {
		return missionaires;
	}

	public void setMissionaires(List<Missionaire> missionaires) {
		this.missionaires = missionaires;
	}
	public Missionaire addMissionaire(Missionaire missionaire) {
		getMissionaires().add(missionaire);
		missionaire.setFonction(this);

		return missionaire;
	}

	public Missionaire removeMissionaire(Missionaire missionaire) {
		getMissionaires().remove(missionaire);
		missionaire.setFonction(null);

		return missionaire;
	}


}