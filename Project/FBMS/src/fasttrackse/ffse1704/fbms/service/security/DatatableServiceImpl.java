package fasttrackse.ffse1704.fbms.service.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.ChucNang;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

@Service
public class DatatableServiceImpl implements DatatableService {

	@Autowired
	private ChucDanhService chucDanhService;
	
	@Autowired
	private PhongBanService phongBanService;
	
	@Autowired
	private ChucNangService chucNangService;

	@Override
	public String getSearchQuery(HttpServletRequest request, String[] columnNames, String customCondition) {

		int colLength = columnNames.length;
		String sSearch = (request.getParameter("sSearch") != null ? request.getParameter("sSearch") : "");
		String globeSearch = "where " + customCondition;
		boolean existCustom = !customCondition.isEmpty();

		if (!sSearch.isEmpty()) {
			for (int i = 0; i < colLength; i++) {
				if (i == 0) {
					if (existCustom) {
						globeSearch += " and ";
					}
					globeSearch += "(" + columnNames[i] + " like '%" + sSearch + "%' ";
				} else {
					globeSearch += "or " + columnNames[i] + " like '%" + sSearch + "%' ";
				}
			}
			globeSearch += ")";
			sSearch = globeSearch;
		}

		return !existCustom ? sSearch : globeSearch;
	}

	@Override
	public String getSortQuery(HttpServletRequest request, String[] columnNames) {

		int colLength = columnNames.length;
		List<String> sortNames = new ArrayList<String>();
		List<String> sortDirections = new ArrayList<String>();

		for (int i = 0; i < colLength; i++) {
			String colIndex = (request.getParameter("iSortCol_" + i) != null ? request.getParameter("iSortCol_" + i) : "");
			if (colIndex != "") {
				String sortName = columnNames[Integer.parseInt(colIndex)];
				String sortDirection = request.getParameter("sSortDir_" + i);

				sortNames.add(sortName);
				sortDirections.add(sortDirection);
			} else {
				break;
			}
		}

		int sortLength = sortNames.size();
		String sort = " order by ";
		for (int i = 0; i < sortLength; i++) {
			sort += sortNames.get(i) + " " + sortDirections.get(i);
			if (i != sortLength - 1) {
				sort += ", ";
			}
		}

		if (sortLength != 0) {
			return sort;
		}

		return "";
	}

	@Override
	@Transactional
	public String getSqlQuery(String selectQuery, HttpServletRequest request, String[] columnNames,
			String customCondition) {

		return selectQuery + getSearchQuery(request, columnNames, customCondition) + getSortQuery(request, columnNames);
	}

	@Override
	public String getJsonChucDanh(String recordsTotal, String recordsFiltered, List<ChucDanh> list) {
		String json = "{\"recordsTotal\":" + recordsTotal + ",\"recordsFiltered\":" + recordsFiltered + ",\"aaData\":[";
		int j = list.size();
		int i = 0;
		for (ChucDanh cd : list) {
			i++;
			if (i == j) {
				json += chucDanhService.toJson(cd);
			} else {
				json += chucDanhService.toJson(cd) + ",";
			}
		}
		json += "]}";

		return json;
	}

	@Override
	public String getJsonPhongBan(String recordsTotal, String recordsFiltered, List<PhongBan> list) {
		String json = "{\"recordsTotal\":" + recordsTotal + ",\"recordsFiltered\":" + recordsFiltered + ",\"aaData\":[";
		int j = list.size();
		int i = 0;
		for (PhongBan pb : list) {
			i++;
			if (i == j) {
				json += phongBanService.toJson(pb);
			} else {
				json += phongBanService.toJson(pb) + ",";
			}
		}
		json += "]}";

		return json;
	}
	
	@Override
	public String getJsonChucNang(String recordsTotal, String recordsFiltered, List<ChucNang> list) {
		String json = "{\"recordsTotal\":" + recordsTotal + ",\"recordsFiltered\":" + recordsFiltered + ",\"aaData\":[";
		int j = list.size();
		int i = 0;
		for (ChucNang cn : list) {
			i++;
			if (i == j) {
				json += chucNangService.toJson(cn);
			} else {
				json += chucNangService.toJson(cn) + ",";
			}
		}
		json += "]}";

		return json;
	}
}
