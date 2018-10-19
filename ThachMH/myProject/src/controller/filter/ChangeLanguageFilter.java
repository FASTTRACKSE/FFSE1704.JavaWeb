package controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ChangeLanguege
 */
public class ChangeLanguageFilter implements Filter {

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

		/**
		 * Flag nay duoc dung de quyet dinh co tao moi cookie khi
		 * khong ton tai cookie hoac thay doi ngon ngu 
		 * - true : trang thai cho phep tao moi 
		 * - false: trang thai khong cho phep tao moi
		 */
		boolean flagDefaultCookie = true;

		/**
		 * Gia tri set ngon ngu mac dinh ban dau se la tieng anh Neu cookie ton tai se
		 * duoc xu ly o duoi thay doi lai Neu la truong hop thay doi ngon ngu se duoc xy
		 * ly o duoi thay doi lai Neu la truong hop truy cap trang web lan dau tien se
		 * khong thay doi
		 */
		String langValue = "en";

		// Truong hop la thay doi ngon ngu
		if (request.getParameter("language") != null) {
			langValue = req.getParameter("language");
		} else {
			Cookie[] cookies = req.getCookies();

			// neu vao trang lan thu 2 tro di cookie se khac null
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					// kiem tra ton tai cookie "lang"
					if ("lang".equals(cookie.getName())) {
						flagDefaultCookie = false;
						langValue = cookie.getValue();
						break;
					}
				}
			}
		}

		if (flagDefaultCookie) {
			Cookie cookie = new Cookie("lang", langValue);
			cookie.setMaxAge(60 * 60 * 24 * 365);
			res.addCookie(cookie);
		}
		request.setAttribute("lang", langValue);

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
