package model.form;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
/*import javax.servlet.annotation.MultipartConfig;

import org.primefaces.model.LazyDataModel;*/

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienForm {

	private String id;
	private SinhVien sinhVien;
	
	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;
	private List<SinhVien> listSinhVien;

	@ManagedProperty(value = "#{sinhVienDAO}")
	private SinhVienDAO sinhVienDAO;

	// ==============================================================================
	// Init
	// ==============================================================================

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String page = (String) params.get("page");

		currentPage = (page != null && !"".equals(page) && page.matches("[0-9]+")) ? Integer.parseInt(page) : 1;

		int totalRecord = sinhVienDAO.getAllSinhVien().size();
		totalPage = (totalRecord / SinhVienDAO.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) SinhVienDAO.RECORD_IN_PAGE == 0 ? 0 : 1);

		setPageLink();

		listSinhVien = sinhVienDAO.getSinhVienInPage(currentPage);
	}

	// ==============================================================================
	// Getter - Setter
	// ==============================================================================

	public SinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SinhVien> viewAllSinhVien() {
		return sinhVienDAO.getAllSinhVien();
	}

	public String themSinhVien(SinhVien sinhVien) {
		sinhVienDAO.addSinhVien(sinhVien);
		init();
		return "index?faces-redirec=true";
	}

	public String viewEditSinhVien(String maSV) {
		sinhVien = sinhVienDAO.searchSinhVien(maSV);
		return "editSinhVien";
	}

	public String updateSinhVien() {
		sinhVienDAO.editSinhVien(sinhVien);
		init();
		return "index?faces-redirec=true";
	}

	public String viewDeleteSinhVien(String maSV) {
		sinhVien = sinhVienDAO.searchSinhVien(maSV);
		return "deleteSinhVien";
	}

	public String deleteSinhVien(String maSV) {
		sinhVienDAO.deleteSinhVien(maSV);
		init();
		return "index?faces-redirec=true";
	}

	public void showPage() {
		init();
	}

	/*
	 * public String loadSinhVien(int sinhvienId) { Logger.info("loading student:" +
	 * sinhvienId);
	 * 
	 * try { SinhVien theSinhvien = sinhVienDAO.getAllSinhVien(sinhvienId);
	 * 
	 * ExternalContext externalContext =
	 * FacesContext.getCurrentInstance().getExternalContext();
	 * 
	 * Map<String, Object> requestMap = externalContext.getRequestMap();
	 * requestMap.put("sinhvien", theSinhvien);
	 * 
	 * } catch(Exception exc) { Logger.log(Level.SEVERE,"Error loading student id" +
	 * sinhvienId,exc);
	 * 
	 * addErrorMessage(exc);
	 * 
	 * return null; }
	 * 
	 * return "editSinhVien.xhtml"; }
	 */

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
