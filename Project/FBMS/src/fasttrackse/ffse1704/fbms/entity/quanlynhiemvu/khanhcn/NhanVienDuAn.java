package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.khanhcn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "phan_cong_nhiem_vu")
public class NhanVienDuAn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_du_an", nullable = false, length = 30)
	@NotEmpty
	private String maDuAn;

	/*
	 * @Column(name = "ma_nhan_vien", nullable = false, length = 255)
	 * 
	 * @NotEmpty private String maNhanVien;
	 */
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", nullable = false, referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false)
	private NhanVienKhanhCN nhanVienKhanhCN;

	@Column(name = "ma_nhan_vien", nullable = false, length = 30)
	@NotEmpty
	private String maNhanVien;

	@Column(name = "ma_vai_tro", nullable = false, length = 30)
	@NotEmpty
	private String maVaiTro;

	@OneToMany(mappedBy = "nhanVienDuAn")
	private List<CongViecKhanhCN> congViecKhanhCN = new ArrayList<CongViecKhanhCN>();

	public NhanVienDuAn() {
		super();
		// TODO Auto-generated constructor stub
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

	public NhanVienKhanhCN getNhanVienKhanhCN() {
		return nhanVienKhanhCN;
	}

	public void setNhanVienKhanhCN(NhanVienKhanhCN nhanVienKhanhCN) {
		this.nhanVienKhanhCN = nhanVienKhanhCN;
	}

	public String getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public List<CongViecKhanhCN> getCongViecKhanhCN() {
		return congViecKhanhCN;
	}

	public void setCongViecKhanhCN(List<CongViecKhanhCN> congViecKhanhCN) {
		this.congViecKhanhCN = congViecKhanhCN;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
