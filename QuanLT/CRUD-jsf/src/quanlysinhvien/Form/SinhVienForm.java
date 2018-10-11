package quanlysinhvien.Form;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import quanlysinhvien.entity.SinhVien;
import quanlysinhvien.model.SinhVienDao;

@ManagedBean
@SessionScoped
public class SinhVienForm {
	private String id;
	private String name;
	private String age;
	private String gender;
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

//////////////////////////
	@ManagedProperty(value = "#{sinhVienDao}")
	private SinhVienDao sinhVienDAO;
	private List<SinhVien> listSinhVien;

	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public SinhVienDao getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDao(SinhVienDao sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
	}

	public List<SinhVien> viewSinhVien() {
		return sinhVienDAO.getSinhVien();
	}

///////////////////
	public String addSinhVien() {
		SinhVien sv = new SinhVien(name, age, gender, address);
		sinhVienDAO.addSinhVien(sv);
		return "SinhVien?faces-redirect=true";
	}

	public String deleteSinhVien(String id) {

		sinhVienDAO.deleteSinhVien(id);
		return "SinhVien?faces-redirect=true";
	}

	public String updateSinhVien() {
		SinhVien sv = new SinhVien(id, name, age, gender, address);
		sinhVienDAO.editSinhVien(sv);
		return "SinhVien?faces-redirect=true";
	}

	public String viewUpdate(String madm) {
		SinhVien sinhvien = sinhVienDAO.seach(madm);
		id = sinhvien.getId();
		name = sinhvien.getName();
		age = sinhvien.getAge();
		gender = sinhvien.getGender();
		address = sinhvien.getAddress();
		return "updateSinhVien";
	}

////////////////////
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
		int totalRecord = sinhVienDAO.getSinhVien().size();
		totalRecord = (totalRecord / SinhVienDao.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) SinhVienDao.RECORD_IN_PAGE == 0 ? 0 : 1);

		setPageLink();
		listSinhVien = sinhVienDAO.getSinhVienInPage(currentPage);

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
