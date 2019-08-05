package codemaster.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codemaster.servlet.entity.SavingAccount;
import codemaster.servlet.model.AtmModel;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class AtmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtmModel model = new AtmModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SavingAccount> list = new ArrayList<>();
		list = model.getAllAccount();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("ViewAccount.jsp");
		rd.forward(request, response);

	}

}
