

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class suly
 */
public class suly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		double a = 0;
		double b = 0;
		double c = 0;
		double delta = 0;
		double x = 0;
		double x1 = 0;
		double x2 = 0;
		
		a = Double.parseDouble(request.getParameter("numbera"));
		b = Double.parseDouble(request.getParameter("numberb"));
		c = Double.parseDouble(request.getParameter("numberc"));
		
		String kq = "";
		
		if (a == 0 ) {
			if (b == 0) {
				if (c == 0) {
					kq = "Phương trình có vô số nghiệm";
				} else {
					kq = "Phương trình vô nghiệm";
				}
			} else {
				x = -c / b;
				kq = "Phương trình có nghiệm x = " + x;
			}		
		} else {
			delta = b*b - 4*a*c;
			if (delta < 0) {
				kq = "Phương trình vô nghiệm";
			} else if (delta == 0) {
				x = -b/(2*a);
				kq = "Phương trình có nghiệm kép x1 = x2 = " + x;
			} else {
				x1 = ((-b+Math.sqrt(delta))/(2*a));
				x2 = ((-b-Math.sqrt(delta))/(2*a));
				kq = "Phương trình có 2 nghiệm <br> x1 = " + x1 + "<br> x2 = " + x2;
			}		
		}
		request.setAttribute("ketqua", kq);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
