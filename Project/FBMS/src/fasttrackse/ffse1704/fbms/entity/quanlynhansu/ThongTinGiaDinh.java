package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "thong_tin_gia_dinh")
public class ThongTinGiaDinh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien",referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSu;

	@Column(name = "ho_va_ten", nullable = false, length = 255)
	private String hoVaTen;

	@Column(name = "quan_he", nullable = false, length = 10)
	private String quanHe;

	@Column(name = "nam_sinh", nullable = false)
	private Date namSinh;

	@Column(name = "nghe_nghiep", nullable = false, length = 50)
	private String ngheNghiep;

	@Column(name = "dia_chi", nullable = false, length = 255)
	private String diaChi;

	public ThongTinGiaDinh(int id, NhanSu nhanSu, String hoVaTen, String quanHe, Date namSinh, String ngheNghiep,
			String diaChi) {
		super();
		this.id = id;
		this.nhanSu = nhanSu;
		this.hoVaTen = hoVaTen;
		this.quanHe = quanHe;
		this.namSinh = namSinh;
		this.ngheNghiep = ngheNghiep;
		this.diaChi = diaChi;
	}

	public ThongTinGiaDinh() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getQuanHe() {
		return quanHe;
	}

	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

}
