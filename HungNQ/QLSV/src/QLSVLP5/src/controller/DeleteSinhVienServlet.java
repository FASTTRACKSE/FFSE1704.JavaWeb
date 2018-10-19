package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class DeleteSinhVienServlet
 */
public class DeleteSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSinhVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSinhVien = request.getParameter("id");
		SinhVien sinhVien = sinhVienDAO.searchSinhVien(maSinhVien);
		request.setAttribute("SinhVien", sinhVien);
		request.getRequestDispatcher("DeleteSinhVien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masinhvien = request.getParameter("masinhvien");
		sinhVienDAO.deleteSinhVien(masinhvien);
		response.sendRedirect(request.getContextPath()+"?page=1");
	}

}
