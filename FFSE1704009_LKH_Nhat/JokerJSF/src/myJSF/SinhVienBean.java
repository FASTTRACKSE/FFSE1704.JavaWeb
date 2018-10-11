package myJSF;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.dao.SinhVienDao;
import model.entity.SinhVien;

@ManagedBean
@RequestScoped
public class SinhVienBean {
	private String tenSinhVien;
	private String maSinhVien;
	private String lopHoc;
	private String tuoiSinhVien;
	private String gioiTinh;
	private String diaChi;
	private String soDT;
	private String email;
	private String indexPage;
	private String allPage;

	@ManagedProperty(value = "#{sinhVienDao}")
	private SinhVienDao sinhVienDao;
	private List<SinhVien> listSinhVien;
	private SinhVien sinhVien;

	@PostConstruct
	public void init() {
		/*listSinhVien = sinhVienDao.pageSinhVien(0, "2");*/
		pageSV();
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public String getTuoiSinhVien() {
		return tuoiSinhVien;
	}

	public void setTuoiSinhVien(String tuoiSinhVien) {
		this.tuoiSinhVien = tuoiSinhVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

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

	public String getAllPage() {
		return allPage;
	}

	public void setAllPage(String allPage) {
		this.allPage = allPage;
	}
	// CRUD

	public String searchSVEdit(String idSV) {
		sinhVien = sinhVienDao.searchSinhVien(idSV);
		maSinhVien = sinhVien.getMaSinhVien();
		tenSinhVien = sinhVien.getTenSinhVien();
		lopHoc = sinhVien.getLopHoc();
		tuoiSinhVien = sinhVien.getTuoiSinhVien();
		gioiTinh = sinhVien.getGioiTinh();
		diaChi = sinhVien.getDiaChi();
		soDT = sinhVien.getSoDT();
		email = sinhVien.getEmail();
		return "edit";
	}

	public String deleteSV(String idSV) {
		sinhVienDao.deleteSinhVien(idSV);
		return "list.xhtml?faces-redirect=true";

	}

	public String editSV() {
		SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, lopHoc, tuoiSinhVien, gioiTinh, diaChi, soDT, email);
		sinhVienDao.editSinhVien(sv);
		return "list.xhtml?faces-redirect=true";
	}

	public String addSV() {
		SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, lopHoc, tuoiSinhVien, gioiTinh, diaChi, soDT, email);
		sinhVienDao.addSinhVien(sv);
		return "list.xhtml?faces-redirect=true";
	}

	public void pageSV() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String page = (String) params.get("page");
		
		 int currentPage = (page !=null && !"".equals(page) && page.matches("[1-9]+")) ? Integer.parseInt(page) : 1;
		
		 indexPage = String.valueOf(currentPage);
		

		listSinhVien = sinhVienDao.getAllSinhVien();
		int allItem = listSinhVien.size();

		int reCordInPage = 2;
		String t = String.valueOf(reCordInPage);

		double totalPage = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) totalPage;
		allPage = String.valueOf(total);

		double indexStart = (currentPage - 1) * reCordInPage;
		int s = (int) indexStart;
		listSinhVien = sinhVienDao.pageSinhVien(s, t);
		/*return "list?faces-redirect=true";*/

	}

	public String listSV() {
		//listSinhVien = sinhVienDao.getAllSinhVien();
		listSinhVien = sinhVienDao.pageSinhVien(0, "5");
		int count = listSinhVien.size();
		System.out.println(count);
		return "list";
	}

}
