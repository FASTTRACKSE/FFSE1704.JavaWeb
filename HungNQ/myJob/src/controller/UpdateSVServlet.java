package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class UpdateSVServlet
 */
public class UpdateSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhvienDao = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSVServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		SinhVien sinhvien = sinhvienDao.readSinhVien(id);
		request.setAttribute("sinhvien", sinhvien);
		request.getRequestDispatcher("CRUD-INF/update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String lop = request.getParameter("lop");
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String tuoi = request.getParameter("tuoi");
		String gioitinh = request.getParameter("gioitinh");
		
		sinhvienDao.updateSinhVien(lop, ma, ten, tuoi, gioitinh, id);
		
		response.sendRedirect(request.getContextPath()+"/getAll");
	}

}
