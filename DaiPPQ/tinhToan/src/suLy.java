

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class suLy
 */
@WebServlet("/suLy")
public class suLy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suLy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		int a = 0;
		int b = 0;
		int tinhtoan = 0;
		
		a = Integer.parseInt(request.getParameter("numbera"));
		b = Integer.parseInt(request.getParameter("numberb"));
		
		if (request.getParameter("tinhtoan").equals("+")) {
			tinhtoan = a + b;
			
		} else if (request.getParameter("tinhtoan").equals("-")) {
			tinhtoan = a - b;
			
		} else if (request.getParameter("tinhtoan").equals("*")) {
			tinhtoan = a * b;
			
		} else if (request.getParameter("tinhtoan").equals("/")) {
			tinhtoan = a / b;
			
		}
		request.setAttribute("ketqua", tinhtoan);
		request.getRequestDispatcher("ketqua.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
