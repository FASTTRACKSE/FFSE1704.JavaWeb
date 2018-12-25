package fasttrackse.ffse1704.fbms.entity.quanlytailieu.synv;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "icon_")
public class IconSy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2598675781648548689L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ma_icon", insertable = true, updatable = false)
	private String maIcon;

	@Column(name = "hinh_anh")
	private String hinhAnh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaIcon() {
		return maIcon;
	}

	public void setMaIcon(String maIcon) {
		this.maIcon = maIcon;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}