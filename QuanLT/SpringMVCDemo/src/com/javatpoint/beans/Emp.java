package com.javatpoint.beans;

public class Emp {
	private int id;
	private String name;
	private int old;
	private String idol;
	
	public Emp(int id, String name, int old, String idol) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.idol = idol;
	}
	public Emp() {
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
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	public String getIdol() {
		return idol;
	}
	public void setIdol(String idol) {
		this.idol = idol;
	}
	
}
