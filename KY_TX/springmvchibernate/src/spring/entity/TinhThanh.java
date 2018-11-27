package spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "tinhthanh")
public class TinhThanh {
	@Id
	@Column(name = "matp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int matp;
	@Column(name = "nametp", nullable = false)
	@NotEmpty
	String nametp;
	public int getMatp() {
		return matp;
	}
	public void setMatp(int matp) {
		this.matp = matp;
	}
	public String getNametp() {
		return nametp;
	}
	public void setNametp(String nametp) {
		this.nametp = nametp;
	}
	

}
