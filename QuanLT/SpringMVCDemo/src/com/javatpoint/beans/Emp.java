package com.javatpoint.beans;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
public class Emp {
	private int id;
	
	@NotNull(message= "Tên không được để trống")
	private String name;
	
	@NotNull(message= "Tuổi không được để trống")
	@Range(min=18, max=60, message= "Tuổi từ 18-60")
	
	private int old;
	
	private String idol;
	private String description;
	private String image;
	private int city;
	private String namecity;
	
	

	
	public Emp(int id, String name, int old, String idol, String description, String image, int city, String namecity) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.idol = idol;
		this.description = description;
		this.image = image;
		this.city = city;
		this.namecity = namecity;
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




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
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




	public String getNamecity() {
		return namecity;
	}




	public void setNamecity(String namecity) {
		this.namecity = namecity;
	}




	public Emp() {
		// TODO Auto-generated constructor stub
	}
    
    // Upload files.
    
}
