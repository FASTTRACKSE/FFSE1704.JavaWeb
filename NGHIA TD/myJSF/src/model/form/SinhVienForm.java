package model.form;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

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

	
	public String addSV(SinhVien sinhVien) {
		upload();

		sinhVien.setImages(fileName);
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
		 sinhVien = userDao.searchUser(maSV);
		
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

    private Part file;
    private String fileName;
    private long fileSize;
  
 
    public Part getFile() {
        return file;
    }
 
    public void setFile(Part file) {
        this.file = file;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
     
    public void upload()
    {
        try {
            // get name of selected file
            fileName = file.getSubmittedFileName();
            // get file's size
            fileSize = file.getSize();
            // get fullpath of opload folder in web root
            String dirPath= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");
            
            File fileDir= new File(dirPath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			
			
            // write file to upload folder
            file.write(dirPath + "/" + fileName);
			
             
        } catch (IOException ex) {
            Logger.getLogger(Upload_File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public long getFileSize() {
        return fileSize;
    }
 
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }


}
