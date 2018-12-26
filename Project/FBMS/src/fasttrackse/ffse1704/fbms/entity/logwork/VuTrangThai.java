package fasttrackse.ffse1704.fbms.entity.logwork;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trang_thai")
public class VuTrangThai {
	@Id
	@Column(name = "id_trang_thai")
	int maTrangThai;
	
	@Column(name = "ten_trang_thai")
	String tenTrangThai;
	
	@OneToMany(mappedBy = "trangThaiLogwork")
	private Collection<ThoiGianLamViec> thoiGianLamViec;

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

	public Collection<ThoiGianLamViec> getThoiGianLamViec() {
		return thoiGianLamViec;
	}

	public void setThoiGianLamViec(Collection<ThoiGianLamViec> thoiGianLamViec) {
		this.thoiGianLamViec = thoiGianLamViec;
	}

}
