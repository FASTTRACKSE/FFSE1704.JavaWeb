package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.*;
import model.bo.*;
import model.dao.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDAO = new UserDao();
	UserBO userBo = new UserBO();

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
		// TODO Auto-generated method stub
		String langue = request.getParameter("lang");
		request.setAttribute("abc", langue);
		String page = request.getParameter("page");
		int i = Integer.parseInt(page);
		request.setAttribute("page", i);
		List<User> arrList = userDAO.getAllUser();
		int allItem = arrList.size();
		int reCordInPage = 3;
		String t = String.valueOf(reCordInPage);

		double totalPage = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) totalPage;
		request.setAttribute("toatalPage", total);

		double indexStart = (i - 1) * reCordInPage;
		int s = (int) indexStart;
		userDAO.pageSinhVien(s, t);
		List<User> pageSinhVien = userDAO.pageSinhVien(s, t);
		request.setAttribute("listSinhVien", pageSinhVien);
		request.getRequestDispatcher("cong.jsp").forward(request, response);
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
