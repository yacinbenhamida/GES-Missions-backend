package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the TYPE_FRAIS database table.
 * 
 */
@Entity
@Table(name="TYPE_FRAIS")
@NamedQuery(name="TypeFrai.findAll", query="SELECT t FROM TypeFrai t")
public class TypeFrai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TYPE_FRAIS_IDTYPEFRAIS_GENERATOR", sequenceName="TYPEFRAIS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPE_FRAIS_IDTYPEFRAIS_GENERATOR")
	private long idtypefrais;

	@Column(name="CODE_TYPEFR")
	private String codeTypefr;

	@Column(name="LIB_TYPE_FRAIS_AR")
	private String libTypeFraisAr;

	@Column(name="LIB_TYPE_FRAIS_FR")
	private String libTypeFraisFr;

	//bi-directional many-to-one association to AvoirFrai
	@OneToMany(mappedBy="typeFrai")
	@JsonIgnore
	private List<AvoirFrai> avoirFrais;

	public TypeFrai() {
	}

	public long getIdtypefrais() {
		return this.idtypefrais;
	}

	public void setIdtypefrais(long idtypefrais) {
		this.idtypefrais = idtypefrais;
	}

	public String getCodeTypefr() {
		return this.codeTypefr;
	}

	public void setCodeTypefr(String codeTypefr) {
		this.codeTypefr = codeTypefr;
	}

	public String getLibTypeFraisAr() {
		return this.libTypeFraisAr;
	}

	public void setLibTypeFraisAr(String libTypeFraisAr) {
		this.libTypeFraisAr = libTypeFraisAr;
	}

	public String getLibTypeFraisFr() {
		return this.libTypeFraisFr;
	}

	public void setLibTypeFraisFr(String libTypeFraisFr) {
		this.libTypeFraisFr = libTypeFraisFr;
	}

	public List<AvoirFrai> getAvoirFrais() {
		return this.avoirFrais;
	}

	public void setAvoirFrais(List<AvoirFrai> avoirFrais) {
		this.avoirFrais = avoirFrais;
	}

	public AvoirFrai addAvoirFrai(AvoirFrai avoirFrai) {
		getAvoirFrais().add(avoirFrai);
		avoirFrai.setTypeFrai(this);

		return avoirFrai;
	}

	public AvoirFrai removeAvoirFrai(AvoirFrai avoirFrai) {
		getAvoirFrais().remove(avoirFrai);
		avoirFrai.setTypeFrai(null);

		return avoirFrai;
	}

}