package codemaster.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codemaster.servlet.entity.SavingAccount;
import codemaster.servlet.model.AtmModel;

/**
 * Servlet implementation class ReadOneAccount
 */
@WebServlet("/ReadTypeAccount")
public class ReadTypeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtmModel model = new AtmModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadTypeAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @param id
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maAc = request.getParameter("id");
		SavingAccount listone = new SavingAccount();
		listone = model.checkId(maAc);
		request.setAttribute("listone", listone);
		RequestDispatcher rd = request.getRequestDispatcher("ViewTypeAccount.jsp");
		rd.forward(request, response);

	}

}
