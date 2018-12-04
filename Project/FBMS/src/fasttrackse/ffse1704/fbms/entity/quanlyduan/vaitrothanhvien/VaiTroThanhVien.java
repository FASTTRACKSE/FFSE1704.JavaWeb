package fasttrackse.ffse1704.fbms.entity.quanlyduan.vaitrothanhvien;

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

import fasttrackse.ffse1704.fbms.entity.quanlyduan.nhanvienduan.NhanVienDuAn;

@Entity
@Table(name = "vai_tro_thanh_vien")
public class VaiTroThanhVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_vai_tro", nullable = false, length = 30)
	@NotEmpty
	private String maVaiTro;

	@Column(name = "ten_vai_tro", nullable = false, length = 255)
	@NotEmpty
	private String tenVaiTro;

	@Column(name = "ghi_chu", nullable = true, length = 500)
	@NotEmpty
	private String ghiChu;

	// bi-directional many-to-one association to ThongTinDuAn
	@OneToMany(mappedBy = "vaiTroThanhVien")
	private List<NhanVienDuAn> nhanVienDuAn = new ArrayList<NhanVienDuAn>();

	public VaiTroThanhVien() {
		super();
	}

	
	public VaiTroThanhVien(int id, @NotEmpty String maVaiTro, @NotEmpty String tenVaiTro, @NotEmpty String ghiChu,
			List<NhanVienDuAn> nhanVienDuAn) {
		super();
		this.id = id;
		this.maVaiTro = maVaiTro;
		this.tenVaiTro = tenVaiTro;
		this.ghiChu = ghiChu;
		this.nhanVienDuAn = nhanVienDuAn;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(String maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	public List<NhanVienDuAn> getNhanVienDuAn() {
		return nhanVienDuAn;
	}


	public void setNhanVienDuAn(List<NhanVienDuAn> nhanVienDuAn) {
		this.nhanVienDuAn = nhanVienDuAn;
	}

}
