package viewservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.java.SinhVien;
import sinhvienDAO.SinhVienDAO;

public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a>Add new Employee</a>");
		out.print("<h1>Employee List</h1>");
		
		List<SinhVien> list=SinhVienDAO.getAllEmployees();
		
		out.println("<table border='1' width='100%'");
		out.println("<tr><th>id</th><th>ten</th><th>tuoi</th><th>ngaysinh</th><th>diachi</th><th>Edit</th><th>Delet</th></tr>");
		for(SinhVien e:list) {
			out.println("<tr><td>"+e.getid()+"</td><td>"+e.getten()+"</td><td>"+e.gettuoi()+"</td><td>"+e.getngaysinh()+"</td><td>"+e.getdiachi()+"</td><td><a href='EditSevrlet? id="+e.getid()+"'>edit</a></td>"
					+ "			<td><a href='DeleteServlet?id="+e.getid()+"'>delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.close();
	}

}
