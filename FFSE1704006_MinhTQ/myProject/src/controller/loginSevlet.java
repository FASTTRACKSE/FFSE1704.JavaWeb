package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao.UserDAO;
import model.bo.UserBo;
import model.entity.User;

/**
 * Servlet implementation class loginSevlet
 */
public class loginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBo Bo = new UserBo();
	private UserDAO usDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");

		HttpSession session = request.getSession();

		User Admin = usDAO.getUser(username, password);
		session.setAttribute("user", Admin.getTenAdmin());
		
		List<User> listAdmin = usDAO.getAllUser();
		request.setAttribute("listAdmin", listAdmin);
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
		return;

	}

}
