package com.rached.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the TYPE_DEP database table.
 * 
 */
@Entity
@Table(name="TYPE_DEP")
@NamedQuery(name="TypeDep.findAll", query="SELECT t FROM TypeDep t")
public class TypeDep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idtypedep;

	@Column(name="LIB_TYPE_DEP_AR")
	private String libTypeDepAr;

	@Column(name="LIB_TYPE_DEP_FR")
	private String libTypeDepFr;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy="typedep")
	@JsonIgnore
	private List<Departement> departements = new ArrayList<Departement>();
	
	public TypeDep() {
	}

	public long getIdtypedep() {
		return this.idtypedep;
	}

	public void setIdtypedep(long idtypedep) {
		this.idtypedep = idtypedep;
	}

	public String getLibTypeDepAr() {
		return this.libTypeDepAr;
	}

	public void setLibTypeDepAr(String libTypeDepAr) {
		this.libTypeDepAr = libTypeDepAr;
	}

	public String getLibTypeDepFr() {
		return this.libTypeDepFr;
	}

	public void setLibTypeDepFr(String libTypeDepFr) {
		this.libTypeDepFr = libTypeDepFr;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public Departement addDepartement(Departement dep) {
		getDepartements().add(dep);
		dep.setTypedep(this);

		return dep;
	}

	public Departement removeDepartement(Departement dep) {
		getDepartements().remove(dep);
		dep.setTypedep(null);
		return dep;
	}
}