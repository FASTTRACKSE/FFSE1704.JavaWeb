package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.taglibs.standard.tag.common.core.CatchTag;

public class LoginDAO {
	Connection con = null;
	PreparedStatement ps = null;
	private String pwd;
	private String user;
	
	
	try {
		con = DataConnect.getConnection();
		ps = con.prepareStatement("Select uname, password from login where user = ? and pwd = ?");
		ps.setString(1, user);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			//result found, means valid inputs
			
		}
	} catch (SQLException ex) {
		System.out.println("Login error -->" + ex.getMessage());
		
	} finally {
		DataConnect.close(con);
	}
	public static boolean validate(String user2, String pwd2) {
		// TODO Auto-generated method stub
		return false;
	}


	return false;
}
}
