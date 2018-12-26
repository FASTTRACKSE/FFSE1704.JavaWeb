package fasttrackse.ffse1704.fbms.entity.quanlytailieu.dung;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "icon_dung")
public class IconDung implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2598675781648548689L;
	@OneToMany(mappedBy="maIcon")
	private List<DocumentDung> DocumentDung;
	public List<DocumentDung> getDocument() {
		return DocumentDung;
	}
	public void setDocument(List<DocumentDung> documentDung) {
		DocumentDung = documentDung;
	}
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
	private String maIcon;

	@Column(name = "hinh_anh")
	private String hinhAnh;

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


}
