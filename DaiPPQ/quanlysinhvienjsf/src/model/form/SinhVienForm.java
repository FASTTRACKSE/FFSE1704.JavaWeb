package model.form;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

@ManagedBean
@SessionScoped
public class SinhVienForm {
	private String id;
	private String masv;
	private String ho;
	private String ten;
	private String gioiTinh;
	private String namsinh;
	private String lop;
	private String images;
	
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

	private int currentPage;
	private int totalPage;
	private Integer[] pageLink;

	private List<SinhVien> listSinhVien;

	@ManagedProperty(value = "#{sinhVienDAO}")
	private SinhVienDAO sinhVienDAO;

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		java.lang.String page = (String) params.get("page");
		
		currentPage = (page != null && !"".equals(page) && page.matches("[0-9]+")) ? Integer.parseInt(page) : 1;
		
		int totalRecord = sinhVienDAO.getAllSinhVien().size();
		totalPage = (totalRecord / SinhVienDAO.RECORD_IN_PAGE) + ((double) totalRecord % (double) SinhVienDAO.RECORD_IN_PAGE == 0 ? 0 : 1);
		
		//config page link
		setPageLink();
		
		listSinhVien = sinhVienDAO.getSinhVienInPage(currentPage);

	}

	public SinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
	}

	public List<SinhVien> viewAllSinhVien() {
		return sinhVienDAO.getAllSinhVien();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	
	public String getimages() {
		return images;
	}

	public void setimages(String images) {
		this.images = images;
	}

	public String addSinhVien() {
		SinhVien sv = new SinhVien(masv, ho, ten, gioiTinh, namsinh, lop, images);
		sinhVienDAO.addSinhVien(sv);
		init();
		return "index?faces-redirect=true";
	}

	public String viewEditSinhVien(String ID) {
		SinhVien sinhvien = sinhVienDAO.searchSinhVien(ID);
		id = sinhvien.getId();
		masv = sinhvien.getMasv();
		ho = sinhvien.getHo();
		ten = sinhvien.getTen();
		gioiTinh = sinhvien.getGioiTinh();
		namsinh = sinhvien.getNamsinh();
		lop = sinhvien.getLop();
		return "editsinhvien";
	}
	
	public String updateSinhVien() {
		SinhVien sv = new SinhVien(id, masv, ho, ten, gioiTinh, namsinh, lop, images);
		sinhVienDAO.editSinhVien(sv);
		init();
		return "index?faces-redirect=true";
		
	}
	
	public void deleteSinhVien(String id) {
		sinhVienDAO.deleteSinhVien(id);
		init();
		//return "index?faces-redirect=true";
	}
	
	public void showPage() {
		init();
	}
	
	private void setPageLink() {
		if (currentPage == 1 && totalPage == 1) {
			pageLink = new Integer[] {1};
		} else if (currentPage < 3 && totalPage > 1) {
			int endPageLink = totalPage;
			if (totalPage > 2) {
				endPageLink = 3;
			}
			pageLink = new Integer[endPageLink];
			for (int i = 0; i <endPageLink; i++) {
				pageLink[i] = i + 1;
			}
		} else if (currentPage == totalPage) {
			pageLink = new Integer[] {currentPage - 2, currentPage - 1, currentPage};
		} else {
			pageLink = new Integer[] {currentPage - 1, currentPage, currentPage + 1};
		}
	}
	
	//upload file
	
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
            // write file to upload folder
            file.write(dirPath + "/" + fileName);
             
        } catch (IOException ex) {
            //Logger.getLogger(Upload_File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public long getFileSize() {
        return fileSize;
    }
 
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
