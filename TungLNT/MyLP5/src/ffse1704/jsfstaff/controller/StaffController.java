package ffse1704.jsfstaff.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import ffse1704.jsfstaff.dao.StaffDAO;
import ffse1704.jsfstaff.entity.Staff;
import ffse1704.jsfstaff.entity.TinhThanhPho;
import ffse1704.jsfstaff.util.*;

@ManagedBean
@SessionScoped
public class StaffController {
	private List<Staff> dsNhanVien = new ArrayList<Staff>();
	private List<TinhThanhPho> dsTinhThanh = new ArrayList<TinhThanhPho>();

	private StaffDAO staffDAO = new StaffDAO();

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	private int totalPage = 1;
	private int currPage = 1;
	private int perPage = 3;
	final String dirPath = "E:\\images";
	private String fileName;
	private Part file;
	private long fileSize;
	private Staff staff;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public List<TinhThanhPho> getDsTinhThanh() {
		return dsTinhThanh;
	}

	public void setDsTinhThanh(List<TinhThanhPho> dsTinhThanh) {
		this.dsTinhThanh = dsTinhThanh;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Staff> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(List<Staff> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public StaffDAO getStaffDAO() {
		return staffDAO;
	}

	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	public StaffController() throws Exception {
		dsTinhThanh = staffDAO.getListTinhThanh();

		// Get list of staff
		loadStaffListByPage();
	}
	public void upload() {
		try {
			// get name of selected file
			fileName = file.getSubmittedFileName();
			// get file's size
			fileSize = file.getSize();
			// get fullpath of Upload folder in web root

			// write file to upload folder
			file.write(dirPath + "/" + fileName);

		} catch (IOException ex) {
			Logger.getLogger(ViewImage.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public void loadStaffList() {
		dsNhanVien = staffDAO.getListNhanVien();
		totalPage = (int) Math.ceil(dsNhanVien.size() * 1.0 / perPage);
	}

	public void loadStaffListByPage() {
		dsNhanVien = staffDAO.getListNhanVienByPage(currPage, perPage);
		totalPage = (int) Math.ceil(staffDAO.countNhanVien() * 1.0 / perPage);
	}

	public String getStaffForUpdate(int id) {
		Staff st = staffDAO.getNhanVienById(id);
		sessionMap.put("editStaff", st);

		return "staff-update?faces-redirect=true";
	}

	public String getStaffForDelete(int id) {
		staffDAO.deleteNhanVien(id);
		loadStaffList();
		return "index?faces-redirect=true";

	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String createStaff(Staff st) {
		upload();
		st.setAnhThe(fileName);
		staffDAO.addNewNhanVien(st);
		loadStaffListByPage();

		return "index?faces-redirect=true";
	}

	public String updateStaff(Staff st) {
		staffDAO.updateNhanVien(st);
		loadStaffListByPage();

		return "index?faces-redirect=true";
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