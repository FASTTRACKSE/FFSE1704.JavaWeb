

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculate
 */
public class calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		float c;
		String calculate = request.getParameter("calculate");
		if (calculate.equals("cong")) {
			c = x + y;
		    request.setAttribute("ketqua", c);
			request.getRequestDispatcher("cong.jsp").forward(request, response);
		} else if (calculate.equals("tru")) {
			c = x - y;
			request.setAttribute("ketqua", c);
			request.getRequestDispatcher("tru.jsp").forward(request, response);
		} else if (calculate.equals("nhan")) {
			c = x * y;
			request.setAttribute("ketqua", c);
			request.getRequestDispatcher("nhan.jsp").forward(request, response);
		} else if (calculate.equals("chia")) {
			c= x / y;
			request.setAttribute("ketqua", c);
			request.getRequestDispatcher("chia.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
