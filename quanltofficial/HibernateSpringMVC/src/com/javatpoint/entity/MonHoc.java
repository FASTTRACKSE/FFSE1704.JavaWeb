package com.javatpoint.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="empmh")
public class MonHoc {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int region_id;

	@Column(name = "idemp", nullable = false)
	@NotEmpty
	String idemp;

	@Column(name = "mamh", nullable = false)
	@NotEmpty
	String mamh;

	@Column(name = "diem", nullable = false)
	@NotEmpty
	String diem;

	@ManyToOne
	@JoinColumn(name = "idemp", nullable = false, insertable=false, updatable=false)	
	Emp emp;

	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public MonHoc(int region_id, String idemp, String mamh, String diem) {
		super();
		this.region_id = region_id;
		this.idemp = idemp;
		this.mamh = mamh;
		this.diem = diem;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public String getIdemp() {
		return idemp;
	}

	public void setIdemp(String idemp) {
		this.idemp = idemp;
	}

	public String getMamh() {
		return mamh;
	}

	public void setMamh(String mamh) {
		this.mamh = mamh;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}
}
