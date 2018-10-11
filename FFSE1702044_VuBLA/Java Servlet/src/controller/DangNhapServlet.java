package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.UserBo;
import model.dao.UserDao;
import model.entity.User;

/**
 * Servlet implementation class DangNhapServlet
 */
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBo userBO = new UserBo();
	UserDao userDAO = new UserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String langue = request.getParameter("lang");
		HttpSession session=request.getSession();
		session.setAttribute("lang", langue);
		String page = request.getParameter("page");
		int i = Integer.parseInt(page);
		request.setAttribute("page", i);
		
		List<User> arrList = userDAO.getAllUser();
		int allItem = arrList.size();
		
		int reCordInPage = 2;
		String t = String.valueOf(reCordInPage);

		double totalPage = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) totalPage;
		request.setAttribute("toatalPage", total);

		double indexStart = (i - 1) * reCordInPage;
		int s = (int) indexStart;
		
		userDAO.pageSinhVien(s, t);
		List<User> pageSinhVien = userDAO.pageSinhVien(s, t);
		request.setAttribute("listSinhVien", pageSinhVien);
		request.getRequestDispatcher("thanhcong.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if (userBO.checkExitUser(user, pass)) {
			session.setAttribute("user", user);
			String langue = request.getParameter("lang");
			session.setAttribute("lang", langue);
			String page = request.getParameter("page");
			int i = Integer.parseInt(page);
			request.setAttribute("page", i);
			
			List<User> arrList = userDAO.getAllUser();
			int allItem = arrList.size();
			
			int reCordInPage = 2;
			String t = String.valueOf(reCordInPage);

			double totalPage = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
			int total = (int) totalPage;
			request.setAttribute("toatalPage", total);

			double indexStart = (i - 1) * reCordInPage;
			int s = (int) indexStart;
			
			userDAO.pageSinhVien(s, t);
			List<User> pageSinhVien = userDAO.pageSinhVien(s, t);
			request.setAttribute("listSinhVien", pageSinhVien);
			request.getRequestDispatcher("thanhcong.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/index.jsp?error=0");
		}

	}

}
