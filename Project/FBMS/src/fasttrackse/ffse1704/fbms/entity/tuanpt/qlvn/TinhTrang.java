package fasttrackse.ffse1704.fbms.entity.tuanpt.qlvn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tinh_trang_tuanpt")
public class TinhTrang {
	@Id
	@Column(name="id_tinh_trang")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTinhTrang;
	
	@Column(name="id_nhan_vien")
	private int idNhanVien;
	
	@Column(name="ngay_da_nghi")
	private int ngayDaNghi;
	
	@Column(name="ngay_con_lai")
	private int ngayConLai;
	
	public int getIdTinhTrang() {
		return idTinhTrang;
	}

	public void setIdTinhTrang(int idTinhTrang) {
		this.idTinhTrang = idTinhTrang;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public int getNgayDaNghi() {
		return ngayDaNghi;
	}

	public void setNgayDaNghi(int ngayDaNghi) {
		this.ngayDaNghi = ngayDaNghi;
	}

	public int getNgayConLai() {
		return ngayConLai;
	}

	public void setNgayConLai(int ngayConLai) {
		this.ngayConLai = ngayConLai;
	}

}
