package model.form;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

@ManagedBean
@RequestScoped
public class SinhVienForm {
	private String id;
	private String masv;
	private String ho;
	private String ten;
	private String gioiTinh;
	private String namsinh;
	private String lop;

	private List<SinhVien> listSinhVien;

	@ManagedProperty(value = "#{sinhVienDAO}")
	private SinhVienDAO sinhVienDAO;

	@PostConstruct
	public void init() {
		listSinhVien = sinhVienDAO.getAllSinhVien();
	}

	public SinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
	}

	public List<SinhVien> viewAllSinhVien() {
		return sinhVienDAO.getAllSinhVien();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String addSinhVien() {
		SinhVien sv = new SinhVien(masv, ho, ten, gioiTinh, namsinh, lop);
		sinhVienDAO.addSinhVien(sv);
		return "index?faces-redirect=true";
	}

	public String viewEditSinhVien(String ID) {
		SinhVien sinhvien = sinhVienDAO.searchSinhVien(ID);
		id = sinhvien.getId();
		masv = sinhvien.getMasv();
		ho = sinhvien.getHo();
		ten = sinhvien.getTen();
		gioiTinh = sinhvien.getGioiTinh();
		namsinh = sinhvien.getNamsinh();
		lop = sinhvien.getLop();
		return "editsinhvien";
	}
	
	public String updateSinhVien() {
		SinhVien sv = new SinhVien(id, masv, ho, ten, gioiTinh, namsinh, lop);
		sinhVienDAO.editSinhVien(sv);
		return "index?faces-redirect=true";
	}
	
	public String deleteSinhVien(String id) {
		sinhVienDAO.deleteSinhVien(id);
		return "index?faces-redirect=true";
	}
}
