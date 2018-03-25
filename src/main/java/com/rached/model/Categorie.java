package com.rached.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the CATEGORIE database table.
 * 
 */
@Entity
@Table(name="categorie")
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIE_IDCAT_GENERATOR", sequenceName="CAT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIE_IDCAT_GENERATOR")
	private long idcat;

	@Column(name="LIB_CAT_AR")
	private String libCatAr;

	@Column(name="LIB_CAT_FR")
	private String libCatFr;
	@Column(name="CODE_CAT")
	private int codeCat;
	
	//bi-directional many-to-one association to Missionaire
	@OneToMany(mappedBy="categorie")
	@JsonIgnore
	private List<Missionaire> missionaires;
	
	public Categorie() {
	}

	public int getCodeCat() {
		return codeCat;
	}

	public void setCodeCat(int codeCat) {
		this.codeCat = codeCat;
	}

	public long getIdcat() {
		return this.idcat;
	}

	public void setIdcat(long idcat) {
		this.idcat = idcat;
	}

	public String getLibCatAr() {
		return this.libCatAr;
	}

	public void setLibCatAr(String libCatAr) {
		this.libCatAr = libCatAr;
	}

	public String getLibCatFr() {
		return this.libCatFr;
	}

	public void setLibCatFr(String libCatFr) {
		this.libCatFr = libCatFr;
	}

	public List<Missionaire> getMissionaires() {
		return missionaires;
	}

	public void setMissionaires(List<Missionaire> missionaires) {
		this.missionaires = missionaires;
	}
	public Missionaire addMissionaire(Missionaire missionaire) {
		getMissionaires().add(missionaire);
		missionaire.setCategorie(this);

		return missionaire;
	}

	public Missionaire removeMissionaire(Missionaire missionaire) {
		getMissionaires().remove(missionaire);
		missionaire.setCategorie(null);

		return missionaire;
	}
}