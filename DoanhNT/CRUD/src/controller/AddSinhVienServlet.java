package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;

public class AddSinhVienServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private SinhVienDAO sinhVienDao = new SinhVienDAO();
	
	public AddSinhVienServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("addSinhVien.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codeSv = req.getParameter("codeSv");
		String nameSv = req.getParameter("nameSv");
		String passSv = req.getParameter("passSv");
		sinhVienDao.addSinhVien(codeSv, nameSv, passSv);
		
		resp.sendRedirect(req.getContextPath());
	}
}
