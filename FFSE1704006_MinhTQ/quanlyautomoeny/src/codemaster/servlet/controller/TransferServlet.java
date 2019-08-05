package codemaster.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codemaster.servlet.entity.Account;
import codemaster.servlet.log4jFile.Log4jFile;
import codemaster.servlet.model.AtmModel;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtmModel model = new AtmModel();
	private Account account1 = null;
	private Account account2 = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maAC = request.getParameter("id");
		account1 = model.checkId(maAC);
		request.setAttribute("ac", account1);
		request.getRequestDispatcher("Transfer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String maAC1 = request.getParameter("maAC1");
			String maAC2 = request.getParameter("maAC2");
			account2 = model.checkId(maAC2);

			String a = request.getParameter("sotien");
			double sotien = Double.parseDouble(a);

			double checkAmount = account1.getAmount();
			if (checkAmount > 0 && sotien < checkAmount) {
				double sotientru = account1.withdraw(sotien);
				double sotiencong = account2.deposit(sotien);

				model.withdraw(maAC1, sotientru);
				model.deposit(maAC2, sotiencong);

				response.sendRedirect(request.getContextPath() + "/controller");
			} else {
				response.sendRedirect(request.getContextPath() + "/TransferServlet");
				throw new Exception();
			}

		} catch (Exception e) {
			Log4jFile.writeError(e.getMessage(), e);
		}

	}

}
