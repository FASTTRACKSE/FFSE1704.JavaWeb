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
 * Servlet Filter implementation class ChangeLanguege
 */
public class CheckLoginFilter implements Filter {

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

//		if ((session != null && session.getAttribute("isLogin") != null)
//			|| req.getRequestURI().endsWith("login")
//			|| req.getRequestURI().matches(".*(js|css|jpg|png|jepg)")) {
//			chain.doFilter(request, response);
//		} else {
//			res.sendRedirect(req.getContextPath() + "/login");
//		}
		
//		if (session != null && session.getAttribute("isLogin") != null) {
//			if (!req.getRequestURI().endsWith("login")) {
//				chain.doFilter(request, response);
//			} else {
//				res.sendRedirect(req.getContextPath());
//			}
//		} else {
//			if (req.getRequestURI().endsWith("login")) {
//				chain.doFilter(request, response);
//			} else {
//				res.sendRedirect(req.getContextPath() + "/login");
//			}
//		}

		if (session != null && session.getAttribute("isLogin") != null) {
			if (!req.getRequestURI().endsWith("login")) {
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
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
