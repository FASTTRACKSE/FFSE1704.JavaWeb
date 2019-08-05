package codemaster.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codemaster.servlet.entity.Account;
import codemaster.servlet.entity.SavingAccount;
import codemaster.servlet.log4jFile.Log4jFile;
import codemaster.servlet.model.AtmModel;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddSavingAcountServlet")
public class AddSavingAcountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtmModel model = new AtmModel();
	private Account ac = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSavingAcountServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			String maAC = request.getParameter("maAC");
			ac = model.checkId(maAC);
			String q = ac.getAccountNo();
			String q1 = q.replaceAll("\\s+","");
			if (!q1.equalsIgnoreCase(maAC)) {
				String tenAC = request.getParameter("tenAC");

				String a = request.getParameter("sodu");
				double sodu = Double.parseDouble(a);

				String b = request.getParameter("loaiTK");
				int loaiTK = Integer.parseInt(b);

				String c = request.getParameter("laisuat");
				double laisuat = Double.parseDouble(c);

				String d = request.getParameter("thoihan");
				int thoihan = Integer.parseInt(d);

				model.addSaving(new SavingAccount(maAC, tenAC, sodu, loaiTK, laisuat, thoihan));
				response.sendRedirect(request.getContextPath() + "/controller");

			} else {
				throw new Exception();
			}
			Log4jFile.writeInfor3(model);
		} catch (Exception e) {
			Log4jFile.writeError(e.getMessage(), e);
			e.printStackTrace();
		}

	}

}
