package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

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


	@Column(name="FRAIS_MISSION")
	private double fraisMission;


	@Column(name="MOY_TRANSPORT")
	private String moyTransport;

	@Column(name="NB_JOURS_P")
	private long nbJoursP;

	
	@Column(name="VILLE")
	private String ville;
	
	@Column(name="ORDRE_DEST")
	private int ordre_dest;
	
	@ManyToOne
	@JoinColumn(name="ID_ORDRE")
	private OrdreMission ordre;
	@ManyToOne
	@JoinColumn(name="IDPAYS")
	private Pays pays;
	
	@Column(name="nbjours_pec_dep")
	private long nbJoursPecDep;
	
	@Column(name="nbjours_pec_orget")
	private long nbJoursPecOrget;
	
	@Column(name="nbjours_pec_proj")
	private long nbJoursPecProj;
	public Concerne() {
	}

	public long getIdconcerne() {
		return this.idconcerne;
	}

	public void setIdconcerne(long idconcerne) {
		this.idconcerne = idconcerne;
	}

	

	public double getFraisMission() {
		return this.fraisMission;
	}

	public void setFraisMission(double fraisMission) {
		this.fraisMission = fraisMission;
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

	public int getOrdre_dest() {
		return ordre_dest;
	}

	public void setOrdre_dest(int ordre_dest) {
		this.ordre_dest = ordre_dest;
	}

	public long getNbJoursPecDep() {
		return nbJoursPecDep;
	}

	public void setNbJoursPecDep(long nbJoursPecDep) {
		this.nbJoursPecDep = nbJoursPecDep;
	}

	public long getNbJoursPecOrget() {
		return nbJoursPecOrget;
	}

	public void setNbJoursPecOrget(long nbJoursPecOrget) {
		this.nbJoursPecOrget = nbJoursPecOrget;
	}

	public long getNbJoursPecProj() {
		return nbJoursPecProj;
	}

	public void setNbJoursPecProj(long nbJoursPecProj) {
		this.nbJoursPecProj = nbJoursPecProj;
	}

	
	
	
	

}