package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ptbachaiServlet
 */
public class ptbachaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ptbachaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String a = request.getParameter("soA");
		String b = request.getParameter("soB");
		String c = request.getParameter("soC");
		String tinh = request.getParameter("submit");
		
		int soA = Integer.parseInt(a);
		int soB = Integer.parseInt(b);
		int soC = Integer.parseInt(c);
		double tinhne,x1,x2;
		String ketqua = request.getParameter("tinhne");
		
		request.setAttribute("submit", ketqua);
		if(soA==0) {
			System.out.println("Không phải phương trình bậc 2");
		} else {
			tinhne = Math.pow(soB, 2)-4*soA*soC;
			if(tinhne<0) {
				System.out.println("Phương trình vô nghiệm");
			} else if(tinhne==0) {
				x1=x2=-soB/(2*soA);
				System.out.println("Nghiệm của phương trình là:"+x1);
			} else{
				x1=(-soB+Math.sqrt(tinhne))/(2*soA);
				x2=(-soB-Math.sqrt(tinhne))/(2*soA);
				System.out.println("Nghiệm của phương trình là x1=" +x1);
				System.out.println("Nghiệm của phương trình là x2=" +x2);
			}
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
