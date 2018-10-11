package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class ReadSVServlet
 */
public class ReadSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhvienDao = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadSVServlet() {
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
		String id = request.getParameter("id");
		SinhVien sinhvien = sinhvienDao.readSinhVien(id);
		request.setAttribute("read", sinhvien);
		request.getRequestDispatcher("CRUD-INF/read.jsp").forward(request, response);
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
