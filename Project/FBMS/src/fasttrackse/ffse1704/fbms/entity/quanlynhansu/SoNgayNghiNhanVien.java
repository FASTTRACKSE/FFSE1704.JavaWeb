package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "minhtq_so_ngay_nghi_nhan_vien")
public class SoNgayNghiNhanVien implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien",referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSu;
	
	@Column(name = "so_ngay_phep_nam", nullable = false, length = 50)
	private int soNgayPhepNam;
	
	@Column(name = "so_ngay_da_nghi", nullable = false, length = 50)
	private int soNgayDaNghi;
	
	@Column(name = "so_ngay_nghi_con_lai", nullable = false, length = 50)
	private int soNgayNghiConLai ;

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

	public int getSoNgayPhepNam() {
		return soNgayPhepNam;
	}

	public void setSoNgayPhepNam(int soNgayPhepNam) {
		this.soNgayPhepNam = soNgayPhepNam;
	}

	public int getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public int getSoNgayNghiConLai() {
		return soNgayNghiConLai;
	}

	public void setSoNgayNghiConLai(int soNgayNghiConLai) {
		this.soNgayNghiConLai = soNgayNghiConLai;
	}
	


}
