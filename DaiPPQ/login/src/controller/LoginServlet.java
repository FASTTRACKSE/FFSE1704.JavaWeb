package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.UserBO;
import model.dao.UserDAO;
import model.entity.User;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserBO userBO = new UserBO();
	UserDAO userDao = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		if (userBO.checkExisUser(username, password)) {
			User us = userDao.getUser(username, password);
			request.setAttribute("user", us);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
