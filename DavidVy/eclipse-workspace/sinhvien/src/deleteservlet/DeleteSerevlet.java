package deleteservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import sinhvienDAO.SinhVienDAO;

public class DeleteSerevlet extends HttpServlet {
	protected void doGet(HttpServlet request, HttpServletResponse response) 
		throws ServletException, IOException{
		String sid=request.getInitParameter("id");
		int id=Integer.parseInt(sid);
		
		SinhVienDAO.delete(id);
		response.sendRedirect("ViewServlet");
	}

}
