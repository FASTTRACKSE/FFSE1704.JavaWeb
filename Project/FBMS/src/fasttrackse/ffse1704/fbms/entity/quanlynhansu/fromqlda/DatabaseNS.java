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
@Table(name="database")
public class DatabaseNS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, length = 11)
	private int id;
	
	@Column(name = "ma_database",  nullable = false, length = 30)
	@NotEmpty
	private String maDatabase;
	
	@Column(name = "ten_database",  nullable = false, length = 30)
	@NotEmpty
	private String tenDatabase;
	
	@Column(name = "ghi_chu",  nullable = false, length = 30)
	@NotEmpty
	private String ghiChu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaDatabase() {
		return maDatabase;
	}

	public void setMaDatabase(String maDatabase) {
		this.maDatabase = maDatabase;
	}

	public String getTenDatabase() {
		return tenDatabase;
	}

	public void setTenDatabase(String tenDatabase) {
		this.tenDatabase = tenDatabase;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	

}
