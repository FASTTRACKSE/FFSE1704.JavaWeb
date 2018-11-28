
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TinhToan
 */
public class TinhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TinhToan() {
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
		String action = request.getParameter("tinhtoan");
		String soA = request.getParameter("so a");
		int a = Integer.parseInt(soA);
		String soB = request.getParameter("so b");
		int b = Integer.parseInt(soB);

		int tinhToan = 0;
		String ketQua = "";
		if ("tinhtong".equals(action)) {
			tinhToan = a + b;
			ketQua = String.valueOf(tinhToan);
			request.setAttribute("ketqua", ketQua);
			request.getRequestDispatcher("KetQua.jsp").forward(request, response);
		} else {
			if ("tinhhieu".equals(action)) {
				tinhToan = a - b;
				ketQua = String.valueOf(tinhToan);
				request.setAttribute("ketqua", ketQua);
				request.getRequestDispatcher("KetQua.jsp").forward(request, response);
			} else {
				if ("tinhtich".equals(action)) {
					tinhToan = a * b;
					ketQua = String.valueOf(tinhToan);
					request.setAttribute("ketqua", ketQua);
					request.getRequestDispatcher("KetQua.jsp").forward(request, response);
				} else {
					if ("tinhthuong".equals(action)) {
						tinhToan = a / b;
						ketQua = String.valueOf(tinhToan);
						request.setAttribute("ketqua", ketQua);
						request.getRequestDispatcher("KetQua.jsp").forward(request, response);
					}
				}
			}
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
