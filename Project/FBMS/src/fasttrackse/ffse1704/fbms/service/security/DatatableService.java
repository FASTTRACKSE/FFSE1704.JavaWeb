package fasttrackse.ffse1704.fbms.service.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.ChucNang;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface DatatableService {

	public String getSearchQuery(HttpServletRequest request, String[] columnNames, String customCondition);

	public String getSortQuery(HttpServletRequest request, String[] columnNames);

	public String getSqlQuery(String selectQuery, HttpServletRequest request, String[] columnNames,
			String customCondition);
	
	public String getJsonChucDanh(String recordsTotal, String recordsFiltered, List<ChucDanh> list);
	
	public String getJsonPhongBan(String recordsTotal, String recordsFiltered, List<PhongBan> list);
	
	public String getJsonChucNang(String recordsTotal, String recordsFiltered, List<ChucNang> list);
}
