package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bo.UserBO;
import model.dao.UserDao;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
UserDao userDAO = new UserDao();
UserBO userBo = new UserBO();
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//response.getWriter().append("Served at: ").append(request.getContextPath());
String user = request.getParameter("user");
User arr = userDAO.showtt(user);
request.setAttribute("stt", arr);
request.getRequestDispatcher("edit.jsp").forward(request, response);

}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//doGet(request, response);
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String user = request.getParameter("user");
String password = request.getParameter("password");
String fullname = request.getParameter("fullname");
userDAO.getupdateUser(new User(id,user,password,fullname));
response.sendRedirect(request.getContextPath()+ "/LoginServlet?page=1");
}

}
