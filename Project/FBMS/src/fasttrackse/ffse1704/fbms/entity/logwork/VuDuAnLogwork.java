package fasttrackse.ffse1704.fbms.entity.logwork;

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
public class VuDuAnLogwork {
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
	private Collection<ThoiGianLamViec> thoiGianLamViec;

	public Collection<ThoiGianLamViec> getThoiGianLamViec() {
		return thoiGianLamViec;
	}

	public void setThoiGianLamViec(Collection<ThoiGianLamViec> thoiGianLamViec) {
		this.thoiGianLamViec = thoiGianLamViec;
	}

}
