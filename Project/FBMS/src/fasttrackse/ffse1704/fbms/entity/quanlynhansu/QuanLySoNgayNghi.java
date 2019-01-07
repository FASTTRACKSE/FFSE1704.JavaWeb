package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quan_ly_so_ngay_nghi")
public class QuanLySoNgayNghi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;
	
	@Column(name = "ma_nhan_vien")
	private String maNhanVien;
	
	@Column(name = "ma_ngay_nghi", length = 50)
	private String maNgayNghi;
	
	@ManyToOne
	@JoinColumn(name = "ma_ngay_nghi", referencedColumnName = "ma_ngay_nghi", nullable = false, updatable = false, insertable= false)
	private DanhSachNgayNghi danhSachNgayNghi;
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", nullable = false, updatable = false, insertable= false)
	private NhanSu nhanSu;
	
	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	@Column(name = "tong_ngay_duoc_nghi", nullable = false, length = 50)
	private int tongSoNgayDuocNghi;
	
	@Column(name = "so_ngay_da_nghi", nullable = false, length = 50)
	private int soNgayDaNghi;

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

	public String getMaNgayNghi() {
		return maNgayNghi;
	}

	public void setMaNgayNghi(String maNgayNghi) {
		this.maNgayNghi = maNgayNghi;
	}

	public DanhSachNgayNghi getDanhSachNgayNghi() {
		return danhSachNgayNghi;
	}

	public void setDanhSachNgayNghi(DanhSachNgayNghi danhSachNgayNghi) {
		this.danhSachNgayNghi = danhSachNgayNghi;
	}

	public int getTongSoNgayDuocNghi() {
		return tongSoNgayDuocNghi;
	}

	public void setTongSoNgayDuocNghi(int tongSoNgayDuocNghi) {
		this.tongSoNgayDuocNghi = tongSoNgayDuocNghi;
	}

	public int getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public QuanLySoNgayNghi( String maNhanVien, String maNgayNghi,
			 int tongSoNgayDuocNghi, int soNgayDaNghi) {
		super();
		this.maNhanVien = maNhanVien;
		this.maNgayNghi = maNgayNghi;
		this.tongSoNgayDuocNghi = tongSoNgayDuocNghi;
		this.soNgayDaNghi = soNgayDaNghi;
	}
	
	public QuanLySoNgayNghi() {
		
	}
	

}
