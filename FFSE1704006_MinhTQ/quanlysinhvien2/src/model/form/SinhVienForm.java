package model.form;


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
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.primefaces.mobile.component.field.Field;

import model.Dao.SinhVienDAO;
import model.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienForm {
	private SinhVien sinhVienDAO;
	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;

	public SinhVien getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVien sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
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

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String page = (String) params.get("page");
		currentPage = (page != null && !"".equals(page) && page.matches("[0-9]+")) ? Integer.parseInt(page) : 1;
		int totalRecord = sinhVienDao.getAllSinhVien().size();
		totalPage = (totalRecord / SinhVienDAO.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) SinhVienDAO.RECORD_IN_PAGE == 0 ? 0 : 1);

		// cofig page link
		setPageLink();

		listSinhVien = sinhVienDao.getSinhVienInPage(currentPage);
	}

	private String maSinhVien;
	private String tenSinhVien;
	private String tuoiSinhVien;
	private String lopHoc;
	private String diaChi;
	private String images;

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	//////
	@ManagedProperty(value = "#{sinhVienDAO}")
	private SinhVienDAO sinhVienDao;
	private List<SinhVien> listSinhVien;

	public SinhVienDAO getSinhVienDao() {
		return sinhVienDao;
	}

	public void setSinhVienDao(SinhVienDAO sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
	}

	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	/// view list/////
	public List<SinhVien> viewSinhVien() {
		return sinhVienDao.getAllSinhVien();
	}

	///// CRUD//////
	public String delete(String id) {
		sinhVienDao.delete(id);
		init();
		return "SinhVien?faces-redirect=true";
	}

	public String addSinhVien(SinhVien sinhvien) {
		upload();
		sinhvien.setImages(fileName);
		sinhVienDao.add(sinhvien);
		init();
		return "SinhVien?faces-redirect=true";
	}

	public String editSinhVien() {
		upload();
		SinhVien sinhvien = new SinhVien(maSinhVien, tenSinhVien, tuoiSinhVien, lopHoc, diaChi, images);
		sinhvien.setImages(fileName);
		sinhVienDao.edit(sinhvien);
		init();
		return "SinhVien?faces-redirect=true";
	}

	public String viewEditSinhVien(String maSV) {
		SinhVien sinhvien = sinhVienDao.seach(maSV);

		maSinhVien = sinhvien.getMaSinhVien();
		tenSinhVien = sinhvien.getTenSinhVien();
		tuoiSinhVien = sinhvien.getTuoiSinhVien();
		lopHoc = sinhvien.getLopHoc();
		diaChi = sinhvien.getDiaChi();
	
		return "EditSinhVien";

	}

	public void showPage() {
		init();
	}

	public void setPageLink() {
		if (currentPage == 1 && totalPage == 1) {
			pageLink = new Integer[] { 1 };
		} else if (currentPage < 3 && totalPage > 1) {
			int endpageLink = totalPage;
			if (totalPage > 2) {
				endpageLink = 3;
			}
			pageLink = new Integer[endpageLink];
			for (int i = 0; i < endpageLink; i++) {
				pageLink[i] = i + 1;
			}
		} else if (currentPage == totalPage) {
			pageLink = new Integer[] { currentPage - 2, currentPage - 1, currentPage };
		} else {
			pageLink = new Integer[] { currentPage - 1, currentPage, currentPage + 1 };
		}
	}

	///// upload file//////

	private Part file;
	private String fileName;
	private long fileSize;

	/**
	 * Creates a new instance of Upload_File
	 */
	public SinhVienForm() {

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
			File fileDir= new File(dirPath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();

			}
			// write file to upload folder
			file.write(dirPath + "/" + fileName);

		} catch (IOException ex) {

			Logger.getLogger(SinhVienForm.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
