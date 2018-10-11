package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.entity.User;

public class DeleteUserServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();

	public DeleteUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		boolean user = userDao.deleteUser(id);
		req.setAttribute("user", user);
	}
}
