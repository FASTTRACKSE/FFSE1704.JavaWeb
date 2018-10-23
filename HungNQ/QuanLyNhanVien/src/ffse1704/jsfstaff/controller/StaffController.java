package ffse1704.jsfstaff.controller;

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
import ffse1704.jsfstaff.entity.nhanVien;
import ffse1704.jsfstaff.util.ViewImage;
import ffse1704.jsfstaff.entity.hoKhau;

@ManagedBean
@SessionScoped
public class StaffController {
	private List<nhanVien> dsNhanVien = new ArrayList<nhanVien>();
	private List<hoKhau> dsTinhThanh = new ArrayList<hoKhau>();	
	
	private StaffDAO staffDAO = new StaffDAO();
	
	
	
	private int totalPage = 1;
	private int currPage = 1;
	private int perPage = 1;
	
	final String dirPath = "E:\\lp5_image";
	private String fileName = "";
	private Part file;
	private long fileSize;

	

	public List<hoKhau> getDsTinhThanh() {
		return dsTinhThanh;
	}

	public void setDsTinhThanh(List<hoKhau> dsTinhThanh) {
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

	public List<nhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(List<nhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public StaffDAO getStaffDAO() {
		return staffDAO;
	}

	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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

	public String getDirPath() {
		return dirPath;
	}

	public StaffController() throws Exception {
		dsTinhThanh = staffDAO.getListTinhThanh();

		// Get list of staff
		loadStaffListByPage();
	}
	
	public void loadStaffList() {
		dsNhanVien = staffDAO.getListNhanVien();
		totalPage = (int)Math.ceil(dsNhanVien.size() * 1.0 / perPage);
	}
	
	public void loadStaffListByPage() {
		dsNhanVien = staffDAO.getListNhanVienByPage(currPage, perPage);
		totalPage = (int)Math.ceil(staffDAO.countNhanVien() * 1.0 / perPage);
	}

	
	public String getStaffForUpdate(int id) {
		nhanVien st = staffDAO.getNhanVienById(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("editStaff", st);
		
		return "staff-update?faces-redirect=true";
	}
	
	public String getStaffForDelete(int id) {
		staffDAO.deleteNhanVien(id);
		
		return "index.xhtml";
	}
	
	public String createStaff(nhanVien st) {
		upload();
		st.setImage(fileName);
		staffDAO.addNewNhanVien(st);
		loadStaffListByPage();
		
		return "index?faces-redirect=true";
	}
	
	public String updateStaff(nhanVien st) {
		upload();
		st.setImage(fileName);
		staffDAO.updateNhanVien(st);
		loadStaffListByPage();
		return "index?faces-redirect=true";
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
	public String getStaffById(int id){
		nhanVien nv = staffDAO.getNhanVienById(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("editStaff", nv);
		
		return "update?faces-redirect=true";
	}
	
	public void upload()
    {
        try {
            // get name of selected file
        	fileName = file.getSubmittedFileName();
            // get file's size
            fileSize = file.getSize();
            // get fullpath of opload folder in web root
            
            
			
            // write file to upload folder
            file.write(dirPath + "/" + fileName);
			
             
        } catch (IOException ex) {
            Logger.getLogger(ViewImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}