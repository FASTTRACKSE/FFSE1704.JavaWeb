package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SinhVien;
import model.SinhVienDAO;

public class AddSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public AddSinhVienServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("addsinhvien.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String masinhvien = request.getParameter("masinhvien");
		String tensinhvien = request.getParameter("tensinhvien");
		String lop = request.getParameter("lophoc");
		String tuoi = request.getParameter("tuoi");
		String gioitinh = request.getParameter("gioitinh");
		String diachi = request.getParameter("diachi");
		String sodt = request.getParameter("sdt");
		String email = request.getParameter("email");
		
		SinhVien sv = new SinhVien(masinhvien, tensinhvien, lop, tuoi, gioitinh, diachi, sodt,email);
		sinhVienDAO.addSinhVien(sv);
		response.sendRedirect(request.getContextPath()+"/SinhVienServlet?page=1");
	}

}
