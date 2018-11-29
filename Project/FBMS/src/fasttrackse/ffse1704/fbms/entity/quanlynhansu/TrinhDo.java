package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="trinh_do")
public class TrinhDo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trinh_do", unique = true, nullable = false)
	private int id;
	
	@Column(name = "ten_trinh_do", nullable = false)
	private int ten;
	
	public TrinhDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "trinhDo")
	private List<BangCap> bangCap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public List<BangCap> getBangCap() {
		return bangCap;
	}

	public void setBangCap(List<BangCap> bangCap) {
		this.bangCap = bangCap;
	}
}
