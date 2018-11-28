package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.entity.User;

public class EditUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserDAO userDao = new UserDAO();

	public EditUserServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = userDao.searchUser(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("insert.jsp").forward(req, resp);
	}
}
