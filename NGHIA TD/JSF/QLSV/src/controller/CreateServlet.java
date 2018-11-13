package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.entity.SinhVien;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String diaChi = request.getParameter("address");
		String sdt = request.getParameter("phone");
		SinhVien sinhvien =new SinhVien(name,age,diaChi,sdt);
		userDao.insert(sinhvien);
		response.sendRedirect(request.getContextPath()+"/Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
