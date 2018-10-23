package model.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.dao.NhanVienDAO;
import model.entity.NhanVien;

@ManagedBean
@SessionScoped
public class StaffController {
	private String id;
	private NhanVien nhanVien;	
	
	private List<NhanVien> listNhanVien;

	@ManagedProperty(value = "#{nhanVienDAO}")
	private NhanVienDAO nhanVienDAO;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}	

	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

	public NhanVienDAO getNhanVienDAO() {
		return nhanVienDAO;
	}

	public void setNhanVienDAO(NhanVienDAO nhanVienDAO) {
		this.nhanVienDAO = nhanVienDAO;
	}
	
	// get out nv
	public List<NhanVien> viewAllNhanVien() {
		return nhanVienDAO.getAllNhanVien();
	}
	//
	
	//Phan trang thay Thang
	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;
	
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

		int totalRecord = nhanVienDAO.getAllNhanVien().size();
		totalPage = (totalRecord / NhanVienDAO.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) NhanVienDAO.RECORD_IN_PAGE == 0 ? 0 : 1);

		setPageLink();
		listNhanVien = NhanVienDAO.getNhanVienInPage(currentPage);
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
