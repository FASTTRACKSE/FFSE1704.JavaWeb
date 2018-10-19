package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tinhtoanServlet
 */
public class tinhtoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tinhtoanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String soA = request.getParameter("numbera");
		String soB = request.getParameter("numberb");
		String phepcong = request.getParameter("pheptinh");

		int A = Integer.parseInt(soA);
		int B = Integer.parseInt(soB);
		int tongab = 0;
		int hieuab = 0;
		int nhanab = 0;
		int chiaab = 0;
		if (phepcong.equals("+")) {
			tongab = A + B;
			String cong = String.valueOf(tongab);

			request.setAttribute("pheptinh", cong);
			request.getRequestDispatcher("ketqua.jsp").forward(request, response);

		} else if (phepcong.equals("-")) {
			hieuab = A - B;
			String tru = String.valueOf(hieuab);

			request.setAttribute("pheptinh", tru);
			request.getRequestDispatcher("ketqua.jsp").forward(request, response);
		} else if (phepcong.equals("x")) {
			nhanab = A * B;
			String nhan = String.valueOf(nhanab);

			request.setAttribute("pheptinh", nhan);
			request.getRequestDispatcher("ketqua.jsp").forward(request, response);
		} else if (phepcong.equals("%")) {
			chiaab = B % A;
			String chia = String.valueOf(chiaab);

			request.setAttribute("pheptinh", chia);
			request.getRequestDispatcher("ketqua.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
