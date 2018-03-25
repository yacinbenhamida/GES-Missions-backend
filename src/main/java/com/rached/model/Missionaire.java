package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MISSIONAIRE database table.
 * 
 */
@Entity
@NamedQuery(name="Missionaire.findAll", query="SELECT m FROM Missionaire m")
public class Missionaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MISSIONAIRE_IDMISSIONAIRE_GENERATOR", sequenceName="MISSIONAIRE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MISSIONAIRE_IDMISSIONAIRE_GENERATOR")
	@Column(name="ID_MISSIONAIRE")
	private long idMissionaire;
	
	@Column(name="CIN")
	private long cin;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CIN")
	private Date dateCin;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_NAISSANCE")
	private Date dateNaissance;


	@ManyToOne
	@JoinColumn(name="idgrade")
	private Grade grade;

	@ManyToOne
	@JoinColumn(name="idclasse")
	private Classe classe;

	@ManyToOne
	@JoinColumn(name="idfct")
	private Fonction fonction;

	@ManyToOne
	@JoinColumn(name="idcat")
	private Categorie categorie;

	@Column(name="LIEU_NAISSANCE_AR")
	private String lieuNaissanceAr;

	@Column(name="LIEU_NAISSANCE_FR")
	private String lieuNaissanceFr;

	private String matricule;

	@Column(name="NATIONALITE_AR")
	private String nationaliteAr;

	@Column(name="NATIONALITE_FR")
	private String nationaliteFr;

	@Column(name="NOM_AR")
	private String nomAr;

	@Column(name="NOM_FR")
	private String nomFr;

	@Column(name="PRENOM_AR")
	private String prenomAr;

	@Column(name="PRENOM_FR")
	private String prenomFr;

	//bi-directional many-to-one association to AffectMissDep
	@OneToMany(mappedBy="missionaire")
	@JsonIgnore
	private List<AffectMissDep> affectMissDeps;


	@OneToMany(mappedBy="missionaire",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<OrdreMission> ordresMission = new ArrayList<OrdreMission>();
	
	public Missionaire() {
	}

	public long getIdMissionaire() {
		return this.idMissionaire;
	}

	public void setIdMissionaire(long idMissionaire) {
		this.idMissionaire = idMissionaire;
	}

	public long getCin() {
		return this.cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public Date getDateCin() {
		return this.dateCin;
	}

	public void setDateCin(Date dateCin) {
		this.dateCin = dateCin;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getLieuNaissanceAr() {
		return this.lieuNaissanceAr;
	}

	public void setLieuNaissanceAr(String lieuNaissanceAr) {
		this.lieuNaissanceAr = lieuNaissanceAr;
	}

	public String getLieuNaissanceFr() {
		return this.lieuNaissanceFr;
	}

	public void setLieuNaissanceFr(String lieuNaissanceFr) {
		this.lieuNaissanceFr = lieuNaissanceFr;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNationaliteAr() {
		return this.nationaliteAr;
	}

	public void setNationaliteAr(String nationaliteAr) {
		this.nationaliteAr = nationaliteAr;
	}

	public String getNationaliteFr() {
		return this.nationaliteFr;
	}

	public void setNationaliteFr(String nationaliteFr) {
		this.nationaliteFr = nationaliteFr;
	}

	public String getNomAr() {
		return this.nomAr;
	}

	public void setNomAr(String nomAr) {
		this.nomAr = nomAr;
	}

	public String getNomFr() {
		return this.nomFr;
	}

	public void setNomFr(String nomFr) {
		this.nomFr = nomFr;
	}

	public String getPrenomAr() {
		return this.prenomAr;
	}

	public void setPrenomAr(String prenomAr) {
		this.prenomAr = prenomAr;
	}

	public String getPrenomFr() {
		return this.prenomFr;
	}

	public void setPrenomFr(String prenomFr) {
		this.prenomFr = prenomFr;
	}

	public List<AffectMissDep> getAffectMissDeps() {
		return this.affectMissDeps;
	}

	public void setAffectMissDeps(List<AffectMissDep> affectMissDeps) {
		this.affectMissDeps = affectMissDeps;
	}

	public AffectMissDep addAffectMissDep(AffectMissDep affectMissDep) {
		getAffectMissDeps().add(affectMissDep);
		affectMissDep.setMissionaire(this);

		return affectMissDep;
	}

	public AffectMissDep removeAffectMissDep(AffectMissDep affectMissDep) {
		getAffectMissDeps().remove(affectMissDep);
		affectMissDep.setMissionaire(null);

		return affectMissDep;
	}

	
	
	public List<OrdreMission> getOrdresMission() {
		return ordresMission;
	}

	public void setOrdresMission(List<OrdreMission> ordresMission) {
		this.ordresMission = ordresMission;
	}

	public OrdreMission addOrdreMission(OrdreMission ordre) {
		getOrdresMission().add(ordre);
		ordre.setMissionaire(this);

		return ordre;
	}

	public OrdreMission removeOrdreMission(OrdreMission ordresMission) {
		getOrdresMission().remove(ordresMission);
		ordresMission.setMissionaire(null);

		return ordresMission;
	}
	
	@Override
	public String toString() {
		return "Missionaire [idMissionaire=" + idMissionaire + ", cin=" + cin + ", dateCin=" + dateCin
				+ ", dateNaissance=" + dateNaissance + ", grade=" + grade + ", classe=" + classe + ", fonction="
				+ fonction + ", categorie=" + categorie + ", lieuNaissanceAr=" + lieuNaissanceAr + ", lieuNaissanceFr="
				+ lieuNaissanceFr + ", matricule=" + matricule + ", nationaliteAr=" + nationaliteAr + ", nationaliteFr="
				+ nationaliteFr + ", nomAr=" + nomAr + ", nomFr=" + nomFr + ", prenomAr=" + prenomAr + ", prenomFr="
				+ prenomFr + "]";
	}

}