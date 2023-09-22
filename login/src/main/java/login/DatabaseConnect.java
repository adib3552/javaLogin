package login;

import java.sql.*;

//user DAO
public class DatabaseConnect {
	String url="jdbc:mysql://localhost:3306/login";
	String username="root";
	String password="";
	
	
	public boolean validate(String uname, String pass){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			String query="select * from userinfo where username=? and pass=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insert(String uname,String pass,String email) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			String query="insert into userinfo values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ps.setString(3, email);
			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public User fetchUserInfo(String uname) {
		
		User user=new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			String query="select username,email from userinfo where username=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			rs.next();
			user.name=rs.getString(1);
			user.email=rs.getString(2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user; 
	}
}
