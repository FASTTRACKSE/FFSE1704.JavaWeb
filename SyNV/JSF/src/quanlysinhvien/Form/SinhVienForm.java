package quanlysinhvien.Form;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import quanlysinhvien.entity.SinhVien;
import quanlysinhvien.model.SinhVienDao;

@ManagedBean
@RequestScoped
public class SinhVienForm {
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String name ;
	private String age ;
	private String gender ;
	private String address ;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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
	@ManagedProperty(value = "#{sinhVienDao}")
	private SinhVienDao sinhVienDao;

	public SinhVienDao getSinhVienDao() {
		return sinhVienDao;
	}

	public void setSinhVienDao(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
	}

	public List<SinhVien> viewSinhVien() {
		return sinhVienDao.getSinhVien();
	}
	public String addSinhVien() {
		SinhVien sv = new SinhVien(name, age, gender, address);
		sinhVienDao.addSinhVien(sv);
		return "SinhVien?faces-redirect=true";
	}
	public String deleteSinhVien(String id) {

		sinhVienDao.deleteSinhVien(id);
		return "SinhVien?faces-redirect=true";
	}
	
	public String updateSinhVien() {
		SinhVien sv = new SinhVien(id, name, age, gender, address);
		sinhVienDao.editSinhVien(sv);
		return "SinhVien?faces-redirect=true";
	}
	public String viewUpdate(String madm) {
		SinhVien sinhvien = sinhVienDao.seach(madm);
		id = sinhvien.getId();
		name =sinhvien.getName();
		age = sinhvien.getAge();
		gender =sinhvien.getGender();
		address = sinhvien.getAddress();
		return "updateSinhVien";
	}
	
}
