package com.rached.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the CLASSE database table.
 * 
 */
@Entity
@Table(name="classe")
@NamedQuery(name="Classe.findAll", query="SELECT c FROM Classe c")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLASSE_IDCLASSE_GENERATOR", sequenceName="CLASSE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASSE_IDCLASSE_GENERATOR")
	private long idclasse;

	@Column(name="LIB_CLASSE_AR")
	private String libClasseAr;

	@Column(name="LIB_CLASSE_FR")
	private String libClasseFr;

	@Column(name="CODE_CLASSE")
	private int codeClasse;
	
	//bi-directional many-to-one association to Missionaire
	@OneToMany(mappedBy="classe")
	@JsonIgnore
	private List<Missionaire> missionaires;
		
	public Classe() {
	}

	
	public int getCodeClasse() {
		return codeClasse;
	}


	public void setCodeClasse(int codeClasse) {
		this.codeClasse = codeClasse;
	}


	public long getIdclasse() {
		return this.idclasse;
	}

	public void setIdclasse(long idclasse) {
		this.idclasse = idclasse;
	}

	public String getLibClasseAr() {
		return this.libClasseAr;
	}

	public void setLibClasseAr(String libClasseAr) {
		this.libClasseAr = libClasseAr;
	}

	public String getLibClasseFr() {
		return this.libClasseFr;
	}

	public void setLibClasseFr(String libClasseFr) {
		this.libClasseFr = libClasseFr;
	}


	public List<Missionaire> getMissionaires() {
		return missionaires;
	}


	public void setMissionaires(List<Missionaire> missionaires) {
		this.missionaires = missionaires;
	}
	public Missionaire addMissionaire(Missionaire missionaire) {
		getMissionaires().add(missionaire);
		missionaire.setClasse(this);

		return missionaire;
	}

	public Missionaire removeMissionaire(Missionaire missionaire) {
		getMissionaires().remove(missionaire);
		missionaire.setClasse(null);

		return missionaire;
	}
}