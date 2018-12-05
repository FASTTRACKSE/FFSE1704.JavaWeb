package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "ffse1704_tunglnt_congviec")
public class TunglntCongViec {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "maduan", referencedColumnName = "maduan")
	private TunglntDuAn maduan;

	@Column(name = "tencongviec")
	private String tencongviec;

	@Column(name = "motacongviec")
	private String motacongviec;

	@ManyToOne
	@JoinColumn(name = "id_congviec", referencedColumnName = "id_congviec")
	private TunglntLoaiCongViec macongviec;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "tgianbdau")
	private Date tgianbdau;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "tgiankthuc")
	private Date tgiankthuc;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien")
	private HoSoNhanVien ma_nhan_vien;

	@Column(name = "dukienhoanthanh")
	private String dukienhoanthanh;

	@ManyToOne
	@JoinColumn(name = "matrangthai", referencedColumnName = "matrangthai")
	private TunglntTrangThai matrangthai;

	public TunglntCongViec() {
		super();
	}

	public TunglntCongViec(int id, TunglntDuAn maduan, String tencongviec, String motacongviec,
			TunglntLoaiCongViec macongviec, Date tgianbdau, Date tgiankthuc, HoSoNhanVien ma_nhan_vien,
			String dukienhoanthanh, TunglntTrangThai matrangthai) {
		super();
		this.id = id;
		this.maduan = maduan;
		this.tencongviec = tencongviec;
		this.motacongviec = motacongviec;
		this.macongviec = macongviec;
		this.tgianbdau = tgianbdau;
		this.tgiankthuc = tgiankthuc;
		this.ma_nhan_vien = ma_nhan_vien;
		this.dukienhoanthanh = dukienhoanthanh;
		this.matrangthai = matrangthai;
	}

	public TunglntLoaiCongViec getMacongviec() {
		return macongviec;
	}

	public void setMacongviec(TunglntLoaiCongViec macongviec) {
		this.macongviec = macongviec;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TunglntDuAn getMaduan() {
		return maduan;
	}

	public void setMaduan(TunglntDuAn maduan) {
		this.maduan = maduan;
	}

	public String getTencongviec() {
		return tencongviec;
	}

	public void setTencongviec(String tencongviec) {
		this.tencongviec = tencongviec;
	}

	public String getMotacongviec() {
		return motacongviec;
	}

	public void setMotacongviec(String motacongviec) {
		this.motacongviec = motacongviec;
	}

	public Date getTgianbdau() {
		return tgianbdau;
	}

	public void setTgianbdau(Date tgianbdau) {
		this.tgianbdau = tgianbdau;
	}

	public Date getTgiankthuc() {
		return tgiankthuc;
	}

	public void setTgiankthuc(Date tgiankthuc) {
		this.tgiankthuc = tgiankthuc;
	}

	public HoSoNhanVien getMa_nhan_vien() {
		return ma_nhan_vien;
	}

	public void setMa_nhan_vien(HoSoNhanVien ma_nhan_vien) {
		this.ma_nhan_vien = ma_nhan_vien;
	}

	public String getDukienhoanthanh() {
		return dukienhoanthanh;
	}

	public void setDukienhoanthanh(String dukienhoanthanh) {
		this.dukienhoanthanh = dukienhoanthanh;
	}

	public TunglntTrangThai getMatrangthai() {
		return matrangthai;
	}

	public void setMatrangthai(TunglntTrangThai matrangthai) {
		this.matrangthai = matrangthai;
	}

}
