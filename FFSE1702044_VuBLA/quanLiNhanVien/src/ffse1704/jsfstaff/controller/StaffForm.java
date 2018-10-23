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
import ffse1704.jsfstaff.entity.province;
import model.form.Upload_File;

@ManagedBean
@SessionScoped
public class StaffForm {
	private StaffDAO staffDAO;
	private List<Staff> listStaff;
	private List<province> dsTinhThanh = new ArrayList<province>();
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private int totalPage =1 ;
	private int currPage=1;
	private int perPage=3;
	private Part file;
	private String fileName;
    private long fileSize;
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
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

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public StaffDAO getStaffDAO() {
		return staffDAO;
	}

	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	public List<Staff> getListStaff() {
		return listStaff;
	}

	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}

	public List<province> getDsTinhThanh() {
		return dsTinhThanh;
	}

	public void setDsTinhThanh(List<province> dsTinhThanh) {
		this.dsTinhThanh = dsTinhThanh;
	}

	public StaffForm() throws Exception {
		listStaff = new ArrayList<Staff>();
		staffDAO = new StaffDAO();
		// get list of Staff
		loadStaffListByPage();
		loadTinhThanhList();
	}

	public void loadTinhThanhList() {
		dsTinhThanh = staffDAO.getListTinhThanh();

	}
	 public String upload()
	    {
	        try {
	        	
	            // get name of selected file
	            fileName = file.getSubmittedFileName();
	            // get file's size
	            fileSize = file.getSize();
	            // get fullpath of opload folder in web root
	            String dirPath= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
	            // write file to upload folder
	           
	           
	            File path = new File(dirPath);

				if (!path.exists()) {
				    path.mkdirs();
				}
				 file.write(dirPath + "/" + fileName);
	        } catch (IOException ex) {
	            Logger.getLogger(StaffForm.class.getName()).log(Level.SEVERE, null, ex);
	        }
	         
	        return "view";
	    }
	public void loadStafflist() {
		listStaff = staffDAO.getAllStaff();
	}

	public String addStaff(Staff st) {
		staffDAO.addNewStaff(st);
		loadStaffListByPage();
		return "index?faces-redirect=true";
	}
	public String getStaffForUpdate(int id) {
		Staff st = staffDAO.getNhanVienById(id);
		sessionMap.put("editStaff", st);
		
		return "EditStaff?faces-redirect=true";
	}
	public String updateStaff(Staff st) {

		staffDAO.editStaff(st);
		loadStaffListByPage();
		return "index?faces-redirect=true";
	}
	public String deleteStaff(int id) {
		staffDAO.deleteNhanVien(id);
		
		loadStaffListByPage();
		return "index?faces-redirect=true";
	}
	public void loadStaffListByPage() {
		listStaff = staffDAO.getListNhanVienByPage(currPage, perPage);
		totalPage = (int)Math.ceil(staffDAO.countNhanVien() * 1.0 / perPage);
	}
	public void goPage(int page) {
		currPage = page;
		if (currPage < 1) {
			currPage = 1;
		}
		else if (currPage > totalPage) {
			currPage = totalPage;
		}

		loadStaffListByPage();
	}
}
