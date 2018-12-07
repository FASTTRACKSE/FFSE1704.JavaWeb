package fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quan_ly_thong_tin_du_an")
public class ListTenDuAn {
	@Id
	@Column(name = "ma_du_an")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String maDuAn;

	@Column(name = "ten_du_an")
	String tenDuAn;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "duAn")
	private Collection<ThongTinLogwork> thongTinLogworks;

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public Collection<ThongTinLogwork> getThongTinLogworks() {
		return thongTinLogworks;
	}

	public void setThongTinLogworks(Collection<ThongTinLogwork> thongTinLogworks) {
		this.thongTinLogworks = thongTinLogworks;
	}

}
