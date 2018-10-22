package ffse1704.jsfstaff.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import ffse1704.jsfsatff.entity.NhanVien;
import ffse1704.jsfsatff.entity.tinhThanh;
import ffse1704.jsfstaff.dao.NhanVienDAO;

@ManagedBean
@SessionScoped
public class NhanVienController {
	@PostConstruct
    public void init() {
         listTinhThanh = nhanVienDao.getListTinhThanh();
    }
	// getParameter
	private String maNhanVien;
	private String tenNhanVien;
	private String namSinh;
	private String gioiTinh;
	private String hoKhau;
	private String images;

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(String hoKhau) {
		this.hoKhau = hoKhau;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	///// listNhanVien and DAO

	@ManagedProperty(value = "#{nhanVienDAO}")
	private NhanVienDAO nhanVienDao;
	private List<NhanVien> listNhanVien;
	private List<tinhThanh> listTinhThanh;
	// get set listNhanVien and DAO

	public NhanVienDAO getNhanVienDao() {
		return nhanVienDao;
	}

	public void setNhanVienDao(NhanVienDAO nhanVienDao) {
		this.nhanVienDao = nhanVienDao;
	}

	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

	/// list tỉnh thành
	public List<tinhThanh> getListTinhThanh() {
		return listTinhThanh;
	}

	public void setListTinhThanh(List<tinhThanh> listTinhThanh) {
		this.listTinhThanh = listTinhThanh;
	}

		
	
	
	
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

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private int totalPage = 1;
	private int currPage = 1;
	private int perPage = 3;

	
	public void NVController() throws Exception {
		listTinhThanh = nhanVienDao.getListTinhThanh();

		// Get list of staff
		loadNhanVienListByPage();
	}
	
	public void loadNhanVienList() {
		listNhanVien = nhanVienDao.ListNhanVien();
		totalPage = (int)Math.ceil(listNhanVien.size() * 1.0 / perPage);
	}
	
	public void loadNhanVienListByPage() {
		listNhanVien = nhanVienDao.getListNhanVienByPage(currPage, perPage);
		totalPage = (int)Math.ceil(nhanVienDao.countNhanVien() * 1.0 / perPage);
	}

	public void goPage(int page) {
		currPage = page;
		if (currPage < 1) {
			currPage = 1;
		}
		else if (currPage > totalPage) {
			currPage = totalPage;
		}

		loadNhanVienListByPage();
	}
	///// CRUD//////
	public String delete(String maNhanVien) {
		nhanVienDao.delete(maNhanVien);
		return "NhanVien?faces-redirect=true";
	}

	public String addNhanVien(NhanVien nhanvien) {
		upload();
		nhanvien.setImages(fileName);
		nhanVienDao.add(nhanvien);
		return "NhanVien?faces-redirect=true";
	}

	public String editNhanVien() {
		upload();
		NhanVien nhanvien = new NhanVien(maNhanVien, tenNhanVien, namSinh, gioiTinh, hoKhau, images);
		nhanvien.setImages(fileName);
		nhanVienDao.update(nhanvien);
		return "NhanVien?faces-redirect=true";
	}

	public String viewEditNhanVien(String maNV) {
		NhanVien nhanvien = nhanVienDao.seach(maNV);

	
		// put in the session attribute ... so we can use it on the form page
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("checkEditNhanSu", nhanvien);


		return "EditNhanVien?faces-redirect=true";

	}

	public String viewDeleteNhanVien(String maNV) {
		NhanVien nhanvien = nhanVienDao.seach(maNV);


		// put in the session attribute ... so we can use it on the form page
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("checkDeleteNhanSu", nhanvien);


		return "Delete?faces-redirect=true";

	}

	private int reCordInPage;
	private String indexPage;
	private String allPage;
	
	
	public int getReCordInPage() {
		return reCordInPage;
	}

	public void setReCordInPage(int reCordInPage) {
		this.reCordInPage = reCordInPage;
	}

	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

	public String getAllPage() {
		return allPage;
	}

	public void setAllPage(String allPage) {
		this.allPage = allPage;
	}

	

	///// upload file//////

	private Part file;
	private String fileName;
	private long fileSize;

	/**
	 * Creates a new instance of Upload_File
	 */
	public NhanVienController() {

	}

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
			// get fullpath of opload folder in web root
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
			File fileDir = new File(dirPath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();

			}
			// write file to upload folder
			file.write(dirPath + "/" + fileName);

		} catch (IOException ex) {

			Logger.getLogger(NhanVienController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
