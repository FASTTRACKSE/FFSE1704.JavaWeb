package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.SinhVienDAO;
import model.entity.Admin;
import model.bo.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
	SinhVienBo sinhVienBo = new SinhVienBo();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		if (session.getAttribute("admin") != null) {
			response.sendRedirect(request.getContextPath() + "/SinhVienServlet?page=1");
		} else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mess = "";

		if (sinhVienBo.checkExistAdmin(username, password)) {
			Admin admin = sinhVienDAO.loginAdmin(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin.getUsername());
			// session.setMaxInactiveInterval(1*60);
			response.sendRedirect(request.getContextPath() + "/SinhVienServlet?page=1");

		} else {
			mess = "tai khoan mat khau khong chinh xac";
			request.setAttribute("mess", mess);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

}
