package fasttrackse.jsfsample.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fasttrackse.jsfsample.service.PaginationService;

@ManagedBean
@SessionScoped
public class HelloBean {

	@ManagedProperty(value = "#{paginationService}")
	PaginationService paginationService;

	private String pageNo = "1";

	public String getFirstPage() {
		this.pageNo = paginationService.firstPage();
		return "index";
	}

	public String getLastPage() {
		this.pageNo = paginationService.lastPage();
		return "index";
	}

	public String getPrevPage() {
		this.pageNo = paginationService.prevPage(this.pageNo);
		return "index";
	}

	public String getNextPage() {
		this.pageNo = paginationService.nextPage(this.pageNo);
		return "index";
	}

	public String getPrev10Page() {
		this.pageNo = paginationService.prev10Page(this.pageNo);
		return "index";
	}

	public String getNext10Page() {
		this.pageNo = paginationService.next10Page(this.pageNo);
		return "index";
	}

	public PaginationService getPaginationService() {
		return paginationService;
	}

	public void setPaginationService(PaginationService paginationService) {
		this.paginationService = paginationService;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

}
