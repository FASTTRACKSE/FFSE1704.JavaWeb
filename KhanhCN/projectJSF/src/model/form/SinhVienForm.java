package model.form;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

@ManagedBean
@SessionScoped
public class SinhVienForm {
	
	private SinhVien sinhvien;
	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;

	public SinhVien getSinhvien() {
		return sinhvien;
	}

	public void setSinhvien(SinhVien sinhvien) {
		this.sinhvien = sinhvien;
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
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		String page = (String) params.get("page");
		currentPage = (page != null && page.matches("[0-9]+")) ? Integer.parseInt(page) : 1;
		int totalRecord = sinhvienDao.getAllSinhVien().size();
		totalRecord = (totalRecord / sinhvienDao.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) sinhvienDao.RECORD_IN_PAGE == 0 ? 0 : 1);
		setPageLink();

		listsinhvien = sinhvienDao.getSinhVienInPage(currentPage);

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

	private String MASV;
	private String TEN;
	private String PASS;

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getTEN() {
		return TEN;
	}

	public void setTEN(String tEN) {
		TEN = tEN;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pASS) {
		PASS = pASS;
	}

	@ManagedProperty(value = "#{sinhVienDAO}")
	private SinhVienDAO sinhvienDao;
	private List<SinhVien> listsinhvien;

	public List<SinhVien> getListsinhvien() {
		return listsinhvien;
	}

	public void setListsinhvien(List<SinhVien> listsinhvien) {
		this.listsinhvien = listsinhvien;
	}

	public SinhVienDAO getSinhvienDao() {
		return sinhvienDao;
	}

	public void setSinhvienDao(SinhVienDAO sinhvienDao) {
		this.sinhvienDao = sinhvienDao;
	}

	// get
	public List<SinhVien> viewSinhVien() {
		return sinhvienDao.getAllSinhVien();
	}

	// crud

	public String addSinhVien() {
		SinhVien sv = new SinhVien(MASV, TEN, PASS);
		sinhvienDao.addSinhVien(sv);
		init();
		return "SinhVien?faces-redirect=true";
	}

	public String deleteSinhVien(String maSV) {
		sinhvienDao.deleteSinhVien(maSV);
		init();
		return "SinhVien?faces-redirect=true";

	}

	public String editSinhVien() {
		SinhVien sv = new SinhVien(MASV, TEN, PASS);
		sinhvienDao.updateSinhVien(sv);
		init();
		return "SinhVien?faces-redirect=true";
	}

	public String viewEditSinhVien(String maSV) {
		SinhVien sinhVien = sinhvienDao.seach(maSV);
		MASV = sinhVien.getMASV();
		TEN = sinhVien.getTEN();
		PASS = sinhVien.getPASS();
		return "editStudent";
	}
}
