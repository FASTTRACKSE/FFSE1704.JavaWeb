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

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

@Entity
@Table(name = "phan_cong_nhiem_vu")
public class PhanCongNhiemVuNS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSu;
	
	@ManyToOne
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private QuanLyThongTinDuAnNS thongTinDuAn;
	
	@ManyToOne
	@JoinColumn(name = "ma_vai_tro", referencedColumnName = "ma_vai_tro", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private VaiTroThanhVienNS vaiTro;
	
	public VaiTroThanhVienNS getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(VaiTroThanhVienNS vaiTro) {
		this.vaiTro = vaiTro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public QuanLyThongTinDuAnNS getThongTinDuAn() {
		return thongTinDuAn;
	}

	public void setThongTinDuAn(QuanLyThongTinDuAnNS thongTinDuAn) {
		this.thongTinDuAn = thongTinDuAn;
	}

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}
}
