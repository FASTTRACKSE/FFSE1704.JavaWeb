package fasttrack.entity;

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
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "nametp", nullable = false)
	@NotEmpty
	String nametp;
	public int getId() {
		return id;
	}
	public void setId(int matp) {
		this.id = id;
	}
	public String getNametp() {
		return nametp;
	}
	public void setNametp(String nametp) {
		this.nametp = nametp;
	}
	

}