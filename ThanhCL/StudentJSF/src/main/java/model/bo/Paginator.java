package model.bo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "paginator")
@SessionScoped
public class Paginator {
	private static final int DEFAULT_RECORDS_NUMBER = 10;
	private static final int DEFAULT_PAGE_INDEX = 1;

	private int records;
	private int recordsTotal;
	private int pageIndex;
	private int pages;

	public void setUserList(int countRecords) {
		this.records = DEFAULT_RECORDS_NUMBER;
		this.pageIndex = DEFAULT_PAGE_INDEX;
		this.recordsTotal = countRecords;

		if (records > 0) {
			pages = records <= 0 ? 1 : recordsTotal / records;

			if (recordsTotal % records > 0) {
				pages++;
			}

			if (pages == 0) {
				pages = 1;
			}
		} else {
			records = 1;
			pages = 1;
		}
	}

	public void next() {
		if (this.pageIndex < pages) {
			this.pageIndex += 1;
		}
	}

	public void prev() {
		if (this.pageIndex > 1) {
			this.pageIndex--;
		}
	}

	public void firstPage() {
		this.pageIndex = 1;
	}

	public void lastPage() {
		this.pageIndex = pages;
	}

	public int getRecords() {
		return records;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getPages() {
		return pages;
	}

	public int getFromIndex() {
		return (pageIndex * records) - records;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
