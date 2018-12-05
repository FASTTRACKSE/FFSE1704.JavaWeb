package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "chung_chi")
public class ChungChi {

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSu;

	@Column(name = "ten_chung_chi", nullable = false, length = 255)
	@NotNull
	private String tenChungChi;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_cap", nullable = false)
	private Date ngayCap;

	@Column(name = "don_vi_cap", nullable = false, length = 255)
	@NotNull
	private String donViCap;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTenChungChi() {
		return tenChungChi;
	}

	public void setTenChungChi(String tenChungChi) {
		this.tenChungChi = tenChungChi;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getDonViCap() {
		return donViCap;
	}

	public void setDonViCap(String donViCap) {
		this.donViCap = donViCap;
	}

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	public ChungChi() {
	}

}
