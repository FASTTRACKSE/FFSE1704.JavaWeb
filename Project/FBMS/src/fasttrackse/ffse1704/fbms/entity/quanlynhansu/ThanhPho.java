package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thanh_pho")
public class ThanhPho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "provinceid", unique = true, nullable = false, length = 5)
	private String provinceid;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "type", nullable = false, length = 30)
	private String type;

	public ThanhPho() {
	}

	public ThanhPho(String provinceid, String name, String type) {
		super();
		this.provinceid = provinceid;
		this.name = name;
		this.type = type;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
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

}
