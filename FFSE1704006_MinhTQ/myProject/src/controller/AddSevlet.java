package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class AddUser
 */
public class AddSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinhVienDAO svDAO = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maSinhVien = request.getParameter("maSV");
		String tenSinhVien = request.getParameter("tenSV");
		String tuoiSinhVien = request.getParameter("tuoiSV");
		String LopHoc = request.getParameter("lophoc");
		String diaChi = request.getParameter("diachi");
		svDAO.add(new SinhVien(maSinhVien, tenSinhVien, tuoiSinhVien, LopHoc, diaChi));
		response.sendRedirect(request.getContextPath() + "/SinhVienSevlet?page=1");
	}

}
