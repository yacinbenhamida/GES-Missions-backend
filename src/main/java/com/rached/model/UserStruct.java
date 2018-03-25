package com.rached.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USER_STRUCT database table.
 * 
 */
@Entity
@Table(name="USER_STRUCT")
@NamedQuery(name="UserStruct.findAll", query="SELECT u FROM UserStruct u")
public class UserStruct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_STRUCT_IDUSERSTRUCT_GENERATOR", sequenceName="JOINT_USER_STRUCT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_STRUCT_IDUSERSTRUCT_GENERATOR")
	@Column(name="ID_USER_STRUCT")
	private long idUserStruct;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_AFFECTATION")
	private Date dateAffectation;

	//bi-directional many-to-one association to Departement
	@ManyToOne
	@JoinColumn(name="CODE_DEPARTEMENT")
	private Departement departement;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
	private Utilisateur utilisateur;
	
	public UserStruct() {
	}


	public long getIdUserStruct() {
		return this.idUserStruct;
	}

	public void setIdUserStruct(long idUserStruct) {
		this.idUserStruct = idUserStruct;
	}

	public Date getDateAffectation() {
		return this.dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public Departement getDepartement() {
		return this.departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "UserStruct [idUserStruct=" + idUserStruct + ", dateAffectation=" + dateAffectation + ", departement="
				+ departement + ", utilisateur=" + utilisateur + "]";
	}

}