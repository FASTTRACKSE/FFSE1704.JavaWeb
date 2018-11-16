package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinhVienDAO sinhVienDao = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt((String) request.getParameter("page"));
		}

		int totalRecord = sinhVienDao.getAllSinhVien().size();

		int totalPage = (totalRecord / SinhVienDAO.RECORD_IN_PAGE)
				+ ((double) totalRecord % (double) SinhVienDAO.RECORD_IN_PAGE == 0 ? 0 : 1);

		List<SinhVien> listSinhVien = sinhVienDao.getSinhVienInPage(currentPage);

		request.setAttribute("listSinhVien", listSinhVien);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("listUser.jsp").forward(request, response);
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
