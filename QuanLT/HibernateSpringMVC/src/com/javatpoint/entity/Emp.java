package com.javatpoint.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "emp")
public class Emp implements Serializable{
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
	
	@Column(name = "city", nullable = false)
	int city;

	public Emp(int id, @NotEmpty String name, @NotEmpty String old, @NotEmpty String idol, String image, int city) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.idol = idol;
		this.image = image;
		this.city = city;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
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

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	

	
	
}
