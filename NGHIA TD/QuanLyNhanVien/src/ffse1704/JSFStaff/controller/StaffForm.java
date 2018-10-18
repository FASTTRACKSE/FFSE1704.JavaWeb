package ffse1704.JSFStaff.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ffse1704.JSFStaff.dao.StaffDAO;
import ffse1704.JSFStaff.entity.NhanVien;
import model.entity.SinhVien;



@ManagedBean
@SessionScoped
public class StaffForm {
	private String id;
	private NhanVien nhanVien;
	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;
	private List<NhanVien> listStaff;
	

	@ManagedProperty(value = "#{userDao}")
	private StaffDAO staffDAO;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public NhanVien getNhanVien() {
		return nhanVien;
	}


	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public Integer[] getPageLink() {
		return pageLink;
	}


	public void setPageLink(Integer[] pageLink) {
		this.pageLink = pageLink;
	}


	public List<NhanVien> getListStaff() {
		return listStaff;
	}


	public void setListStaff(List<NhanVien> listStaff) {
		this.listStaff = listStaff;
	}


	public StaffDAO getStaffDAO() {
		return staffDAO;
	}


	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}
	

	public List<NhanVien> viewListStaff() {

		return StaffDAO.getAllStaff();
	}

}
