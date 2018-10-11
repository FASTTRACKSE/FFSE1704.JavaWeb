package model.form;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

	public String addSinhVien() {
		SinhVien ad = new SinhVien(maSinhVien, tenSinhVien, tuoiSinhVien, lopHoc, diaChi);
		sinhVienDao.add(ad);
		init();
		return "SinhVien?faces-redirect=true";
	}

	public String editSinhVien() {
		SinhVien ed = new SinhVien(maSinhVien, tenSinhVien, tuoiSinhVien, lopHoc, diaChi);
		sinhVienDao.add(ed);
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

}
