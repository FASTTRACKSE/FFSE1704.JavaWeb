package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.UserBO;
import model.dao.UserDao;
import model.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao userdao = new UserDao();
       UserBO userBo = new UserBO();
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
		HttpSession session = request.getSession();
		if(session.getAttribute("list") != null) {
			response.sendRedirect(request.getContextPath()+"/Hello?page=1");
		
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		User list = userdao.getUser(username, password);
		session.setAttribute("list", list.getUser());
		System.out.println(list.getUser());
		if(request.getParameter("deleteSession") != null) {
			session.invalidate();
		}
		if(userBo.checkloGin(username, password)) {
			response.sendRedirect(request.getContextPath()+"/Hello?page=1");
		}
		
		
	}

}
