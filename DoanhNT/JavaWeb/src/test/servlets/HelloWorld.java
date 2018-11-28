package test.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadParameter(request, response, "by Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadParameter(request, response, "by Post");
	}
	private void loadParameter(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		ServletContext context = this.getServletContext();
		String account = context.getInitParameter("account");
		String password = context.getInitParameter("song");
		
		ServletConfig config = this.getServletConfig();
		String song = config.getInitParameter("song");
	
		PrintWriter out = response.getWriter();
		out.println("Hello World " + method + "</br>");
		out.println("This is a song: " + song + "</br>");
		out.println("account: " + account + " and password: " + password + "</br>"); 
	}
}
