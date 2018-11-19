package com.javatpoint.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "emp")
public class Emp {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "name", nullable = false)
	@NotEmpty
	String name;

	@Column(name = "old", nullable = false)
	@NotEmpty
	String old;

	@Column(name = "idol", nullable = false)
	@NotEmpty
	String idol;

	@Column(name = "image", nullable = false)
	String image;

	@ManyToOne(optional = false)
	@JoinColumn(name = "region_id")
	City city;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emp")
	Set<MonHoc> listMonHoc = new HashSet<>();

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public Set<MonHoc> getListMonHoc() {
		return listMonHoc;
	}

	public void setListMonHoc(Set<MonHoc> listMonHoc) {
		this.listMonHoc = listMonHoc;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	public String getIdol() {
		return idol;
	}

	public void setIdol(String idol) {
		this.idol = idol;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Emp(int id, String name, String old, String idol, String image) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.idol = idol;
		this.image = image;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

}
