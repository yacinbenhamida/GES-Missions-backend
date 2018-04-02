package com.rached.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the GROUPE database table.
 * 
 */
@Entity
@NamedQuery(name="Groupe.findAll", query="SELECT g FROM Groupe g")
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUPE_IDGROUPE_GENERATOR", sequenceName="AUTO_GROUPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUPE_IDGROUPE_GENERATOR")
	@Column(name="ID_GROUPE")
	private long idGroupe;

	@Column(name="CODE_GROUPE")
	private String codeGroupe;

	@Column(name="LIB_GROUPE_AR")
	private String libGroupeAr;

	@Column(name="LIB_GROUPE_FR")
	private String libGroupeFr;

	//bi-directional many-to-one association to Taux
	@ManyToOne
	@JoinColumn(name="ID_TAUX")
	private Taux taux;

	@OneToMany(mappedBy="groupe",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Missionaire> missionaires = new ArrayList<Missionaire>();
	
	public Groupe() {
	}

	public long getIdGroupe() {
		return this.idGroupe;
	}

	public void setIdGroupe(long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getCodeGroupe() {
		return this.codeGroupe;
	}

	public void setCodeGroupe(String codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public String getLibGroupeAr() {
		return this.libGroupeAr;
	}

	public void setLibGroupeAr(String libGroupeAr) {
		this.libGroupeAr = libGroupeAr;
	}

	public String getLibGroupeFr() {
		return this.libGroupeFr;
	}

	public void setLibGroupeFr(String libGroupeFr) {
		this.libGroupeFr = libGroupeFr;
	}

	public Taux getTaux() {
		return this.taux;
	}

	public void setTaux(Taux taux) {
		this.taux = taux;
	}

	public List<Missionaire> getMissionaires() {
		return missionaires;
	}

	public void setMissionaires(List<Missionaire> missionaires) {
		this.missionaires = missionaires;
	}
	
	public Missionaire addMissionaire(Missionaire missionaire) {
		getMissionaires().add(missionaire);
		missionaire.setGroupe(this);

		return missionaire;
	}

	public Missionaire removeMissionaire(Missionaire missionaire) {
		getMissionaires().remove(missionaire);
		missionaire.setGroupe(null);

		return missionaire;
	}

}