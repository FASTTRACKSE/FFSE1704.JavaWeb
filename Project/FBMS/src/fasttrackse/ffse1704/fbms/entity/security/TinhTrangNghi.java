package fasttrackse.ffse1704.fbms.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tinhtrangnghi")
public class TinhTrangNghi {
	
	@Id
	@Column(name="idtinhtrang")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtinhtrang;
	
	@Column(name="idnv")
	private int idnv;
	
	@Column(name="ngaydanghi")
	private int ngaydanghi;
	
	@Column(name="ngayconlai")
	private int ngayconlai;

	public int getIdtinhtrang() {
		return idtinhtrang;
	}

	public void setIdtinhtrang(int idtinhtrang) {
		this.idtinhtrang = idtinhtrang;
	}

	public int getIdnv() {
		return idnv;
	}

	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}

	public int getNgaydanghi() {
		return ngaydanghi;
	}

	public void setNgaydanghi(int ngaydanghi) {
		this.ngaydanghi = ngaydanghi;
	}

	public int getNgayconlai() {
		return ngayconlai;
	}

	public void setNgayconlai(int ngayconlai) {
		this.ngayconlai = ngayconlai;
	}
	
}
