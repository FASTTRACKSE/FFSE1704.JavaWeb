package fasttrackse.ffse1704.fbms.entity.quanlynhansu.fromqlda;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "programming_language")
public class ProgrammingLanguageNS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_programming_language")
	@NotEmpty
	private String maProgrammingLanguage;
	
	@Column(name = "ten_programming_language")
	@NotEmpty
	private String tenProgrammingLanguage;
	
	@Column(name = "ghi_chu")
	@NotEmpty
	private String ghiChu;

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
