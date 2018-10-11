package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class EditSinhVienServlet
 */
public class EditSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSinhVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		SinhVien sinhVien = sinhVienDAO.searchSinhVien(id);
		request.setAttribute("SinhVien", sinhVien);
		request.getRequestDispatcher("EditSinhVien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String masv = request.getParameter("masv");
		String ho = request.getParameter("ho");
		String ten = request.getParameter("ten");
		String gioitinh = request.getParameter("gioitinh");
		String namsinh = request.getParameter("namsinh");
		String lop = request.getParameter("lop");
		
		SinhVien sv = new SinhVien(id, masv, ho, ten, gioitinh, namsinh, lop);
		sinhVienDAO.editSinhVien(sv);
		
		response.sendRedirect(request.getContextPath()+"/sinhvien?page=1");
	}

}
