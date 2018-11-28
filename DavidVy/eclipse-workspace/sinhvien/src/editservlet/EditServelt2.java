package editservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.java.SinhVien;
import sinhvienDAO.SinhVienDAO;

public class EditServelt2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String ten=request.getParameter("ten");
        String tuoi=request.getParameter("tuoi");
        String ngaysinh=request.getParameter("ngaysinh");
        String diachi=request.getParameter("diachi");
        
        SinhVien e= new SinhVien();
        e.setid(id);
        e.setten(ten);
        e.settuoi(tuoi);
        e.setngaysinh(ngaysinh);
        e.setdiachi(diachi);
        
        int status=SinhVienDAO.update(e);
        if(status>0) {
        	response.sendRedirect("ViewServlet");
        }else {
        	out.print("Sorry! unable to update record");
        }
        
        out.close();
	}

}
