package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SinhVienDAO;

public class DeleteSinhVienServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private SinhVienDAO sinhVienDAO = new SinhVienDAO();

	public DeleteSinhVienServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maSinhVien = req.getParameter("maSinhVien");
		sinhVienDAO.deleteSinhVien(maSinhVien);

		resp.sendRedirect(req.getContextPath());
	}

}
