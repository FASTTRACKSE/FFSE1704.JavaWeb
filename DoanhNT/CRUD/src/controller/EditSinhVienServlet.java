package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

public class EditSinhVienServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private SinhVienDAO sinhVienDAO = new SinhVienDAO();

	public EditSinhVienServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maSinhVien = req.getParameter("maSinhVien");
		SinhVien sinhVien = sinhVienDAO.getSinhVienByMaSinhVien(maSinhVien);
		req.setAttribute("sinhVien", sinhVien);
		req.getRequestDispatcher("editSinhVien.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String maSinhVien = req.getParameter("maSinhVien");
		String tenSinhVien = req.getParameter("tenSinhVien");
		String pass = req.getParameter("pass");

		sinhVienDAO.updateSinhVien(maSinhVien, tenSinhVien, pass);

		resp.sendRedirect(req.getContextPath());

	}
}
