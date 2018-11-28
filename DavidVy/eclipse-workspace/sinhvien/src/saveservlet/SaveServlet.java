package saveservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.java.SinhVien;
import sinhvienDAO.SinhVienDAO;
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException{
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        
        String ten=request.getParameter("ten");
        String tuoi=request.getParameter("tuoi");
        String ngaysinh=request.getParameter("ngaysinh");
        String diachi=request.getParameter("diachi");
        
        SinhVien e = new SinhVien();
        e.setten(ten);
        e.settuoi(tuoi);
        e.setngaysinh(ngaysinh);
        e.setdiachi(diachi);
        
        int status=SinhVienDAO.save(e);
        if(status>0) {
        	out.print("<p>hello bạn</p>");
        	request.getRequestDispatcher("index.jsp").include(request, response);
        }else {
        	out.println("sorry bạn");
        }
        
        out.close();
	} 
}
