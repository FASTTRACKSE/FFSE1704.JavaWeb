package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.entity.User;

public class EditUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();
	
	public EditUserServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = userDao.editUser(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("CRUD-INF/edit.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String old = req.getParameter("old");
		
		resp.sendRedirect(req.getContentType());
	}
	
}
