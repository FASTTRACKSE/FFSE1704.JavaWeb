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
 * Servlet implementation class Withdraw
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtmModel model = new AtmModel();
	private Account account = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WithdrawServlet() {
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
		account = model.checkId(maAC);
		request.setAttribute("ac", account);
		request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String maAC = request.getParameter("maAC");
			String a = request.getParameter("sotien");
			double sotien = Double.parseDouble(a);

			double checkamount = account.getAmount();
			
			if (sotien < checkamount) {
				double sotienrut = account.withdraw(sotien);

				model.withdraw(maAC, sotienrut);
				response.sendRedirect(request.getContextPath() + "/controller");
			} else {
				response.sendRedirect(request.getContextPath() + "/WithdrawServlet");
				throw new Exception();
			}

		} catch (Exception e) {
			Log4jFile.writeError(e.getMessage(), e);
			System.out.println(e);
		}

	}

}
