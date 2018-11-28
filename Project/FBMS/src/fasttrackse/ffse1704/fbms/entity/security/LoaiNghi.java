package fasttrackse.ffse1704.fbms.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="loainghiphep")
public class LoaiNghi {
	
	@Id
	@Column(name="idnghi")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idnghi;
	
	@Column(name="tenloainghi")
	public String tenloainghi;

	public int getIdnghi() {
		return idnghi;
	}

	public void setIdnghi(int idnghi) {
		this.idnghi = idnghi;
	}

	public String getTenloainghi() {
		return tenloainghi;
	}

	public void setTenloainghi(String tenloainghi) {
		this.tenloainghi = tenloainghi;
	}

}
