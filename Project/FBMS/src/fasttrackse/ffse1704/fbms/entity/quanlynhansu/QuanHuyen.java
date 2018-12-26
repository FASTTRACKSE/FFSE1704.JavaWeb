package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.List;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "quanhuyen")
public class QuanHuyen implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maqh", unique = true, nullable = false)
	private String maqh;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="type",nullable = false)
	private String type;
	
	@Column(name="matp",nullable = false)
	private String matp;
//	
//	@ManyToOne
//	@JoinColumn(name="matp",referencedColumnName="matp",nullable= false)
//	private ThanhPho thanhPho;
	
	public String getMatp() {
		return matp;
	}

	public void setMatp(String matp) {
		this.matp = matp;
	}

	@OneToMany(mappedBy="quanHuyen",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<NhanSu> listNhanSuQH;
	
//	@OneToMany(mappedBy="quanHuyen",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
//	@Fetch(value = FetchMode.SUBSELECT)
//	private List<XaPhuong> listXaPhuong;

	

	public String getMaqh() {
		return maqh;
	}

	public void setMaqh(String maqh) {
		this.maqh = maqh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
//
//	public ThanhPho getThanhPho() {
//		return thanhPho;
//	}
//
//	public void setThanhPho(ThanhPho thanhPho) {
//		this.thanhPho = thanhPho;
//	}
//
	public List<NhanSu> getListNhanSuQH() {
		return listNhanSuQH;
	}

	public void setListNhanSuQH(List<NhanSu> listNhanSuQH) {
		this.listNhanSuQH = listNhanSuQH;
	}
//
//	public List<XaPhuong> getListXaPhuong() {
//		return listXaPhuong;
//	}
//
//	public void setListXaPhuong(List<XaPhuong> listXaPhuong) {
//		this.listXaPhuong = listXaPhuong;
//	}
//	
//	
	
	
}
