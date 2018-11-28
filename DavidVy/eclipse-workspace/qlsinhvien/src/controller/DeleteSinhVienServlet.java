package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SinhVien;
import model.SinhVienDAO;

public class DeleteSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();

	public DeleteSinhVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSinhVien = request.getParameter("id");
		SinhVien sinhVien = sinhVienDAO.searchSinhVien(maSinhVien);
		request.setAttribute("SinhVien", sinhVien);
		request.getRequestDispatcher("deletesinhvien.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masinhvien = request.getParameter("masinhvien");
		sinhVienDAO.deleteSinhVien(masinhvien);
		response.sendRedirect(request.getContextPath()+"/SinhVienServlet?page=1");
	}

}
