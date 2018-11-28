package sinhvienfrom;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import entity.SinhVien;
import model.SinhVienDAO;

@ManagedBean
@RequestScoped
public class SinhVienFrom {
	private String maSinhVien;
	private String tenSinhVien;
	private String lopHoc;
	private String tuoiSinhVien;
	private String gioiTinh;
	private String diaChi;
	private String soDT;
	private String email;
	
	



	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}



	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}



	

	public String getGioiTinh() {
		return gioiTinh;
	}



	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}



	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public String getSoDT() {
		return soDT;
	}



	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMaSinhVien() {
		return maSinhVien;
	}



	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}



	public String getTenSinhVien() {
		return tenSinhVien;
	}



	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}



	public String getLopHoc() {
		return lopHoc;
	}



	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}



	@ManagedProperty (value= "#{sinhVienDAO}")
	private SinhVienDAO sinhVienDAO;

	
	
	public SinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}



	public void setSinhVienDAO(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
	}



	public List<SinhVien> viewAllSinhVien(){
		return sinhVienDAO.getAllSinhVien();
	}
	
	public String addSinhVien() {
		SinhVien sv = new SinhVien(maSinhVien,tenSinhVien,lopHoc,tuoiSinhVien,gioiTinh,diaChi,soDT,email);
		sinhVienDAO.addSinhVien(sv);
		return "index?faces-redirect=true";
	}
	
	public String vieweditSinhVien(String maSinhVien) {
		SinhVien sinhvien = sinhVienDAO.searchSinhVien(maSinhVien);
		maSinhVien = sinhvien.getMaSinhVien();
		tenSinhVien = sinhvien.getTenSinhVien();
		lopHoc = sinhvien.getLopHoc();
		tuoiSinhVien = sinhvien.getTuoiSinhVien();
		gioiTinh = sinhvien.getGioiTinh();
		diaChi = sinhvien.getDiaChi();
		soDT = sinhvien.getSoDT();
		email = sinhvien.getEmail();
		return "editsinhvien";
	}
	
	public String editSinhVien() {
		SinhVien sv = new SinhVien(maSinhVien,tenSinhVien,lopHoc,tuoiSinhVien,gioiTinh,diaChi,soDT,email);
		sinhVienDAO.editSinhVien(sv);
		return "index?faces-redirect=true";
	}
	
	public String updateSinhVien() {
		SinhVien sv = new SinhVien(tenSinhVien,lopHoc,tuoiSinhVien,gioiTinh,diaChi,soDT,email,maSinhVien);
		return "index?faces-redirect=true";
	}
	
	public String deleteSinhVien(String maSinhVien) {
		sinhVienDAO.deleteSinhVien(maSinhVien);
		return "index?faces-redirect=true";
	}
}
