package fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvienduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvien.NhanVien;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;
import fasttrackse.ffse1704.fbms.entity.quanlyduan.vaitrothanhvien.VaiTroThanhVien;

@Entity
@Table(name = "nhan_vien_du_an")
public class NhanVienDuAn {
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

	@Column(name = "ma_vai_tro", nullable = false, length = 30)
	@NotEmpty
	private String maVaiTro;

	@ManyToOne
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private ThongTinDuAn thongTinDuAn;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name = "ma_vai_tro", referencedColumnName = "ma_vai_tro", insertable = false, updatable = false, nullable = false)
	@NotEmpty
	private VaiTroThanhVien vaiTroThanhVien;

	public NhanVienDuAn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVienDuAn(int id, @NotEmpty String maDuAn, @NotEmpty String maNhanVien, @NotEmpty String maVaiTro,
			@NotEmpty ThongTinDuAn thongTinDuAn, @NotEmpty NhanVien nhanVien,
			@NotEmpty VaiTroThanhVien vaiTroThanhVien) {
		super();
		this.id = id;
		this.maDuAn = maDuAn;
		this.maNhanVien = maNhanVien;
		this.maVaiTro = maVaiTro;
		this.thongTinDuAn = thongTinDuAn;
		this.nhanVien = nhanVien;
		this.vaiTroThanhVien = vaiTroThanhVien;
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

	public String getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public ThongTinDuAn getThongTinDuAn() {
		return thongTinDuAn;
	}

	public void setThongTinDuAn(ThongTinDuAn thongTinDuAn) {
		this.thongTinDuAn = thongTinDuAn;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public VaiTroThanhVien getVaiTroThanhVien() {
		return vaiTroThanhVien;
	}

	public void setVaiTroThanhVien(VaiTroThanhVien vaiTroThanhVien) {
		this.vaiTroThanhVien = vaiTroThanhVien;
	}

}
