package fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv;

import java.util.Collection;
import java.util.List;

//import java.io.Serializable;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv.DocumentSy;

@Entity
@Table(name = "danh_muc_")
public class CategorySy implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	

	@Id
	@Column(name = "id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "ten_danh_muc")
	private String tenDanhMuc;

	@Column(name = "ma_danh_muc")
	private String maDanhMuc;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	
}

