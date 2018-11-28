package test.models;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validate {
	public boolean checkUser(String username, String password) {
		if (username.equals("mdragon1999") && password.equals("123")) {
			return true;
		}else {
			return false;
		}
	}
}