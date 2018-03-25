package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the UTILISATEUR database table.
 * 
 */
@Entity
@Table(name="Utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UTILISATEUR_CODEUTILISATEUR_GENERATOR", sequenceName="USER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTILISATEUR_CODEUTILISATEUR_GENERATOR")
	@Column(name="CODE_UTILISATEUR")
	private long codeUtilisateur;

	@Column(name="CODE_PROFILE")
	private String codeProfile;

	@Column(name="MOT_DE_PASSE")
	private String motDePasse;

	@Column(name="NOM_AR")
	private String nomAr;

	@Column(name="NOM_FR")
	private String nomFr;

	@Column(name="PRENOM_AR")
	private String prenomAr;

	@Column(name="PRENOM_FR")
	private String prenomFr;
	
	@Column(name="LOGIN")
	private long login;
	
	//bi-directional many-to-one association to UserStruct
	@OneToMany(mappedBy="utilisateur")
	@JsonIgnore
	private List<UserStruct> userStructs = new ArrayList<UserStruct>();

	public Utilisateur() {
	}

	public long getCodeUtilisateur() {
		return this.codeUtilisateur;
	}

	public void setCodeUtilisateur(long codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

	public String getCodeProfile() {
		return this.codeProfile;
	}

	public void setCodeProfile(String codeProfile) {
		this.codeProfile = codeProfile;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public List<UserStruct> getUserStructs() {
		return this.userStructs;
	}

	public void setUserStructs(List<UserStruct> userStructs) {
		this.userStructs = userStructs;
	}

	public UserStruct addUserStruct(UserStruct userStruct) {
		getUserStructs().add(userStruct);
		userStruct.setUtilisateur(this);

		return userStruct;
	}

	public UserStruct removeUserStruct(UserStruct userStruct) {
		getUserStructs().remove(userStruct);
		userStruct.setUtilisateur(null);

		return userStruct;
	}
	

	public long getLogin() {
		return login;
	}

	public void setLogin(long login) {
		this.login = login;
	}

	public Utilisateur( long login,String codeProfile, String motDePasse, String nomAr, String nomFr,
			String prenomAr, String prenomFr) {
		super();
		this.login = login;
		this.codeProfile = codeProfile;
		this.motDePasse = motDePasse;
		this.nomAr = nomAr;
		this.nomFr = nomFr;
		this.prenomAr = prenomAr;
		this.prenomFr = prenomFr;
	}

	@Override
	public String toString() {
		return "Utilisateur [codeUtilisateur=" + codeUtilisateur + ", codeProfile=" + codeProfile + ", motDePasse="
				+ motDePasse + ", nomAr=" + nomAr + ", nomFr=" + nomFr + ", prenomAr=" + prenomAr + ", prenomFr="
				+ prenomFr + ", login=" + login + "]";
	}

}