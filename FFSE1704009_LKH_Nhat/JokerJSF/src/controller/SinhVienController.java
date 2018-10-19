package controller;

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

import model.dao.SinhVienDao;
import model.entity.SinhVien;
import model.service.Constants;
import model.service.Utils;

@ManagedBean
@SessionScoped
public class SinhVienController implements Serializable {
	private static final long serialVersionUID = 1L;
	private String indexPage;
	private String allPage;

	private Part file;
	private String message;

	@ManagedProperty(value = "#{sinhVienDao}")
	private SinhVienDao sinhVienDao;
	
	private List<SinhVien> listSinhVien;
	
	private SinhVien sinhVien;

	/*------------------------------------------------------Exception-----------------------------------------------------*/
	
	
	
	
	
	/*-----------------------------------------------------------------------------------------------------------------------*/
	@PostConstruct
	public void init() {
		/* listSinhVien = sinhVienDao.pageSinhVien(0, "2"); */
		pageSV();
	}


	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
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
		
		  // put in the session attribute ... so we can use it on the form page
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("editedStudent", sinhVien);

		return "edit?faces-redirect=true";
	}

	public String deleteSV(String idSV) {
		sinhVienDao.deleteSinhVien(idSV);
		return "list.xhtml?faces-redirect=true";

	}

	public String editSV(SinhVien sv) throws IOException{
		String avatar = null;
		
		 InputStream inputStream = null;
	        OutputStream outputStream = null;
	        FacesContext context = FacesContext.getCurrentInstance();
	        ServletContext servletContext = (ServletContext) context
	                .getExternalContext().getContext();
	        String path = servletContext.getRealPath("");
	        boolean file1Success = false;
	        if (file.getSize() > 0) {
	        	avatar = Utils.getFileNameFromPart(file);
	            /**
	            *vị trí file lưu
	            */
	            File outputFile = new File(path + File.separator + "images"
	                    + File.separator + avatar);
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
	            
	            setMessage("File đã được tải lên " + path);
	            
	            System.out.println("anh day"+avatar);
	            sv.setAvatar(avatar);
	    		sinhVienDao.editSinhVien(sv);
	        } else {
	           
	            setMessage("Lỗi !");
	        }
		
		
		return "list.xhtml?faces-redirect=true";
	}

	public String addSV(SinhVien sv)  throws IOException {
		String avatar = null;
		InputStream inputStream = null;
        OutputStream outputStream = null;
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context
                .getExternalContext().getContext();
        String path = servletContext.getRealPath("");
        boolean file1Success = false;
        if (file.getSize() > 0) {
        	avatar = Utils.getFileNameFromPart(file);
            /**
            *vị trí file lưu
            */
            File outputFile = new File(path + File.separator + "images"
                    + File.separator + avatar);
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
            
            setMessage("File đã được tải lên " + path);
            sv.setAvatar(avatar);
    		sinhVienDao.addSinhVien(sv);
    		
        } else {
           
            setMessage("Lỗi !");
        }
		
		return "list.xhtml?faces-redirect=true";
	}

	public void pageSV() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String page = (String) params.get("page");

		int currentPage = (page != null && !"".equals(page) && Integer.parseInt(page)< 1) ? Integer.parseInt(page) : 1;

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
		System.out.println(currentPage + "day");
		listSinhVien = sinhVienDao.pageSinhVien(s, t);
		 String addFile = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");
		 System.out.println(addFile);
		 File fileAdd = new File(addFile);
		 if(!fileAdd.exists()) {
			 fileAdd.mkdirs();
		 }
				 
		/* return "list?faces-redirect=true"; */

	}

	/*public String listSV() {
		// listSinhVien = sinhVienDao.getAllSinhVien();
		listSinhVien = sinhVienDao.pageSinhVien(0, "5");
		int count = listSinhVien.size();
		
		return "list";
	}
	*/
	

}
