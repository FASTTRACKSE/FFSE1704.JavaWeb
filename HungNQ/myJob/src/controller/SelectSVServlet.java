package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.SinhVienBO;
import model.dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class SelectSVServlet
 */
public class SelectSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SinhVienBO sinhvienBO = new SinhVienBO();
	SinhVienDAO sinhvienDao = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectSVServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<SinhVien> listSinhVien = sinhvienDao.getAllUser();
		request.setAttribute("listSinhVien", listSinhVien);
		request.getRequestDispatcher("getall.jsp").forward(request, response);
		/*
		 * String page = "1"; if (request.getParameter("page") != null) { page =
		 * request.getParameter("page"); }
		 * 
		 * int a = Integer.parseInt(page); request.setAttribute("page", a);
		 * 
		 * // tổng record từng dòng trong db int totalRecords = listSinhVien.size();
		 * 
		 * // số records muốn hiển thị trên 1 trang int recordsOfPage = 1; String t =
		 * String.valueOf(recordsOfPage);
		 * 
		 * // tổng số trang có được
		 * 
		 * double totalPage = totalRecords / recordsOfPage + ((totalRecords %
		 * recordsOfPage) == 0 ? 0 : 1); int total = (int) totalPage;
		 * request.setAttribute("toatalPage", total);
		 * 
		 * int start = (a - 1) * recordsOfPage; List<SinhVien> pageList =
		 * sinhvienDao.searchReCords(start, recordsOfPage);
		 * request.setAttribute("listSinhVien", pageList);
		 * request.getRequestDispatcher("getall.jsp").forward(request, response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
