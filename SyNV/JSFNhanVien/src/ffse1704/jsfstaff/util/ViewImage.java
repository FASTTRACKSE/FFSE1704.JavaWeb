package ffse1704.jsfstaff.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewImage
 */
@WebServlet("/images/*")
public class ViewImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String dirPath = "#";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String filename = request.getPathInfo().substring(1);
	    File file = new File(dirPath, filename);
	    response.setHeader("Content-Type", getServletContext().getMimeType(filename));
	    response.setHeader("Content-Length", String.valueOf(file.length()));
	    response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
	    Files.copy(file.toPath(), response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
