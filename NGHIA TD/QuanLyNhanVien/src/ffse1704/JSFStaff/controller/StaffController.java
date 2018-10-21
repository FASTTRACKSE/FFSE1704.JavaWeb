package ffse1704.JSFStaff.controller;

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

import ffse1704.JSFStaff.dao.StaffDAO;
import ffse1704.JSFStaff.entity.NhanVien;
import ffse1704.JSFStaff.entity.TinhThanhPho;
import ffse1704.JSFStaff.until.ViewImage;





@ManagedBean
@SessionScoped
public class StaffController {

	private List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	private List<TinhThanhPho> dsTinhThanh = new ArrayList<TinhThanhPho>();
	private StaffDAO staffDAO = new StaffDAO();
	
	private int currentPage = 1;
	private int perPage	 = 1;
	private int totalPage = 1;
	final String dirPath = "E:\\HOCT\\images";
	private String fileName = "";
	private Part file;
	private long fileSize;
	
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
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
	public List<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}
	public void setDsNhanVien(List<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}
	public List<TinhThanhPho> getDsTinhThanh() {
		return dsTinhThanh;
	}
	public void setDsTinhThanh(List<TinhThanhPho> dsTinhThanh) {
		this.dsTinhThanh = dsTinhThanh;
	}
	public StaffDAO getStaffDAO() {
		return staffDAO;
	}
	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public StaffController() throws Exception {
		dsTinhThanh = staffDAO.getListTinhThanh();
		
		// lấy ds nhân viên và phân trang
		loadListStaffPage();
	}
	
	//list nhân viên có phân trang và totalpage
	public void loadListStaffPage() {
		dsNhanVien = staffDAO.getListNhanVienByPage(currentPage, perPage);
		totalPage = (int)Math.ceil(staffDAO.countNhanVien() * 1.0/perPage);
	}
	//list nhân viên không có phân trang và totalpage
	public void loadListStaff() {
		dsNhanVien = staffDAO.getAllStaff();
		totalPage = (int)Math.ceil(dsNhanVien.size() * 1.0/perPage);
	}
	
	//lấy ds 1 nhân viên dựa trên id
	public String getStaffById(int id){
		NhanVien nv = staffDAO.getNhanVienbyId(id);
		sessionMap.put("editStaff", nv);
		
		return "update-Staff?faces-redirect=true";
	}
	//update nhân viên
	public String updateStaff(NhanVien nv) {
		staffDAO.updateNhanVien(nv);
		loadListStaffPage();
		return "index?faces-redirect=true";
	}
	public String createStaff(NhanVien nv) {
		upload();
		nv.setImages(fileName);
		staffDAO.addNewNhanVien(nv);
		loadListStaffPage();
		return "index?faces-redirect=true";
	}
	
	public void goPage(int page) {
		currentPage = page;
		if(currentPage<1) {
			currentPage =1;
		}
		else if(currentPage > totalPage) {
			currentPage= totalPage;
		}
		loadListStaffPage();
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
