package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the AVOIR_FRAIS database table.
 * 
 */
@Entity
@Table(name="AVOIR_FRAIS")
@NamedQuery(name="AvoirFrai.findAll", query="SELECT a FROM AvoirFrai a")
public class AvoirFrai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AVOIR_FRAIS_IDAVOIRFRAIS_GENERATOR", sequenceName="AVFRAIS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AVOIR_FRAIS_IDAVOIRFRAIS_GENERATOR")
	@Column(name="ID_AVOIRFRAIS")
	private long idAvoirfrais;
	
	@Column(name="CODE_PROG")
	private long codeProg;

	@Column(name="CODE_SUPPORT")
	private long codeSupport;

	@Column(name="OBSERVATION")
	private String observation;

	@Column(name="SUPPORT")
	private String support;

	@Column(name="VALEUR_PREVUE")
	private long valeurPrevue;

	@Column(name="VALEUR_REEL")
	private long valeurReel;

	//bi-directional many-to-one association to TypeFrai
	@ManyToOne
	@JoinColumn(name="IDTYPEFRAIS")
	private TypeFrai typeFrai;

	@OneToMany(mappedBy="avoirfrais",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<PaysFrai> paysfrai = new ArrayList<PaysFrai>();
	
	public AvoirFrai() {
	}

	public long getIdAvoirfrais() {
		return this.idAvoirfrais;
	}

	public void setIdAvoirfrais(long idAvoirfrais) {
		this.idAvoirfrais = idAvoirfrais;
	}

	public long getCodeProg() {
		return this.codeProg;
	}

	public void setCodeProg(long codeProg) {
		this.codeProg = codeProg;
	}

	public long getCodeSupport() {
		return this.codeSupport;
	}

	public void setCodeSupport(long codeSupport) {
		this.codeSupport = codeSupport;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getSupport() {
		return this.support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public long getValeurPrevue() {
		return this.valeurPrevue;
	}

	public void setValeurPrevue(long valeurPrevue) {
		this.valeurPrevue = valeurPrevue;
	}

	public long getValeurReel() {
		return this.valeurReel;
	}

	public void setValeurReel(long valeurReel) {
		this.valeurReel = valeurReel;
	}

	public TypeFrai getTypeFrai() {
		return this.typeFrai;
	}

	public void setTypeFrai(TypeFrai typeFrai) {
		this.typeFrai = typeFrai;
	}

	public List<PaysFrai> getPaysfrai() {
		return paysfrai;
	}

	public void setPaysfrai(List<PaysFrai> paysfrai) {
		this.paysfrai = paysfrai;
	}
	
	

	public PaysFrai addPaysFrai(PaysFrai frais) {
		getPaysfrai().add(frais);
		frais.setAvoirfrais(this);

		return frais;
	}

	public PaysFrai removePaysFrai(PaysFrai frais) {
		getPaysfrai().remove(frais);
		frais.setAvoirfrais(null);

		return frais;
	}

	@Override
	public String toString() {
		return "AvoirFrai [idAvoirfrais=" + idAvoirfrais + ", codeProg=" + codeProg + ", codeSupport=" + codeSupport
				+ ", observation=" + observation + ", support=" + support + ", valeurPrevue=" + valeurPrevue
				+ ", valeurReel=" + valeurReel ;
	}
	
}