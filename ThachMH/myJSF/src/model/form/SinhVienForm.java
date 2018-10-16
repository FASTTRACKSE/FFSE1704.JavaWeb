package model.form;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.DAO.SinhVienDao;
import model.bean.SinhVien;

@ManagedBean
@SessionScoped
@RequestScoped
public class SinhVienForm {
	private SinhVien sinhVienDAO;
	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;
	public SinhVien getsinhVienDAO() {
		return sinhVienDAO;
	}
	public void setMaSinhVienDAO(SinhVien sinhVienDAO) {
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
		int totalRecord = sinhVienDao.getSinhVien().size();
		totalPage = (totalRecord / sinhVienDao.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) sinhVienDao.RECORD_IN_PAGE == 0 ? 0 : 1);

		// cofig page link
		setPageLink();

		listSinhVien = sinhVienDao.getSinhVienInPage(currentPage);
	}
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return sinhVienDao.getSinhVien();
	}

	public String addSinhVien() {
		SinhVien sv = new SinhVien(name, email, password, gender, address);
		SinhVienDao.addSinhVien(sv);
		return "sinhvien?faces-redirect=true";

	}

	public String editSinhVien() {
		SinhVien sv = new SinhVien(id, name, email, password, gender, address);
		SinhVienDao.editSinhVien(sv);
		return "sinhvien?faces-redirect=true";
	}

	public String viewEdit(String maSV) {
		SinhVien sinhvien = sinhVienDao.seach(maSV);
		id = sinhvien.getId();
		name = sinhvien.getName();
		email = sinhvien.getemail();
		password = sinhvien.getAddress();
		gender = sinhvien.getGender();
		address = sinhvien.getAddress();
		return "edit";
	}

	public String deleteSinhVien(String maSV) {
		sinhVienDao.delete(maSV);
		return "SinhVien?faces-redirect=true";
	}
	public void showPage() {
		init();
	}
	
	public void setPageLink() {
		if (currentPage == 1 && totalPage == 1) {
			pageLink = new Integer[] {1};
		}else if(currentPage < 3 && totalPage >1) {
			int endpageLink = totalPage;
			if (totalPage > 2) {
				endpageLink = 3;
			}
			pageLink = new Integer[endpageLink];
			for (int i = 0; i < endpageLink; i++) {
				pageLink[i] = i + 1;
				
			}
		}else if (currentPage == totalPage) {
				pageLink = new Integer[] { currentPage - 2, currentPage - 1, currentPage };
		}else {
				pageLink = new Integer[] { currentPage - 1, currentPage, currentPage + 1};
		}
	}
}