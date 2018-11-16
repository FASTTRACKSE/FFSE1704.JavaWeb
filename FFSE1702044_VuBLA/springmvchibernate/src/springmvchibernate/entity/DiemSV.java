package springmvchibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quanlidiem")
public class DiemSV implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "maSV")
	private String maSV;
	@Column(name = "ma_monhoc")
	private String maMH;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "DiemSV1", cascade = CascadeType.MERGE)
	private Set<User> User = new HashSet<User>(0);


	public Set<User> getUser() {
		return User;
	}

	public void setUser(Set<User> user) {
		User = user;
	}

	@Column(name = "diem")
	private int diem;




	public DiemSV(int id, String maSV, String maMH, int diem) {
		super();
		this.id = id;
		this.maSV = maSV;
		this.maMH = maMH;
		this.diem = diem;
	}

	public DiemSV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

}
