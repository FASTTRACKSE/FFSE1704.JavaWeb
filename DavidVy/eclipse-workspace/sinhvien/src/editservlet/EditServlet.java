package editservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.java.SinhVien;
import sinhvienDAO.SinhVienDAO;

public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse reponse) 
		throws ServletException, IOException {
		reponse.setContentType("text/html");
		PrintWriter out=reponse.getWriter(); 
		out.println("<h1>Update Employee</h1>");
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        SinhVien e= SinhVienDAO.getEmployeeByid(id);
        
        out.print("<from action='EditServelt2'method='post'>");
        out.print("<table>");
        out.print("<tr><td><input type='text'name='id'value="+e.getid()+"</td></tr>");
        out.print("<tr><td><input type='text'name='ten'value="+e.getten()+"</td></tr>");
        out.print("<tr><td><input type='text'name='tuoi'value="+e.gettuoi()+"</td></tr>");
        out.print("<tr><td><input type='text'name='ngaysinh'value="+e.getngaysinh()+"</td></tr>");
        out.print("<tr><td><input type='text'name='diachi'value="+e.getdiachi()+"</td></tr>");
        
        out.print("<input type='sumit'value='Edit&Save'>");
        
        out.print("</table>");  
        out.print("</form>"); 
        
        out.close();
	}
}
