package ffse1704.jsfstaff.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ffse1704.jsfstaff.DAO.StaffDAO;
import ffse1704.jsfstaff.entity.Staff;
import ffse1704.jsfstaff.entity.TinhThanh;

@ManagedBean
@SessionScoped
public class StaffForm {
	private StaffDAO staffDAO;
	private List<Staff> listStaff;
	private List<TinhThanh> dsTinhThanh;
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	private int totalPage = 1;
	private int currPage = 1;
	private int perPage = 5;

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public List<TinhThanh> getDsTinhThanh() {
		return dsTinhThanh;
	}

	public void setDsTinhThanh(List<TinhThanh> dsTinhThanh) {
		this.dsTinhThanh = dsTinhThanh;
	}

	public StaffDAO getStaffDAO() {
		return staffDAO;
	}

	public void setNhanVienDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	public List<Staff> getlistStaff() {
		return listStaff;
	}

	public void setlistStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}

	public StaffForm() throws Exception {
		listStaff = new ArrayList<Staff>();

		staffDAO = new StaffDAO();
		loadStaffList();
		loaddsTinhThanh();
		loadStaffListByPage();
		
	}

	public void loadStaff() {
		listStaff = staffDAO.getAllNhanVien();
	}

	public void loaddsTinhThanh() {
		dsTinhThanh = staffDAO.getListTinhThanh();
	}

	public String createStaff(Staff st) {
		staffDAO.addNewSinhVien(st);

		loadStaffListByPage();

		return "NhanVien?faces-redirect=true";
	}

	public String getStaffForUpdate(int id) {
		Staff st = staffDAO.getNhanVienById(id);
		sessionMap.put("editStaff", st);

		return "Edit?faces-redirect=true";
	}

	public String updateStaff(Staff st) {
		staffDAO.updateNewSinhVien(st);
		loadStaffListByPage();
		return "NhanVien?faces-redirect=true";
	}

	public String deleteStaff(int id) {
		staffDAO.deleteNhanVien(id);
		loadStaffListByPage();
		return "NhanVien?faces-redirect=true";
	}

	public void loadStaffList() {
		listStaff = staffDAO.getAllNhanVien();
		totalPage = (int) Math.ceil(listStaff.size() * 1.0 / perPage);
	}

	public void loadStaffListByPage() {
		listStaff = staffDAO.getListNhanVienByPage(currPage, perPage);
		totalPage = (int) Math.ceil(staffDAO.countNhanVien() * 1.0 / perPage);
	}

	public void goPage(int page) {
		currPage = page;
		if (currPage < 1) {
			currPage = 1;
		} else if (currPage > totalPage) {
			currPage = totalPage;
		}

		loadStaffListByPage();
	}

}
