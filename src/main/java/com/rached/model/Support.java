package com.rached.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the SUPPORT database table.
 * 
 */
@Entity
@NamedQuery(name="Support.findAll", query="SELECT s FROM Support s")
public class Support implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE_SUPPORT")
	private String codeSupport;
	
	@Column(name="SIGNIFICATION")
	private String signification;
	//bi-directional many-to-one association to Missionaire
	@OneToMany(mappedBy="support")
	@JsonIgnore
	private List<AvoirFrai> frais;
	public Support() {
	}

	public String getCodeSupport() {
		return this.codeSupport;
	}

	public void setCodeSupport(String codeSupport) {
		this.codeSupport = codeSupport;
	}

	public String getSignification() {
		return this.signification;
	}

	public void setSignification(String signification) {
		this.signification = signification;
	}

	public List<AvoirFrai> getFrais() {
		return frais;
	}

	public void setFrais(List<AvoirFrai> frais) {
		this.frais = frais;
	}
	public AvoirFrai addFrais(AvoirFrai frais) {
		getFrais().add(frais);
		frais.setSupport(this);
		return frais;
	}

	public AvoirFrai removeOrdreMission(AvoirFrai frais) {
		getFrais().remove(frais);
		frais.setSupport(null);
		return frais;
	}

	@Override
	public String toString() {
		return "Support [codeSupport=" + codeSupport + ", signification=" + signification + "]";
	}
	
}