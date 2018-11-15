package ffse1704.JSFStaff.Filter;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,  
		     FilterChain chain) throws IOException, ServletException {  
		           
		 HttpServletRequest request = (HttpServletRequest) req;
		     HttpServletResponse response = (HttpServletResponse) resp;
		     HttpSession session = request.getSession(false);
		     
		     String loginURI = request.getContextPath() + "/login.xhtml";
		 
		     boolean loggedIn = session != null && session.getAttribute("admin") != null;
		     boolean loginRequest = request.getRequestURI().equals(loginURI);
		     boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);
		 
		     if (loggedIn || loginRequest || resourceRequest) {
		         chain.doFilter(request, response);
		     } else {
		         response.sendRedirect(loginURI);
		     }
		     
		     }  

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}