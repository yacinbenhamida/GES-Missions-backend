package com.rached.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the GRADE database table.
 * 
 */
@Entity
@Table(name="grade")
@NamedQuery(name="Grade.findAll", query="SELECT g FROM Grade g")
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRADE_IDGRADE_GENERATOR", sequenceName="GRADE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRADE_IDGRADE_GENERATOR")
	private long idgrade;

	@Column(name="LIB_GRADE_AR")
	private String libGradeAr;

	@Column(name="LIB_GRADE_FR")
	private String libGradeFr;
	
	@Column(name="CODE_GRADE")
	private int codeGrade;
	
	//bi-directional many-to-one association to Missionaire
	@OneToMany(mappedBy="grade")
	@JsonIgnore
	private List<Missionaire> missionaires;
		
	public Grade() {
	}

	public int getCodeGrade() {
		return codeGrade;
	}

	public void setCodeGrade(int codeGrade) {
		this.codeGrade = codeGrade;
	}

	public long getIdgrade() {
		return this.idgrade;
	}

	public void setIdgrade(long idgrade) {
		this.idgrade = idgrade;
	}

	public String getLibGradeAr() {
		return this.libGradeAr;
	}

	public void setLibGradeAr(String libGradeAr) {
		this.libGradeAr = libGradeAr;
	}

	public String getLibGradeFr() {
		return this.libGradeFr;
	}

	public void setLibGradeFr(String libGradeFr) {
		this.libGradeFr = libGradeFr;
	}

	public List<Missionaire> getMissionaires() {
		return missionaires;
	}

	public void setMissionaires(List<Missionaire> missionaires) {
		this.missionaires = missionaires;
	}
	
	public Missionaire addMissionaire(Missionaire missionaire) {
		getMissionaires().add(missionaire);
		missionaire.setGrade(this);

		return missionaire;
	}

	public Missionaire removeMissionaire(Missionaire missionaire) {
		getMissionaires().remove(missionaire);
		missionaire.setGrade(null);

		return missionaire;
	}

}