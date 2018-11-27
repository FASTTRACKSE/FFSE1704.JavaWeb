package fasttrackse.jsfsample.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "paginationService")
@SessionScoped
public class PaginationService {

	public String firstPage() {
		return "1";
	}
	
	public String lastPage() {
		return "115";
	}

	public String prevPage(String page) {
		Integer iPage = Integer.parseInt(page) - 1;
		if (iPage < 1) {
			iPage = 1;
		}
		
		return  iPage.toString();
	}
	
	public String prev10Page(String page) {
		Integer iPage = Integer.parseInt(page) - 10;
		if (iPage < 1) {
			iPage = 1;
		}
		
		return  iPage.toString();
	}
	
	public String nextPage(String page) {
		Integer iPage = Integer.parseInt(page) + 1;
		Integer totalPage = Integer.parseInt(this.lastPage());
		if (iPage > totalPage) {
			iPage = totalPage;
		}
		
		return  iPage.toString();
	}
	
	public String next10Page(String page) {
		Integer iPage = Integer.parseInt(page) + 10;
		Integer totalPage = Integer.parseInt(this.lastPage());
		if (iPage > totalPage) {
			iPage = totalPage;
		}
		
		return  iPage.toString();
	}

}