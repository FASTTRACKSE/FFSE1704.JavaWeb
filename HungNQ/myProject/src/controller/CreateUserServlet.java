package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.UserBO;
import model.dao.UserDao;
import model.entity.User;

public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();
	UserBO userBO = new UserBO();

	public CreateUserServlet() {
		super();
	}
	/*AddUSER*/
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		String fullName = req.getParameter("fullname");
		String Age = req.getParameter("age");
		
		boolean insert = userDao.createUser(userName, passWord, fullName, Age);
		req.setAttribute("insert", insert);
		req.getRequestDispatcher("thanhcong.jsp").forward(req, resp);
	}
}
