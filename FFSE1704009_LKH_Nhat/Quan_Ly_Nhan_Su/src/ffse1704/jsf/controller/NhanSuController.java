package ffse1704.jsf.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import ffse1704.jsf.dao.NhanSuDao;
import ffse1704.jsf.entity.NhanSu;
import ffse1704.jsf.entity.TinhThanh;
import ffse1704.jsf.service.Constants;
import ffse1704.jsf.service.Utils;

@ManagedBean
@SessionScoped
public class NhanSuController implements Serializable {
	private static final long serialVersionUID = 1L;

	private int reCordInPage;
	private String indexPage;
	private String allPage;

	private Part file;
	private String message;

	@ManagedProperty(value = "#{nhanSuDao}")
	private NhanSuDao nhanSuDao;

	private List<NhanSu> listNhanSu;
	private List<TinhThanh> listTinhThanh;

	private NhanSu nhanSu;

	@PostConstruct
	public void init() {
		viewListNhanSu();
	}

	public int getReCordInPage() {
		return reCordInPage;
	}

	public void setReCordInPage(int reCordInPage) {
		this.reCordInPage = reCordInPage;
	}

	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

	public String getAllPage() {
		return allPage;
	}

	public void setAllPage(String allPage) {
		this.allPage = allPage;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NhanSuDao getNhanSuDao() {
		return nhanSuDao;
	}

	public void setNhanSuDao(NhanSuDao nhanSuDao) {
		this.nhanSuDao = nhanSuDao;
	}

	public List<NhanSu> getListNhanSu() {
		return listNhanSu;
	}

	public void setListNhanSu(List<NhanSu> listNhanSu) {
		this.listNhanSu = listNhanSu;
	}

	public List<TinhThanh> getListTinhThanh() {
		return listTinhThanh;
	}

	public void setListTinhThanh(List<TinhThanh> listTinhThanh) {
		this.listTinhThanh = listTinhThanh;
	}

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	public void viewListNhanSu() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String page = (String) params.get("page");

		int currentPage = (page != null && !"".equals(page) && Integer.parseInt(page) >= 1) ? Integer.parseInt(page)
				: 1;

		indexPage = String.valueOf(currentPage);

		listNhanSu = nhanSuDao.getAllNhanSu();
		int  allItem = listNhanSu.size();

		reCordInPage = 2;
		String t = String.valueOf(reCordInPage);

		double totalPage = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) totalPage;
		allPage = String.valueOf(total);

		double indexStart = (currentPage - 1) * reCordInPage;
		int s = (int) indexStart;
		listTinhThanh = nhanSuDao.getAllTinhThanh();

		listNhanSu = nhanSuDao.ListPageNhanSu(s, t);

		/* return "index?faces-redirect=true"; */

	}

	public String addNhanSu(NhanSu nhansu) throws IOException {
		String avatar = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		String path = servletContext.getRealPath("");
		boolean file1Success = false;
		if (file != null &&  file.getSize() > 0) {
			avatar = Utils.getFileNameFromPart(file);
			/**
			 * vị trí file lưu
			 */
			File outputFile = new File(path + File.separator + "images" + File.separator + avatar);
			inputStream = file.getInputStream();
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[Constants.BUFFER_SIZE];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			file1Success = true;
		}

		if (file1Success) {
			System.out.println("File đã up tại: " + path);

	

			nhanSu = nhanSuDao.checkIDMax();
			System.out.println("somax la" + nhanSuDao.checkIDMax().getId());
			int idMax = Integer.parseInt(nhanSu.getId());

			int newcount = idMax + 1;
			String exit = String.valueOf(newcount);
			nhansu.setId(exit);
			nhansu.setAvatar(avatar);
			if (nhansu.getHoKhau().equals("1")) {
				setMessage("Chưa chọn Tỉnh ");
				return null;
			} else {
				System.out.println("alalalalalalal"+file);
				nhanSuDao.addNhanSu(nhansu);
				init();
				return "index.xhtml?faces-redirect=true";
			}

		} else {

			setMessage("Chưa chọn ảnh đại diện");
			return null;
		}
		
	}

	public String viewEditNhanSu(String id) {
		nhanSu = nhanSuDao.searchNhanSuEdit(id);
		// put in the session attribute ... so we can use it on the form page
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("editedNhanSu", nhanSu);

		return "edit?faces-redirect=true";
	}

	public String editNhanSu(NhanSu nhansu) throws IOException {
		String avatar = null;

		InputStream inputStream = null;
		OutputStream outputStream = null;
		FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		String path = servletContext.getRealPath("");
		boolean file1Success = false;

		if (file != null && file.getSize() > 0) {
			avatar = Utils.getFileNameFromPart(file);
			/**
			 * vị trí file lưu
			 */
			File outputFile = new File(path + File.separator + "images" + File.separator + avatar);
			inputStream = file.getInputStream();
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[Constants.BUFFER_SIZE];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			file1Success = true;
		}

		if (file1Success) {
			System.out.println("File đã up tại: " + path);
			System.out.println("anh day" + avatar);
			nhansu.setAvatar(avatar);
			nhanSuDao.editNhanSu(nhansu);
		} else {

			nhanSuDao.editNhanSu(nhansu);
		}
		init();
		return "index.xhtml?faces-redirect=true";
	}

	public String viewDeleteNhanSu(String id) {
		nhanSu = nhanSuDao.searchNhanSuDelete(id);
		// put in the session attribute ... so we can use it on the form page
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("checkNhanSu", nhanSu);

		return "delete?faces-redirect=true";
	}

	public String deleteNhanSu(String id) {
		nhanSuDao.deleteNhanSu(id);
		init();
		return "index.xhtml?faces-redirect=true";

	}

}
