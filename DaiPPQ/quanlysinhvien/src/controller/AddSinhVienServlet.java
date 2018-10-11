package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class AddSinhVienServlet
 */
public class AddSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSinhVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("Add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String masv = request.getParameter("masv");
		String ho = request.getParameter("ho");
		String ten = request.getParameter("ten");
		String gioitinh = request.getParameter("gioitinh");
		String namsinh = request.getParameter("namsinh");
		String lop = request.getParameter("lop");
		
		SinhVien sv = new SinhVien(masv, ho, ten, gioitinh, namsinh, lop);
		sinhVienDAO.addSinhVien(sv);
		
		response.sendRedirect(request.getContextPath()+"/sinhvien?page=1");
	}

}
