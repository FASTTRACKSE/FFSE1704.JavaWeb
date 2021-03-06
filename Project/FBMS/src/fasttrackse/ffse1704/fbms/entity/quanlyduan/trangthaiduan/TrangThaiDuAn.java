/**
 * 
 */
package fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan;

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

import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;

/**
 * @author The persistent class for the trang_thai_du_an database table.
 *
 */

@Entity
@Table(name = "trang_thai_du_an")
public class TrangThaiDuAn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_trang_thai", nullable = false, length = 30)
	@NotEmpty
	private String maTrangThai;

	@Column(name = "ten_trang_thai", nullable = false, length = 255)
	@NotEmpty
	private String tenTrangThai;

	@Column(name = "ghi_chu", nullable = true, length = 500)
	private String ghiChu;

	// bi-directional many-to-one association to ThongTinDuAn
	@OneToMany(mappedBy = "trangThaiDuAn")
	private List<ThongTinDuAn> listDuAn = new ArrayList<ThongTinDuAn>();

	public TrangThaiDuAn() {
		super();
	}

	public TrangThaiDuAn(int id, @NotEmpty String maTrangThai, List<ThongTinDuAn> listDuAn,
			@NotEmpty String tenTrangThai, String ghiChu) {
		super();
		this.id = id;
		this.maTrangThai = maTrangThai;
		this.listDuAn = listDuAn;
		this.tenTrangThai = tenTrangThai;
		this.ghiChu = ghiChu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<ThongTinDuAn> getListDuAn() {
		return listDuAn;
	}

	public void setListDuAn(List<ThongTinDuAn> listDuAn) {
		this.listDuAn = listDuAn;
	}
}
