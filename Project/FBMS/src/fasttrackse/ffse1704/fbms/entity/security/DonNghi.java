package fasttrackse.ffse1704.fbms.entity.security;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "donnghi")
public class DonNghi implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "iddon")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddon;
	
	@Column( name = "idnv")
	private int idnv;
	
	
	@Column( name = "tennv")
	private String tennv;
	
	@Column( name = "phongban")
	private String phongban;
	
	@Column( name = "lydo")
	private String lydo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column( name = "tgbatdau")
	private Date tgbatdau;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column( name = "tgketthuc")
	private Date tgketthuc;
	
	@Column( name = "tinhtrang")
	private int tinhtrang;
	
	@Column( name = "ghichu")
	private String ghichu;
	

	public int getIddon() {
		return iddon;
	}

	public void setIddon(int iddon) {
		this.iddon = iddon;
	}

	public int getIdnv() {
		return idnv;
	}

	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}

	public String getTennv() {
		return tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public String getPhongban() {
		return phongban;
	}

	public void setPhongban(String phongban) {
		this.phongban = phongban;
	}

	public String getLydo() {
		return lydo;
	}

	public void setLydo(String lydo) {
		this.lydo = lydo;
	}

	public Date getTgbatdau() {
		return tgbatdau;
	}

	public void setTgbatdau(Date tgbatdau) {
		this.tgbatdau = tgbatdau;
	}

	public Date getTgketthuc() {
		return tgketthuc;
	}

	public void setTgketthuc(Date tgketthuc) {
		this.tgketthuc = tgketthuc;
	}

	public int getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
	@Override
	public String toString() {
		return "donnghi[iddon="+ iddon +",idnv=" + idnv + ", tennv=" + tennv +""
				+ ", phongban=" + phongban +", lydo=" + lydo + ", tgbatdau="+ tgbatdau +","
						+ "tgketthuc=" + tgketthuc +",tinhtrang="+ tinhtrang +",ghichu="+ ghichu +"]";
		
	}
	
	
}
