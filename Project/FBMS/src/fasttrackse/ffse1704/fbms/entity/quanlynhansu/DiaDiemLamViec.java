package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dia_diem_lam_viec")
public class DiaDiemLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dia_diem")
	private String maDiaDiem;
	
	@Column(name = "ten_dia_diem")
	private String tenDiaDiem;
	
	public String getMaDiaDiem() {
		return maDiaDiem;
	}

	public void setMaDiaDiem(String maDiaDiem) {
		this.maDiaDiem = maDiaDiem;
	}

	public String getTenDiaDiem() {
		return tenDiaDiem;
	}

	public void setTenDiaDiem(String tenDiaDiem) {
		this.tenDiaDiem = tenDiaDiem;
	}
}
