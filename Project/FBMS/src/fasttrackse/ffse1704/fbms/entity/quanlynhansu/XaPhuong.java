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

@Entity
@Table(name = "xaphuongthitran")
public class XaPhuong implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "xaid", unique = true, nullable = false)
	private String xaid;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "maqh", nullable = false)
	private String maqh;

	public String getMaqh() {
		return maqh;
	}

	public void setMaqh(String maqh) {
		this.maqh = maqh;
	}

	// @ManyToOne
//	@JoinColumn(name="maqh",referencedColumnName="maqh",nullable= false)
//	private QuanHuyen quanHuyen;
//	

	public String getXaid() {
		return xaid;
	}

	public void setXaid(String xaid) {
		this.xaid = xaid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public QuanHuyen getQuanHuyen() {
//		return quanHuyen;
//	}
//
//	public void setQuanHuyen(QuanHuyen quanHuyen) {
//		this.quanHuyen = quanHuyen;
//	}

}
