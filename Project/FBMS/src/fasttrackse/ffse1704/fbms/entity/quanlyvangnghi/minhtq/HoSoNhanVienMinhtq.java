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
@Table(name = "ho_so_nhan_su")
public class HoSoNhanVienMinhtq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_nhan_vien")
	private String maNhanVien;

	@Column(name = "ma_phong_ban")
	private String maPhongBan;

	@Column(name = "ma_chuc_danh")
	private String maChucDanh;

	@Column(name = "ho_dem")
	private String hoDem;

	@Column(name = "ten")
	private String ten;

	
	//liên kết với bảng đơn nghỉ phép
	@OneToMany(mappedBy = "hoSoNhanVien")
	private Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq;

	public HoSoNhanVienMinhtq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoSoNhanVienMinhtq(int id, String maNhanVien, String maPhongBan, String maChucDanh, String hoDem, String ten,
			Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.maPhongBan = maPhongBan;
		this.maChucDanh = maChucDanh;
		this.hoDem = hoDem;
		this.ten = ten;
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
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

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Collection<DonNghiPhepMinhtq> getDonNghiPhepMinhtq() {
		return donNghiPhepMinhtq;
	}

	public void setDonNghiPhepMinhtq(Collection<DonNghiPhepMinhtq> donNghiPhepMinhtq) {
		this.donNghiPhepMinhtq = donNghiPhepMinhtq;
	}

}
