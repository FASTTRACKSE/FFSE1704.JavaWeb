package fasttrackse.ffse1704.fbms.entity.DoanhntQLTL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fasttrackse.ffse1704.fbms.entity.DoanhntQLTL.Icon;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Entity
@Table(name = "tai_lieu")
public class TaiLieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tai_lieu")
	Integer idTL;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Ma_Danh_Muc", nullable = false)
	@NotNull
	DanhMuc danhMuc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_trang_thai", nullable = false)
	@NotNull
	TrangThaiTaiLieu trangThai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	@NotNull
	PhongBan phongBan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_icon", nullable = false)
	@NotNull
	Icon icon;

	@Column(name = "ma_tai_lieu")
	String maTL;

	@Column(name = "Ten_Tai_Lieu")
	String tenTL;

	@Column(name = "mo_taTL")
	String motaTL;

	@Column(name = "Link")
	String link;
	
	@Column(name = "isDelete")
	Integer isDelete;

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public TrangThaiTaiLieu getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiTaiLieu trangThai) {
		this.trangThai = trangThai;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public TaiLieu() {

	}

	public Integer getIdTL() {
		return idTL;
	}

	public void setIdTL(Integer idTL) {
		this.idTL = idTL;
	}

	public String getMaTL() {
		return maTL;
	}

	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}

	public String getTenTL() {
		return tenTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}

	public String getMotaTL() {
		return motaTL;
	}

	public void setMotaTL(String motaTL) {
		this.motaTL = motaTL;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}