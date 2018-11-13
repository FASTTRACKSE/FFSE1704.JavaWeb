package com.javatpoint.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "vietnam")
public class City {

	@Id
	@Column(name = "region_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int region_id;
	@Column(name = "region_name", nullable = false)
	@NotEmpty
	String region_name;
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public City(int region_id, @NotEmpty String region_name) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
	}
	
	
}
