package model.form;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import controler.DAO.SinhVienDao;
import model.bean.SinhVien;

@ManagedBean
@RequestScoped
public class SinhVienForm {
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public void init() {
		listSinhVien = sinhVienDao.getSinhVien();
	}

	@ManagedProperty(value = "#{sinhVienDao}")
	private SinhVienDao sinhVienDao;
	private List<SinhVien> listSinhVien;

	public SinhVienDao getSinhVienDao() {
		return sinhVienDao;
	}

	public void setSinhVienDao(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
	}

	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public List<SinhVien> viewSinhVien() {
		return sinhVienDao.getSinhVien();
	}

	public String addSinhVien() {
		SinhVien sv = new SinhVien(name, email, password, gender, address);
		sinhVienDao.addSinhVien(sv);
		return "sinhvien?faces-redirect=true";

	}

	public String editSinhVien() {
		SinhVien sv = new SinhVien( id, name, email, password, gender, address);
		sinhVienDao.editSinhVien(sv);
		return "sinhvien?faces-redirect=true";
	}

	public String viewEdit(String maSV) {
		SinhVien sinhvien = sinhVienDao.seach(maSV);
		id = sinhvien.getId();
		name = sinhvien.getName();
		email = sinhvien.getemail();
		password = sinhvien.getpassword();
		gender = sinhvien.getGender();
		address = sinhvien.getAddress();
		return "edit";
	}

	public String deleteSinhVien(String maSV) {
		sinhVienDao.delete(maSV);
		return "sinhvien?faces-redirect=true";
	}
}
