

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MayTinhServlet
 */
public class MayTinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MayTinhServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		int i = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		float c=0;
		String pheptinh = request.getParameter("pheptinh");
		if(pheptinh.equals("cong")) {
			c= i+y;
			
			request.setAttribute("ketQua", c);
			request.getRequestDispatcher("thanhcong.jsp").forward(request, response);
		}else if(pheptinh.equals("tru")) {
			c= i-y;
			
			request.setAttribute("ketQua", c);
			request.getRequestDispatcher("thatbai.jsp").forward(request, response);
		}else if(pheptinh.equals("nhan")) {
			c= i*y;
			
			request.setAttribute("ketQua", c);
			request.getRequestDispatcher("nhan.jsp").forward(request, response);
		}else if(pheptinh.equals("chia")) {
			c= i/y;
			
			request.setAttribute("ketQua", c);
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
