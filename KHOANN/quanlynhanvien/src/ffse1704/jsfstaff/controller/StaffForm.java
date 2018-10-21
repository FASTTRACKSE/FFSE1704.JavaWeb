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
		loadStaff();
		loaddsTinhThanh();
	}

	public void loadStaff() {
		listStaff = staffDAO.getAllNhanVien();
	}

	public void loaddsTinhThanh() {
		dsTinhThanh = staffDAO.getListTinhThanh();
	}

	public String createStaff(Staff st) {
		staffDAO.addNewSinhVien(st);

		loadStaff();

		return "NhanVien?faces-redirect=true";
	}

	public String getStaffForUpdate(int id) {
		Staff st = staffDAO.getNhanVienById(id);
		sessionMap.put("editStaff", st);

		return "Edit?faces-redirect=true";
	}
	
	public String updateStaff(Staff st) {
		staffDAO.updateNewSinhVien(st);
		loadStaff();
		return "NhanVien?faces-redirect=true";
	}
	
	public String deleteStaff(int id) {
		staffDAO.deleteNhanVien(id);
		loadStaff();
		return "NhanVien?faces-redirect=true";
	}
	

}
