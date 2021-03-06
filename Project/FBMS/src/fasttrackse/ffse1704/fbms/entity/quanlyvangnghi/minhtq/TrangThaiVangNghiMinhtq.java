package fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "minhtq_trang_thai")
public class TrangThaiVangNghiMinhtq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	
	@Column(name = "ma_trang_thai")
	String maTrangThai;

	@Column(name = "ten_trang_thai")
	String tenTrangThai;

	@OneToMany(mappedBy = "trangThaiDNP")
	private Collection<DonNghiPhepMinhtq> donNghiPhepMinhtqs;

	public TrangThaiVangNghiMinhtq() {
		super();
	}
	
	public TrangThaiVangNghiMinhtq(int id, String maTrangThai, String tenTrangThai,
			Collection<DonNghiPhepMinhtq> donNghiPhepMinhtqs) {
		super();
		this.id = id;
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = tenTrangThai;
		this.donNghiPhepMinhtqs = donNghiPhepMinhtqs;
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

	public Collection<DonNghiPhepMinhtq> getDonNghiPhepMinhtqs() {
		return donNghiPhepMinhtqs;
	}

	public void setDonNghiPhepMinhtqs(Collection<DonNghiPhepMinhtq> donNghiPhepMinhtqs) {
		this.donNghiPhepMinhtqs = donNghiPhepMinhtqs;
	}

}
