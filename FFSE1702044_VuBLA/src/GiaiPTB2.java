

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GiaiPTB2
 */
public class GiaiPTB2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiaiPTB2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String c = request.getParameter("c");
		float Soa = Integer.parseInt(a);
		float Sob = Integer.parseInt(b);
		float Soc = Integer.parseInt(c);
		String ketqua;
		float giatri;
		float delta = (Sob*Sob)- (4*Soa*Soc);
		if(delta <0) {
			request.setAttribute("delta", delta);
			ketqua = "Phương Trình Vô Nghiệm";
		}else if(delta == 0 ) {
			ketqua= "Phương trình có nghiệm kép";
			giatri = (-Sob/2*Soa);
		}else {
			ketqua="Phương trình có 2 nghiệm phân biệt";
			
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
