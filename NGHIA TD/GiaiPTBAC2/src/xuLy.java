

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xuLy
 */
public class xuLy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xuLy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a1 = request.getParameter("soA");
		String b1 = request.getParameter("soB");
		String c1 = request.getParameter("soC");
		int a = Integer.parseInt(a1);
		int b = Integer.parseInt(b1);
		int c = Integer.parseInt(c1);
		int x1 = 0;
		int x2 = 0;
		int delta = b*b-4*a*c;
		System.out.println("delta = b*b-4*a*c"+ " = " +(b*b-4*a*c));
//		if(a==0) {
//			if(b==0) {
//				System.out.println("Phương trình vô nghiệm");
//			}else {
//				System.out.println("Phương trình có nghiệm kép");
//				x1 =x2 =-c/b;
//				System.out.println(x1);
//			}
//			//phương trinh có nghiệm duy nhất
//		}
		if(delta>0) {
			System.out.println("Phương trình có 2 nghiệm phân biệt");
			x1 = (int) (-b+Math.sqrt(delta)/(2*a));
			x2 = (int) (-b-Math.sqrt(delta)/(2*a));
			System.out.println(x1);
			System.out.println(x2);
		}
		if(delta==0) {
			System.out.println("Phương trình có nghiệm kép ");
			x1=x2 = -b/(2*a);
			System.out.println(x2);
		}
		if(delta<0) {
			System.out.println("Phương trình vô nghiệm ");
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
