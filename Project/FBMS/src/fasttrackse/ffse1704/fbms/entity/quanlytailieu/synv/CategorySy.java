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
	private String ten_danh_muc;

	@Column(name = "ma_danh_muc")
	private String ma_danh_muc;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen_danh_muc() {
		return ten_danh_muc;
	}

	public void setTen_danh_muc(String ten_danh_muc) {
		this.ten_danh_muc = ten_danh_muc;
	}

	public String getMa_danh_muc() {
		return ma_danh_muc;
	}

	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}
	


}