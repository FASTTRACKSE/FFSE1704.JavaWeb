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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		String loginUrI = req.getContextPath()+"/";
		
		boolean loginSesion = session !=null && session.getAttribute("list") !=null;
		boolean loginRequest = req.getRequestURI().equals(loginUrI);
		boolean loadstyle = req.getRequestURI().matches(".*(js|css|jpg|png|jepg)");
		
		if(loginSesion) {
			if(!loginRequest) {
				
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath() + "/Hello?page=1");
			}
		}
		else {
		
			if(loadstyle) {
				chain.doFilter(request, response);
			}
			else {
				req.getRequestDispatcher("/login").forward(req, res);
			}
			
		}
		
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
