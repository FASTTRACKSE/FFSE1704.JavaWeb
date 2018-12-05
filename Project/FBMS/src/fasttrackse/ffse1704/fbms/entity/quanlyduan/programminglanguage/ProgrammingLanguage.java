package fasttrackse.ffse1704.fbms.entity.quanlyduan.programminglanguage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;

@Entity
@Table(name = "programming_language")
public class ProgrammingLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;

	@Column(name = "ma_programming_language", nullable = false, length = 30)
	@NotEmpty
	private String maProgrammingLanguage;

	@OneToMany(mappedBy = "programmingLanguage")
	private List<ThongTinDuAn> listDuAn = new ArrayList<ThongTinDuAn>();

	@Column(name = "ten_programming_language", nullable = false, length = 255)
	@NotEmpty
	private String tenProgrammingLanguage;

	@Column(name = "ghi_chu", nullable = true, length = 500)
	private String ghiChu;

	public ProgrammingLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgrammingLanguage(int id, @NotEmpty String maProgrammingLanguage, List<ThongTinDuAn> listDuAn,
			@NotEmpty String tenProgrammingLanguage, @NotEmpty String ghiChu) {
		super();
		this.id = id;
		this.maProgrammingLanguage = maProgrammingLanguage;
		this.listDuAn = listDuAn;
		this.tenProgrammingLanguage = tenProgrammingLanguage;
		this.ghiChu = ghiChu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaProgrammingLanguage() {
		return maProgrammingLanguage;
	}

	public void setMaProgrammingLanguage(String maProgrammingLanguage) {
		this.maProgrammingLanguage = maProgrammingLanguage;
	}

	public List<ThongTinDuAn> getListDuAn() {
		return listDuAn;
	}

	public void setListDuAn(List<ThongTinDuAn> listDuAn) {
		this.listDuAn = listDuAn;
	}

	public String getTenProgrammingLanguage() {
		return tenProgrammingLanguage;
	}

	public void setTenProgrammingLanguage(String tenProgrammingLanguage) {
		this.tenProgrammingLanguage = tenProgrammingLanguage;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
