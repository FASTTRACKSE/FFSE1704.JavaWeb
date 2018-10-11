package model.form;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.bean.*;
import model.dao.*;

@ManagedBean
@RequestScoped
public class SinhVienForm {

	

	

	private String id;
	private String user, password, fullname;

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
		SinhVien sv = new SinhVien(user, password, fullname);
		sinhVienDao.getaddUser(sv);
		return "index?faces-redirect=true";

	}

	public String delSinhVien(String id) {
		sinhVienDao.getdeleteUser(id);
		return "index?faces-redirect=true";

	}

	public String editSinhVien() {
		SinhVien sv = new SinhVien(id, user, password, fullname);
		sinhVienDao.getupdateUser(sv);
		
		return "index?faces-redirect=true";

	}

	public String viewEdit(String maSV) {
		SinhVien sinhvien = sinhVienDao.showtt(maSV);
		id = sinhvien.getId();
		user = sinhvien.getUser();
		password = sinhvien.getPassword();
		fullname = sinhvien.getFullname();
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
		String page = (String) params.get("page");
		currentPage = (page != null && page.matches("[0-9]+")) ? Integer.parseInt(page) : 1;
		int totalRecord = sinhVienDao.getAllUser().size();
		totalRecord = (totalRecord / SinhVienDao.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) SinhVienDao.RECORD_IN_PAGE == 0 ? 0 : 1);

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
}
