package controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		
		HttpSession session = req.getSession(false);
		String loginURI = req.getContextPath() + "/login";

		boolean loginSesion = session != null && session.getAttribute("admin") != null; 
		boolean loginRequest = req.getRequestURI().equals(loginURI); 
		boolean loadstyle = req.getRequestURI().matches(".*(js|css|jpg|png|jepg)");
	
		
		
		if (loginSesion) {//nếu mà session tồn tại
			if (!loginRequest) {// nếu mà link khác trang login
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath());
			}
		} else {//sesion k tồn tại
			if(loadstyle) {
				chain.doFilter(request, response);
			}else {
			req.getRequestDispatcher("/LoginServlet").forward(req, res);
			}
		}
		
		/*if (loginSesion == true || loginRequest == true || loadstyle ==true) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(loginURI);
		}*/
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
