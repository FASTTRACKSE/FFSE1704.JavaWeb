package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import model.Dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	 SinhVienDAO svDAO = new SinhVienDAO();

	public void stopConnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maSinhVien = request.getParameter("id");
		SinhVien sinhVien = svDAO.seach(maSinhVien);
		request.setAttribute("SinhVien", sinhVien);
		request.getRequestDispatcher("DeleteView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maSinhVien = request.getParameter("maSV");
		svDAO.delete(maSinhVien);
		response.sendRedirect(request.getContextPath()+"/SinhVienSevlet?page=1");
	}

}
