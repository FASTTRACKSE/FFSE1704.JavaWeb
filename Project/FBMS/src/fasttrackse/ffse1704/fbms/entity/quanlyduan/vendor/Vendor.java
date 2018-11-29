/**
 * 
 */
package fasttrackse.ffse1704.fbms.entity.quanlyduan.vendor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author The persistent class for the vendor database table.
 *
 */

@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_vendor", nullable = false, length = 30)
	@NotEmpty
	private String maVendor;

	@Column(name = "ten_vendor", nullable = false, length = 255)
	@NotEmpty
	private String tenVendor;

	@Column(name = "dia_chi", nullable = false, length = 255)
	@NotEmpty
	private String diaChi;

	@Column(name = "email", nullable = false, length = 500)
	@NotEmpty
	private String email;

	@Column(name = "so_dien_thoai", nullable = false, length = 11)
	@NotEmpty
	private int soDienThoai;

	@Column(name = "ghi_chu", nullable = true, length = 255)
	@NotEmpty
	private String ghiChu;

	public Vendor() {
		super();
	}

	public Vendor(int id, String maVendor, String tenVendor, String diaChi, String email, int soDienThoai,
			String ghiChu) {
		super();
		this.id = id;
		this.maVendor = maVendor;
		this.tenVendor = tenVendor;
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

	public String getMaVendor() {
		return maVendor;
	}

	public void setMaVendor(String maVendor) {
		this.maVendor = maVendor;
	}

	public String getTenVendor() {
		return tenVendor;
	}

	public void setTenVendor(String tenVendor) {
		this.tenVendor = tenVendor;
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
