package ffse1704.jsf.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ffse1704.jsf.entity.hedaotao.HeDaoTao;
import ffse1704.jsf.entity.loaihinhdaotao.LoaiHinhDaoTao;
import ffse1704.jsf.entity.monhoc.MonHoc;

@ManagedBean
@RequestScoped
public class SinhVien {
	private String id;
	private String hoTenSinhVien;
	private String namSinhSinhVien;
	private String diaChiSinhVien;
	private String sdtSinhVien;
	private String emailSinhVien;
	HeDaoTao heDaoTao;
	LoaiHinhDaoTao loaiHinhDaoTao;

	public SinhVien() {
		super();
	}

	
	
	
	public SinhVien(String id, String hoTenSinhVien, String namSinhSinhVien, String diaChiSinhVien, String sdtSinhVien,
			String emailSinhVien, HeDaoTao heDaoTao, LoaiHinhDaoTao loaiHinhDaoTao)  {
		super();
		this.id = id;
		this.hoTenSinhVien = hoTenSinhVien;
		this.namSinhSinhVien = namSinhSinhVien;
		this.diaChiSinhVien = diaChiSinhVien;
		this.sdtSinhVien = sdtSinhVien;
		this.emailSinhVien = emailSinhVien;
		this.heDaoTao = heDaoTao;
		this.loaiHinhDaoTao = loaiHinhDaoTao;


	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTenSinhVien() {
		return hoTenSinhVien;
	}

	public void setHoTenSinhVien(String hoTenSinhVien) {
		this.hoTenSinhVien = hoTenSinhVien;
	}

	public String getNamSinhSinhVien() {
		return namSinhSinhVien;
	}

	public void setNamSinhSinhVien(String namSinhSinhVien) {
		this.namSinhSinhVien = namSinhSinhVien;
	}

	public String getDiaChiSinhVien() {
		return diaChiSinhVien;
	}

	public void setDiaChiSinhVien(String diaChiSinhVien) {
		this.diaChiSinhVien = diaChiSinhVien;
	}

	public String getSdtSinhVien() {
		return sdtSinhVien;
	}

	public void setSdtSinhVien(String sdtSinhVien) {
		this.sdtSinhVien = sdtSinhVien;
	}

	public String getEmailSinhVien() {
		return emailSinhVien;
	}

	public void setEmailSinhVien(String emailSinhVien) {
		this.emailSinhVien = emailSinhVien;
	}

	public String getThongTinSinhVien() {
		return hoTenSinhVien + "-----" + namSinhSinhVien;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getThongTinHeDaoTao();
	}

	public String getThongTinHLoaiHinhDaoTao() {
		return loaiHinhDaoTao.getThongTinLoaiHinhDaoTao();
	}




	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}




	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}




	

	

}
