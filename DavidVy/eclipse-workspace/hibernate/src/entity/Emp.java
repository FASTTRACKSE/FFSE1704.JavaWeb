package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
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
	
	@Column(name = "idol", nullable = false)
	@NotEmpty
	String idol;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "city", nullable = false)
	int city;
	
	@Column(name = "image", nullable = false)
	String image;
	
	public Emp(int id, @NotEmpty String name, @NotEmpty String idol, int city, String image) {
		super();
		this.id = id;
		this.name = name;
		this.idol = idol;
		this.city = city;
		this.image = image;
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

	public String getIdol() {
		return idol;
	}

	public void setIdol(String idol) {
		this.idol = idol;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
