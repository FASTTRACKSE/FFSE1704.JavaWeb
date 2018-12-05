package fasttrackse.ffse1704.fbms.entity.quanlythoigian;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "qltg_trang_thai")
public class TrangThaiLogwork {
	@Id
	@Column(name = "id_trang_thai")
	int maTrangThai;
	
	@Column(name = "ten_trang_thai")
	String tenTrangThai;
	
	@OneToMany(mappedBy = "trangThaiLogwork")
	private Collection<Logwork> logworks;

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public Collection<Logwork> getLogworks() {
		return logworks;
	}

	public void setLogworks(Collection<Logwork> logworks) {
		this.logworks = logworks;
	}
}
