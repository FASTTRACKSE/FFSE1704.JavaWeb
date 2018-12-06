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
@Table(name = "trang_thai_logwork")
public class TrangThaiThongTinLogwork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trang_thai", unique = true, length = 11)
	private int idTrangThai;

	@Column(name = "ten_trang_thai", nullable = true, length = 11)
	private String tenTrangThai;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trangThai")
	private Collection<ThongTinLogwork> logwork;

	public int getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(int idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public Collection<ThongTinLogwork> getLogwork() {
		return logwork;
	}

	public void setLogwork(Collection<ThongTinLogwork> logwork) {
		this.logwork = logwork;
	}

	
}
