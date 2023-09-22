package login;

import java.io.IOException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLogin extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username=req.getParameter("uname");
		String password=req.getParameter("pass");
		
		DatabaseConnect dbc=new DatabaseConnect();
		boolean check=dbc.validate(username, password);
		
		if(username=="" || password=="") {
			res.sendRedirect("loginpage.html");
		}
		else if(check) {
			
			User user=dbc.fetchUserInfo(username);
			HttpSession session=req.getSession();
			session.setAttribute("user",user);
			
			res.sendRedirect("welcomePage.jsp");
		}
		else {
			res.sendRedirect("errorLogin.jsp");
		}
	}
}
