package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TAUX database table.
 * 
 */
@Entity
@NamedQuery(name="Taux.findAll", query="SELECT t FROM Taux t")
public class Taux implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAUX_IDTAUX_GENERATOR", sequenceName="AUTO_TAUX")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAUX_IDTAUX_GENERATOR")
	@Column(name="ID_TAUX")
	private long idTaux;

	@Column(name="CODE_TAUX")
	private String codeTaux;

	@Column(name="VAL_TAUX")
	private BigDecimal valTaux;

	//bi-directional many-to-one association to Groupe
	@OneToMany(mappedBy="taux")
	@JsonIgnore
	private List<Groupe> groupes;

	public Taux() {
	}

	public long getIdTaux() {
		return this.idTaux;
	}

	public void setIdTaux(long idTaux) {
		this.idTaux = idTaux;
	}

	public String getCodeTaux() {
		return this.codeTaux;
	}

	public void setCodeTaux(String codeTaux) {
		this.codeTaux = codeTaux;
	}

	public BigDecimal getValTaux() {
		return this.valTaux;
	}

	public void setValTaux(BigDecimal valTaux) {
		this.valTaux = valTaux;
	}

	public List<Groupe> getGroupes() {
		return this.groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe addGroupe(Groupe groupe) {
		getGroupes().add(groupe);
		groupe.setTaux(this);

		return groupe;
	}

	public Groupe removeGroupe(Groupe groupe) {
		getGroupes().remove(groupe);
		groupe.setTaux(null);

		return groupe;
	}

}