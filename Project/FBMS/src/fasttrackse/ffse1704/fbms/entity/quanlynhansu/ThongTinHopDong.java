package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Entity
@Table(name = "thong_tin_hop_dong")
public class ThongTinHopDong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private int id;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien", insertable = false, updatable = false, nullable = false)
	private NhanSu nhanSu;

	@ManyToOne
	@JoinColumn(name = "ma_hop_dong",referencedColumnName = "ma_hop_dong", nullable = false)
	@NotNull
	private HopDong loaihopDong;

	@Column(name = "ngay_bat_dau", nullable = false)
	private Date ngayBatDau;

	@Column(name = "ngay_ket_thuc", nullable = false)
	private Date ngayKetThuc;

	
	@ManyToOne
	@JoinColumn(name = "luong_thang_13",referencedColumnName = "id", nullable = false)
	private CheDoHuong cheDoHuong;

	public ThongTinHopDong() {
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

	public HopDong getLoaihopDong() {
		return loaihopDong;
	}

	public void setLoaihopDong(HopDong loaihopDong) {
		this.loaihopDong = loaihopDong;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public CheDoHuong getCheDoHuong() {
		return cheDoHuong;
	}

	public void setCheDoHuong(CheDoHuong cheDoHuong) {
		this.cheDoHuong = cheDoHuong;
	}


}
