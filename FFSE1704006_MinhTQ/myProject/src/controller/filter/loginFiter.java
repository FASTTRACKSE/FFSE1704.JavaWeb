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
 * Servlet Filter implementation class loginFiter
 */
public class loginFiter implements Filter {

	/**
	 * Default constructor.
	 */
	public loginFiter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, Servlet Response, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		String loginURI = req.getContextPath() + "/login";

	boolean loggedIn = session != null && session.getAttribute("user") != null;
	boolean loginRequest = req.getRequestURI().equals(loginURI);

		if (loggedIn) {
			if (!loginRequest) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath());
			}
		} else {
			if (req.getRequestURI().matches(".*(js|css|jpg|png|jepg)")) {
				chain.doFilter(request, response);
			} else {
				req.getRequestDispatcher("/login").forward(req, res);
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
