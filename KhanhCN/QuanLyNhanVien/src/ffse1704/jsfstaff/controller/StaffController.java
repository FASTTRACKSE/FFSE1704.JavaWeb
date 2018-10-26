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

import ffse1704.jsfstaff.DAO.StaffDAO;
import ffse1704.jsfstaff.entity.NhanVien;
import ffse1704.jsfstaff.entity.TinhThanh;

@ManagedBean
@SessionScoped
public class StaffController {
	
	final String dirPath = "D:\\image";

	private List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	private List<TinhThanh> dsTinhThanh = new ArrayList<TinhThanh>();

	private StaffDAO staffDAO = new StaffDAO();

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	private int totalPage = 1;
	private int currPage = 1;
	private int perPage = 4;

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

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

	public List<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(List<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
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

	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	public String getStaffForUpdate(int id) {
		NhanVien st = staffDAO.getNhanVienById(id);
		sessionMap.put("edit", st);

		return "editStaff?faces-redirect=true";
	}

	public String createStaff(NhanVien st) {
		upload();
		st.setHinhAnh(fileName);
		staffDAO.addNewNhanVien(st);
		loadStaffListByPage();
		return "NhanVien?faces-redirect=true";
	}

	public String updateStaff(NhanVien st) {
		upload();
		st.setHinhAnh(fileName);
		staffDAO.updateNhanVien(st);
		loadStaffListByPage();
		return "NhanVien?faces-redirect=true";
	}

	public String deleteStaff(int id) {
		staffDAO.deleteNhanVien(id);
		loadStaffListByPage();
		return "NhanVien?faces-redirect=true";
	}

	public StaffController() throws Exception {
		dsTinhThanh = staffDAO.getListTinhThanh();

		loadStaffListByPage();
	}

	public void loadStaff() {
		dsNhanVien = staffDAO.getListNhanVien();
	}

	public void loaddsTinhThanh() {
		dsTinhThanh = staffDAO.getListTinhThanh();
	}

	public void loadStaffListByPage() {
		dsNhanVien = staffDAO.getListNhanVienByPage(currPage, perPage);
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

	// Upload File

	private Part file;
	private String fileName;
	private long fileSize;

	/**
	 * Creates a new instance of Upload_File
	 */

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void upload() {
		try {
			// get name of selected file
			fileName = file.getSubmittedFileName();
			// get file's size
			fileSize = file.getSize();
		/*	// get fullpath of opload folder in web root
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");*/
			// write file to upload folder
			File path = new File(dirPath);

			if (!path.exists()) {
				path.mkdirs();
			}

			file.write(dirPath + "/" + fileName);

		} catch (IOException ex) {
			Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}