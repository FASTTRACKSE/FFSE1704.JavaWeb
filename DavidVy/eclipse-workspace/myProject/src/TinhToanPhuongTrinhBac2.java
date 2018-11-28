
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TinhToanPhuongTrinhBac2
 */
public class TinhToanPhuongTrinhBac2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TinhToanPhuongTrinhBac2() {
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
		String soA = request.getParameter("so a");
		int a = 0;

		String soB = request.getParameter("so b");
		int b = 0;
		
		String soC = request.getParameter("so c");
		int c = 0;


		if (soA.equals("")) {
			a = 0;
		} else {
			a =Integer.parseInt(soA);
			
		}

		if (soB.equals("")) {
			b = 0;
		} else {
			b = Integer.parseInt(soB);
		
		}
		
		if (soC.equals("")) {
			c = 0;
		} else {
			c = Integer.parseInt(soC);

		}
		double delta =  (b * b) - (4 * a * c);
		double x1 = 0;
		double x2 = 0;
		String kQ ="";
		
		if (a == 0 && b == 0 && c == 0) {
			kQ = "phuong trinh: " + a+"x^2" +"+"+ b+"x" +"+"+ c+"=0 vo so nghiem";
		} else {
			if (a == 0 && b != 0) {
				x1 = (-c) / b;
				kQ ="phuong trinh: " + a+"x^2" +"+"+ b+"x" +"+"+ c+"=0 co nghiem x= "+x1;
				
			} else {
				if (delta < 0) {
					kQ = "phuong trinh: " + a+"x^2" +"+"+ b+"x" +"+"+ c+"=0 vo nghiem";
					

				} else {
					if (delta == 0) {
						x2 = (-b) / (2 * a);
						
						kQ= "phuong trinh: " + a+"x^2" +"+"+ b+"x" +"+"+ c+"=0 co nghiem kep x1=x2= "+x1;
						
					} else {
						x1 = (-b + Math.sqrt(delta)) / (2 * a);
						
						x2 = (-b - Math.sqrt(delta)) / (2 * a);
						kQ= "phuong trinh: " + a+"x^2" +"+"+ b+"x" +"+"+ c+"=0 co 2 nghiem:  x1= "+x1 + " va x2= "+x2;

					}
				}

			}
		}
		request.setAttribute("ketqua", kQ);
		request.getRequestDispatcher("TinhPhuongTrinhBac2.jsp").forward(request, response);
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
