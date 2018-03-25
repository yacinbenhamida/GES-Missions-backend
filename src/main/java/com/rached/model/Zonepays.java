package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ZONEPAYS database table.
 * 
 */
@Entity
@Table(name="ZONEPAYS")
@NamedQuery(name="Zonepay.findAll", query="SELECT z FROM Zonepays z")
public class Zonepays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ZONEPAYS_IDZONE_GENERATOR", sequenceName="ZONE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ZONEPAYS_IDZONE_GENERATOR")
	@Column(name="ID_ZONE")
	private long idZone;

	@Column(name="CODE_ZONE")
	private BigDecimal codeZone;

	@Column(name="LIB_ZONE_AR")
	private String libZoneAr;

	@Column(name="LIB_ZONE_FR")
	private String libZoneFr;

	//bi-directional many-to-one association to Pays
	@OneToMany(mappedBy="zonepays")
	@JsonIgnore
	private List<Pays> pays;

	public Zonepays() {
	}

	public long getIdZone() {
		return this.idZone;
	}

	public void setIdZone(long idZone) {
		this.idZone = idZone;
	}

	public BigDecimal getCodeZone() {
		return this.codeZone;
	}

	public void setCodeZone(BigDecimal codeZone) {
		this.codeZone = codeZone;
	}

	public String getLibZoneAr() {
		return this.libZoneAr;
	}

	public void setLibZoneAr(String libZoneAr) {
		this.libZoneAr = libZoneAr;
	}

	public String getLibZoneFr() {
		return this.libZoneFr;
	}

	public void setLibZoneFr(String libZoneFr) {
		this.libZoneFr = libZoneFr;
	}

	public List<Pays> getPays() {
		return this.pays;
	}

	public void setPays(List<Pays> pays) {
		this.pays = pays;
	}

	public Pays addPay(Pays pay) {
		getPays().add(pay);
		pay.setZonepays(this);

		return pay;
	}

	public Pays removePay(Pays pay) {
		getPays().remove(pay);
		pay.setZonepays(null);

		return pay;
	}

}