package fasttrackse.ffse1704.fbms.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "chuc_nang_phong_ban")
public class ChucNangPhongBan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "ma_phong_ban", nullable = false, length = 100)
	@NotEmpty
	private String maPhongBan;

	@Column(name = "ma_chuc_danh", nullable = false, length = 100)
	@NotEmpty
	private String maChucDanh;

	@Column(name = "ma_chuc_nang", nullable = false, length = 100)
	@NotEmpty
	private String maChucNang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getMaChucDanh() {
		return maChucDanh;
	}

	public void setMaChucDanh(String maChucDanh) {
		this.maChucDanh = maChucDanh;
	}

	public String getMaChucNang() {
		return maChucNang;
	}

	public void setMaChucNang(String maChucNang) {
		this.maChucNang = maChucNang;
	}

	public ChucNangPhongBan() {
		super();
	}

	public ChucNangPhongBan(int id, String maPhongBan, String maChucDanh, String maChucNang) {
		super();
		this.maPhongBan = maPhongBan;
		this.maChucDanh = maChucDanh;
		this.maChucNang = maChucNang;
	}

	public ChucNangPhongBan(String maPhongBan, String maChucDanh, String maChucNang) {
		super();
		this.maPhongBan = maPhongBan;
		this.maChucDanh = maChucDanh;
		this.maChucNang = maChucNang;
	}

}