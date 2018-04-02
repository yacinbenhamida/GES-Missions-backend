package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the PAYS database table.
 * 
 */
@Entity
@NamedQuery(name="Pays.findAll", query="SELECT p FROM Pays p")
public class Pays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAYS_IDPAYS_GENERATOR", sequenceName="PAYS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYS_IDPAYS_GENERATOR")
	private long idpays;
	
	@Column(name="CODEPAYS")
	private BigDecimal codepays;
	
	@Column(name="LANGUE")
	private String langue;

	@Column(name="LIB_PAYS_AR")
	private String libPaysAr;

	@Column(name="LIB_PAYS_FR")
	private String libPaysFr;

	//bi-directional many-to-one association to Zonepay
	@ManyToOne
	@JoinColumn(name="CODE_ZONE")
	private Zonepays zonepays;

	@OneToMany(mappedBy="pays",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Concerne> concerne = new ArrayList<Concerne>();
	

	public long getIdpays() {
		return this.idpays;
	}

	public void setIdpays(long idpays) {
		this.idpays = idpays;
	}

	public BigDecimal getCodepays() {
		return this.codepays;
	}

	public void setCodepays(BigDecimal codepays) {
		this.codepays = codepays;
	}

	public String getLangue() {
		return this.langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getLibPaysAr() {
		return this.libPaysAr;
	}

	public void setLibPaysAr(String libPaysAr) {
		this.libPaysAr = libPaysAr;
	}

	public String getLibPaysFr() {
		return this.libPaysFr;
	}

	public void setLibPaysFr(String libPaysFr) {
		this.libPaysFr = libPaysFr;
	}

	public Zonepays getZonepays() {
		return this.zonepays;
	}

	public void setZonepays(Zonepays zonepay) {
		this.zonepays = zonepay;
	}

	public List<Concerne> getConcerne() {
		return concerne;
	}

	public void setConcerne(List<Concerne> concerne) {
		this.concerne = concerne;
	}
	public Concerne addConcerne(Concerne concerne) {
		getConcerne().add(concerne);
		concerne.setPays(this);

		return concerne;
	}

	public Concerne removeConcerne(Concerne concerne) {
		getConcerne().remove(concerne);
		concerne.setPays(null);

		return concerne;
	}

	

	@Override
	public String toString() {
		return "Pays [idpays=" + idpays + ", codepays=" + codepays + ", langue=" + langue + ", libPaysAr=" + libPaysAr
				+ ", libPaysFr=" + libPaysFr + ", zonepays=" + zonepays + ", concerne=" + concerne + ", paysfrai="
				 + "]";
	}
	
}