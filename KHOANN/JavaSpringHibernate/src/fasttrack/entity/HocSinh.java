package fasttrack.entity;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quanlyhocsinh")
public class HocSinh  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;


	@Column(name = "maSV")
	private String maSV;

	@OneToMany(fetch= FetchType.EAGER , mappedBy="hocSinh", cascade=CascadeType.MERGE)
	private List<DiemHocSinh> listDiem;

	@Column(name = "address")
	private String address;

	@Column(name = "gender")
	private String gender;

	@Column(name = "image")
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public HocSinh(int id, String maSV, String name, String address, String gender, String image,
			List<DiemHocSinh> listDiem) {
		super();
		this.id = id;
		this.maSV = maSV;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.image = image;
		this.listDiem = listDiem;
	}

	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<DiemHocSinh> getListDiem() {
		return listDiem;
	}

	public void setDiemHocSinh(List<DiemHocSinh> listDiem) {
		this.listDiem = listDiem;
	}

}
