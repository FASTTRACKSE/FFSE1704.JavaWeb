package fasttrackse.ffse1704.fbms.entity.quanlynhansu.fromqlda;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
	
	@Column(name = "ma_du_an", unique = true, length = 11)
	@NotEmpty
	private String maDuAn;
	
	@Column(name = "ma_nhan_vien", unique = true, length = 11)
	@NotEmpty
	private String maNhanVien;
	
	
	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	@ManyToOne
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private QuanLyThongTinDuAnNS thongTinDuAn;
	
	@ManyToOne
	@JoinColumn(name = "ma_vai_tro", referencedColumnName = "ma_vai_tro", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private VaiTroThanhVienNS vaiTro;
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSuFindByMaDuAn;
	
	public NhanSu getNhanSuFindByMaDuAn() {
		return nhanSuFindByMaDuAn;
	}

	public void setNhanSuFindByMaDuAn(NhanSu nhanSuFindByMaDuAn) {
		this.nhanSuFindByMaDuAn = nhanSuFindByMaDuAn;
	}

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
