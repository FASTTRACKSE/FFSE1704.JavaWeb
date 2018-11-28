/**
 * 
 */
package fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author The persistent class for the khach_hang database table.
 *
 */

@Entity
@Table(name = "khach_hang")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_khach_hang", nullable = false, length = 30)
	@NotEmpty
	private String maKhachHang;

	@Column(name = "ten_khach_hang", nullable = false, length = 255)
	@NotEmpty
	private String tenKhachHang;

	@Column(name = "dia_chi", nullable = false, length = 255)
	@NotEmpty
	private String diaChi;

	@Column(name = "email", nullable = false, length = 255)
	@NotEmpty
	private String email;

	@Column(name = "so_dien_thoai", nullable = false, length = 11)
	@NotEmpty
	private int soDienThoai;

	@Column(name = "ghi_chu", nullable = true, length = 255)
	@NotEmpty
	private String ghiChu;

	public KhachHang() {
		super();
	}

	public KhachHang(int id, String maKhachHang, String tenKhachHang, String diaChi, String email, int soDienThoai,
			String ghiChu) {
		super();
		this.id = id;
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.email = email;
		this.ghiChu = ghiChu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
