package fasttrackse.ffse1704.fbms.entity.quanlyduan.phancongnhiemvu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.vaitrothanhvien.VaiTroThanhVien;

@Entity
@Table(name = "phan_cong_nhiem_vu")
public class PhanCongNhiemVu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_du_an", nullable = false, length = 30)
	@NotEmpty
	private String maDuAn;

	@Column(name = "ma_nhan_vien", nullable = false, length = 255)
	@NotEmpty
	private String maNhanVien;
	
	@OneToMany(mappedBy = "vaiTroThanhVien")
	private List<VaiTroThanhVien> listVaiTroThanhVien = new ArrayList<VaiTroThanhVien>();

	@Column(name = "ma_vai_tro", nullable = false, length = 255)
	@NotEmpty
	private String maVaiTro;

	
	@Column(name = "nhiem_vu", nullable = true, length = 255)
	@NotEmpty
	private String nhiemVu;

	public PhanCongNhiemVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhanCongNhiemVu(int id, @NotEmpty String maDuAn, @NotEmpty String maNhanVien, @NotEmpty String nhiemVu) {
		super();
		this.id = id;
		this.maDuAn = maDuAn;
		this.maNhanVien = maNhanVien;
		this.nhiemVu = nhiemVu;
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

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getNhiemVu() {
		return nhiemVu;
	}

	public void setNhiemVu(String nhiemVu) {
		this.nhiemVu = nhiemVu;
	}

}
