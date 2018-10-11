package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;

/**
 * Servlet implementation class DeleteSVServlet
 */
public class DeleteSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SinhVienDAO sinhvienDao = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		boolean sinhvien = sinhvienDao.deleteSinhVien(id);
		request.setAttribute("sinhvien", sinhvien);
		response.sendRedirect(request.getContextPath()+"/getAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
