package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quan_ly_thong_tin_du_an")
public class DuAnLogwork {
	@Id
	@Column(name = "ma_du_an")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String maDAn;
	
	@Column(name= "ten_du_an")
	String tenDuAn;

	public String getMaDAn() {
		return maDAn;
	}

	public void setMaDAn(String maDAn) {
		this.maDAn = maDAn;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}
	@OneToMany(mappedBy = "maDuAn")
	private Collection<Logwork> logworks;

	public Collection<Logwork> getLogworks() {
		return logworks;
	}

	public void setLogworks(Collection<Logwork> logworks) {
		this.logworks = logworks;
	}
}
