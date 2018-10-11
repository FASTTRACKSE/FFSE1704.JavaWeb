package controller;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.SinhVienDAO;
import model.entity.SinhVien;


/**
 * Servlet implementation class SinhVienServlet
 */
public class SinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SinhVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.getAttribute("admin");
		if( session.getAttribute("admin") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}else {
			
			
			String page = request.getParameter("page");
			int i = Integer.parseInt(page);
			request.setAttribute("page", i);

			List<SinhVien> listSinhVien = sinhVienDAO.getAllSinhVien();
			int allItem = listSinhVien.size();

			int reCordInPage = 1;
			String t = String.valueOf(reCordInPage);

			double totalPage = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
			int total = (int) totalPage;
			request.setAttribute("toatalPage", total);

			double indexStart = (i - 1) * reCordInPage;
			int s = (int) indexStart;

			sinhVienDAO.pageSinhVien(s, t);
			List<SinhVien> pageSinhVien = sinhVienDAO.pageSinhVien(s, t);
			request.setAttribute("listSinhVien", pageSinhVien);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		
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
