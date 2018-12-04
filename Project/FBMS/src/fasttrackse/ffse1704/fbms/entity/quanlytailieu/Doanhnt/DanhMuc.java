package fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "danh_muc")
public class DanhMuc {
	@Id
	@Column(name = "ma_danh_muc")
	String maDM;

	@Column(name = "Ten_Danh_Muc")
	String tenDM;
	
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "isDelete")
	private Integer isDelete;

	public DanhMuc() {

	}

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}
}