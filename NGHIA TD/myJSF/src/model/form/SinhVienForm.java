package model.form;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.dao.UserDao;
import model.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienForm {
	// @ManagedProperty(value="#{userDao}")
	// private UserDao userDao;
	private String id;
	private SinhVien sinhVien;
	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;
	private List<SinhVien> listSinhVien;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
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

	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String page = (String) params.get("page");

		currentPage = (page != null && !"".equals(page) && page.matches("[0-9]+")) ? Integer.parseInt(page) : 1;

		int totalRecord = userDao.getAllUser().size();
		totalPage = (totalRecord / UserDao.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) UserDao.RECORD_IN_PAGE == 0 ? 0 : 1);

		setPageLink();
		listSinhVien = userDao.getSinhVienInPage(currentPage);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<SinhVien> viewAllSinhVien() {

		return userDao.getAllUser();
	}

	/*public void panagition() {
		// tổng số record trong database
		List<SinhVien> ListSV = userDao.getAllUser();
		int totalRecords = ListSV.size();
		// số records muốn hiển thị trên 1 trang
		int recordsOfPage = 1;
		String t = String.valueOf(recordsOfPage);

		// tổng số trang
		double totalPage = totalRecords / recordsOfPage + ((totalRecords % recordsOfPage) == 0 ? 0 : 1);
		int total = (int) totalPage;

		String page = "1";
		// String page =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
		if (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page") != null) {
			page = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
		}
		int a = Integer.parseInt(page);
		int start = (a - 1) * recordsOfPage;
		List<SinhVien> pageList = userDao.searchReCords(start, recordsOfPage);

	}*/

	public String addSV(SinhVien sinhVien) {
		
		userDao.insert(sinhVien);
		init();
		return "index?faces-redirect=true";
	}

	public String Edit() {

		userDao.edit(sinhVien);
		init();
		return "index?faces-redirect=true";
	}

	public String viewEditSinhVien(String maSV) {
		SinhVien sinhVien = userDao.searchUser(maSV);
		id = sinhVien.getId();

		return "Edit";

	}

	public void DeleteSinhVien(String sv) {
		userDao.delete(sv);
		init();
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
