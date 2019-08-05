package codemaster.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codemaster.servlet.entity.TransactionAccount;
import codemaster.servlet.model.AtmModel;

/**
 * Servlet implementation class AddTransactionServlet
 */
@WebServlet("/AddTransactionServlet")
public class AddTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtmModel model = new AtmModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTransactionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maAC = request.getParameter("maAC");
		String tenAC = request.getParameter("tenAC");

		String a = request.getParameter("sodu");
		double sodu = Double.parseDouble(a);

		String b = request.getParameter("loaiTK");
		int loaiTK = Integer.parseInt(b);

		model.addTransaction(new TransactionAccount(maAC, tenAC, sodu, loaiTK));
		response.sendRedirect(request.getContextPath() + "/controller");
	}

}
