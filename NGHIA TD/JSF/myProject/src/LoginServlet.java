
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String a1 = request.getParameter("soA");
		String b1 = request.getParameter("soB");
		int a = Integer.parseInt(a1);
		int b = Integer.parseInt(b1);
		int tinhToan = 0;
		String kq = "";
		
		
		if (request.getParameter("tinhToan").equals("cong")) {
			tinhToan = a+b;		
		}

		else if (request.getParameter("tinhToan").equals("tru")){
			tinhToan = a-b;
		}
		else if (request.getParameter("tinhToan").equals("nhan")){
			tinhToan = a*b;
		}
		else if (request.getParameter("tinhToan").equals("chia")){
			tinhToan = a/b;
//			 kq = String.valueOf(tinhToan);
		}
		request.setAttribute("KetQua",tinhToan);
		
		request.getRequestDispatcher("KetQua.jsp").forward(request, response);
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
