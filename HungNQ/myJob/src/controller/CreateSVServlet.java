package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;

/**
 * Servlet implementation class CreateSVServlet
 */
public class CreateSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SinhVienDAO sinhvienDao = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String lop = request.getParameter("lop");
		String masv = request.getParameter("masv");
		String ten = request.getParameter("ten");
		String tuoi = request.getParameter("tuoi");
		String gioitinh = request.getParameter("gioitinh");
		
		sinhvienDao.createSinhVien(lop,masv,ten,tuoi,gioitinh);
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
