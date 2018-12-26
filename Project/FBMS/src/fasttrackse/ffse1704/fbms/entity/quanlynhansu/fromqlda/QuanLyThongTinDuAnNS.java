package fasttrackse.ffse1704.fbms.entity.quanlynhansu.fromqlda;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "quan_ly_thong_tin_du_an")
public class QuanLyThongTinDuAnNS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_du_an")
	@NotEmpty
	private String maDuAn;

	@Column(name = "ten_du_an", nullable = false, length = 255)
	@NotEmpty
	private String tenDuAn;
	
	@ManyToOne
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private TrangThaiDuAnNS trangThaiDuAnNS;
	
	@OneToMany(mappedBy = "thongTinDuAn", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PhanCongNhiemVuNS> listPhanCongNhiemVu;

	public TrangThaiDuAnNS getTrangThaiDuAnNS() {
		return trangThaiDuAnNS;
	}

	public void setTrangThaiDuAnNS(TrangThaiDuAnNS trangThaiDuAnNS) {
		this.trangThaiDuAnNS = trangThaiDuAnNS;
	}

	public List<PhanCongNhiemVuNS> getListPhanCongNhiemVu() {
		return listPhanCongNhiemVu;
	}

	public void setListPhanCongNhiemVu(List<PhanCongNhiemVuNS> listPhanCongNhiemVu) {
		this.listPhanCongNhiemVu = listPhanCongNhiemVu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


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
}
