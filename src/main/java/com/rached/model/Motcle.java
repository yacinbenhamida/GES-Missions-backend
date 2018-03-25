package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MOTCLES database table.
 * 
 */
@Entity
@Table(name="MOTCLES")
@NamedQuery(name="Motcle.findAll", query="SELECT m FROM Motcle m")
public class Motcle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOTCLES_IDMOTCLE_GENERATOR", sequenceName="MOTCLES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOTCLES_IDMOTCLE_GENERATOR")
	@Column(name="IDMOT_CLE")
	private long idmotCle;

	@Column(name="CODE_MOT_CLE")
	private BigDecimal codeMotCle;

	@Column(name="LIB_MC_AR")
	private String libMcAr;

	@Column(name="LIB_MC_FR")
	private String libMcFr;

	//bi-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="CODETHEME")
	private Theme theme;

	public Motcle() {
	}

	public long getIdmotCle() {
		return this.idmotCle;
	}

	public void setIdmotCle(long idmotCle) {
		this.idmotCle = idmotCle;
	}

	public BigDecimal getCodeMotCle() {
		return this.codeMotCle;
	}

	public void setCodeMotCle(BigDecimal codeMotCle) {
		this.codeMotCle = codeMotCle;
	}

	public String getLibMcAr() {
		return this.libMcAr;
	}

	public void setLibMcAr(String libMcAr) {
		this.libMcAr = libMcAr;
	}

	public String getLibMcFr() {
		return this.libMcFr;
	}

	public void setLibMcFr(String libMcFr) {
		this.libMcFr = libMcFr;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Motcle [idmotCle=" + idmotCle + ", codeMotCle=" + codeMotCle + ", libMcAr=" + libMcAr + ", libMcFr="
				+ libMcFr + ", theme=" + theme + "]";
	}

}