package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the THEME database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="THEME_IDTHEME_GENERATOR", sequenceName="THEME_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="THEME_IDTHEME_GENERATOR")
	private long idtheme;
	
	@Column(name="CODETHEME")
	private BigDecimal codetheme;

	@Column(name="LIB_THEME_AR")
	private String libThemeAr;

	@Column(name="LIB_THEME_FR")
	private String libThemeFr;

	//bi-directional many-to-one association to Motcle
	@OneToMany(mappedBy="theme")
	@JsonIgnore
	private List<Motcle> motcles;

	//bi-directional many-to-one association to Mission
	@OneToMany(mappedBy="theme")
	@JsonIgnore
	private List<Mission> missions;

	
	public Theme() {
	}

	public long getIdtheme() {
		return this.idtheme;
	}

	public void setIdtheme(long idtheme) {
		this.idtheme = idtheme;
	}

	public BigDecimal getCodetheme() {
		return this.codetheme;
	}

	public void setCodetheme(BigDecimal codetheme) {
		this.codetheme = codetheme;
	}

	public String getLibThemeAr() {
		return this.libThemeAr;
	}

	public void setLibThemeAr(String libThemeAr) {
		this.libThemeAr = libThemeAr;
	}

	public String getLibThemeFr() {
		return this.libThemeFr;
	}

	public void setLibThemeFr(String libThemeFr) {
		this.libThemeFr = libThemeFr;
	}

	public List<Motcle> getMotcles() {
		return this.motcles;
	}

	public void setMotcles(List<Motcle> motcles) {
		this.motcles = motcles;
	}

	public Motcle addMotcle(Motcle motcle) {
		getMotcles().add(motcle);
		motcle.setTheme(this);

		return motcle;
	}

	public Motcle removeMotcle(Motcle motcle) {
		getMotcles().remove(motcle);
		motcle.setTheme(null);

		return motcle;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	
	public Mission addMission(Mission mission) {
		getMissions().add(mission);
		mission.setTheme(this);

		return mission;
	}

	public Mission removeMission(Mission mission) {
		getMissions().remove(mission);
		mission.setTheme(null);

		return mission;
	}

}