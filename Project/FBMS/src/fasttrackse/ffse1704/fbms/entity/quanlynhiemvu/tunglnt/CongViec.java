package fasttrackse.ffse1704.fbms.entity.quanlynhiemvu.tunglnt;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ffse1704_tunglnt_congviec")
public class CongViec {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "maduan")
	private String maduan;

	@Column(name = "tencongviec")
	private String tencongviec;

	@Column(name = "motacongviec")
	private String motacongviec;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "tgianbdau")
	private Date tgianbdau;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "tgiankthuc")
	private Date tgiankthuc;

	@Column(name = "phancongcho")
	private int phancongcho;

	@Column(name = "dukienhoanthanh")
	private String dukienhoanthanh;

	@Column(name = "trangthai")
	private int trangthai;

	public CongViec() {
		super();
	}

	public CongViec(int id, String maduan, String tencongviec, String motacongviec, Date tgianbdau, Date tgiankthuc,
			int phancongcho, String dukienhoanthanh, int trangthai) {
		super();
		this.id = id;
		this.maduan = maduan;
		this.tencongviec = tencongviec;
		this.motacongviec = motacongviec;
		this.tgianbdau = tgianbdau;
		this.tgiankthuc = tgiankthuc;
		this.phancongcho = phancongcho;
		this.dukienhoanthanh = dukienhoanthanh;
		this.trangthai = trangthai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaduan() {
		return maduan;
	}

	public void setMaduan(String maduan) {
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

	public int getPhancongcho() {
		return phancongcho;
	}

	public void setPhancongcho(int phancongcho) {
		this.phancongcho = phancongcho;
	}

	public String getDukienhoanthanh() {
		return dukienhoanthanh;
	}

	public void setDukienhoanthanh(String dukienhoanthanh) {
		this.dukienhoanthanh = dukienhoanthanh;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

}
