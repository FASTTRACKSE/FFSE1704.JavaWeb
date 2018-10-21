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

import model.bean.SinhVien;
import model.dao.SinhVienDao;

@ManagedBean
@SessionScoped
public class SinhVienForm {

	private String id;
	private String user, password, fullname, image;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@ManagedProperty(value = "#{sinhVienDao}")
	private SinhVienDao sinhVienDao;
	private List<SinhVien> listSinhVien;

	public SinhVienDao getSinhVienDao() {
		return sinhVienDao;
	}

	public void setSinhVienDao(SinhVienDao sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
	}

	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public List<SinhVien> viewSinhVien() {
		return sinhVienDao.getAllUser();
	}

	public String addSinhVien() {
		upload();
		SinhVien sv = new SinhVien(user, password, fullname, image);
		sv.setImage(fileName);
		sinhVienDao.getaddUser(sv);
		init();
		return "index?faces-redirect=true";

	}

	public String delSinhVien(String id) {
		sinhVienDao.getdeleteUser(id);
		init();
		return "index?faces-redirect=true";

	}

	public String editSinhVien() {
		SinhVien sv = new SinhVien(id, user, password, fullname, image);
		sinhVienDao.getupdateUser(sv);
		init();
		return "index?faces-redirect=true";

	}

	public String viewEdit(String maSV) {
		SinhVien sinhvien = sinhVienDao.showtt(maSV);
		id = sinhvien.getId();
		user = sinhvien.getUser();
		password = sinhvien.getPassword();
		fullname = sinhvien.getFullname();
		image = sinhvien.getImage();
		return "edit";
	}

	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;
	private SinhVien sinhvienDao;

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

	public SinhVien getSinhvienDao() {
		return sinhvienDao;
	}

	public void setSinhvienDao(SinhVien sinhvienDao) {
		this.sinhvienDao = sinhvienDao;
	}

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		java.lang.String page = (String) params.get("page");

		currentPage = (page != null && !"".equals(page) && page.matches("[0-9]+")) ? Integer.parseInt(page) : 1;

		int totalRecord = sinhVienDao.getAllUser().size();
		totalPage = (totalRecord / sinhVienDao.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) sinhVienDao.RECORD_IN_PAGE == 0 ? 0 : 1);

		// config page link
		setPageLink();

		listSinhVien = sinhVienDao.getSinhVienInPage(currentPage);

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

	private Part file;
	private String fileName;
	private long fileSize;

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

	public  void upload() {
		try {
			// get name of selected file
			fileName = file.getSubmittedFileName();
			// get file's size
			fileSize = file.getSize();
			// get fullpath of opload folder in web root
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
			// write file to upload folder
			File path = new File(dirPath);

			if (!path.exists()) {
				path.mkdirs();
			}

			file.write(dirPath + "/" + fileName);

		} catch (IOException ex) {
			Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
