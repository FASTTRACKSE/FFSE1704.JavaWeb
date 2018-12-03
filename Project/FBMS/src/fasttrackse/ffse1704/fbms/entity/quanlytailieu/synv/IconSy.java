package fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "icon")
public class IconSy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2598675781648548689L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ma_icon",insertable = true , updatable = false)
	private String ma_icon;

	@Column(name = "hinh_anh")
	private String hinh_anh;

	public String getMa_icon() {
		return ma_icon;
	}

	public void setMa_icon(String ma_icon) {
		this.ma_icon = ma_icon;
	}

	public String getHinh_anh() {
		return hinh_anh;
	}

	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}

}
