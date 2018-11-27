package fasttrackse.ffse1704.fbms.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chuc_nang")

public class ChucNang {

	@Id
	@Column(name = "ma_chuc_nang", unique = true, nullable = false)
	private String ma_chuc_nang;

	@Column(name = "ten_chuc_nang", nullable = false, length = 100)
	private String ten_chuc_nang;

	private int trang_thai;

	public String getMa_chuc_nang() {
		return ma_chuc_nang;
	}

	public void setMa_chuc_nang(String ma_chuc_nang) {
		this.ma_chuc_nang = ma_chuc_nang;
	}

	public String getTen_chuc_nang() {
		return ten_chuc_nang;
	}

	public void setTen_chuc_nang(String ten_chuc_nang) {
		this.ten_chuc_nang = ten_chuc_nang;
	}

	public int getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(int trang_thai) {
		this.trang_thai = trang_thai;
	}

	public ChucNang(String ma_chuc_nang, String ten_chuc_nang, int trang_thai) {
		super();
		this.ma_chuc_nang = ma_chuc_nang;
		this.ten_chuc_nang = ten_chuc_nang;
		this.trang_thai = trang_thai;
	}

	public ChucNang() {
		super();
	}

	@Override
	public String toString() {
		return "ChucNang [ma_chuc_nang=" + ma_chuc_nang + ", ten_chuc_nang=" + ten_chuc_nang + ", trang_thai="
				+ trang_thai + "]";
	}

}
