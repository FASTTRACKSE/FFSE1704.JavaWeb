package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.entity.User;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDAO = new UserDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		User arrList = userDAO.editUser(id);
		request.setAttribute("arrList", arrList);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String id_user = request.getParameter("id");
		userDAO.updateUser(new User(id_user,userName,passWord));
		response.sendRedirect(request.getContextPath()+"/DangNhapServlet?page=1");
	}
}
