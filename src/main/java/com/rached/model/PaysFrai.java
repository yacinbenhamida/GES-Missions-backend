package com.rached.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PAYS_FRAIS database table.
 * 
 */
@Entity
@Table(name="PAYS_FRAIS")
@NamedQuery(name="PaysFrai.findAll", query="SELECT p FROM PaysFrai p")
public class PaysFrai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAYS_FRAIS_IDPAYSFRAIS_GENERATOR", sequenceName="PAYSFRAIS_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYS_FRAIS_IDPAYSFRAIS_GENERATOR")
	@Column(name="ID_PAYS_FRAIS")
	private long idPaysFrais;

	@ManyToOne
	@JoinColumn(name="ID_AVOIRFRAIS")
	private AvoirFrai avoirfrais;

	@ManyToOne
	@JoinColumn(name="IDPAYS")
	private Pays pays;

	public PaysFrai() {
	}

	public long getIdPaysFrais() {
		return this.idPaysFrais;
	}

	public void setIdPaysFrais(long idPaysFrais) {
		this.idPaysFrais = idPaysFrais;
	}

	public AvoirFrai getAvoirfrais() {
		return avoirfrais;
	}

	public void setAvoirfrais(AvoirFrai avoirfrais) {
		this.avoirfrais = avoirfrais;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	

}