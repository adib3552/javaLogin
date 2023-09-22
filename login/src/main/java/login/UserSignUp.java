package login;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserSignUp extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username=req.getParameter("uname");
		String password=req.getParameter("pass");
		String email=req.getParameter("email");
		
		DatabaseConnect dbc=new DatabaseConnect();
		
		if(dbc.insert(username, password, email)) {
			res.sendRedirect("loginpage.html");
		}
		else {
			res.sendRedirect("signup.html");
		}
	}
}
