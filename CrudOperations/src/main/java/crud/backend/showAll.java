package crud.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/showAll")
public class showAll extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root", "mysql");
			
			PreparedStatement ps = con.prepareStatement("select * from UserData");
			ResultSet rs = ps.executeQuery();
			
//			out.print("<div>");
			
			List<User> userList = new ArrayList<>();
			
			while(rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String email = rs.getString("email");
//				String password = rs.getString("password");
				
//				out.println("<p>ID: "+id+" Name: "+name+" Age: "+age+"Email: "+age+"Password "+password +"</p><br /> <br />");
			
//				HttpSession session = req.getSession();
//				session.setAttribute("Id", rs.getInt("id"));
//				session.setAttribute("Name", rs.getString("name"));
//				session.setAttribute("Age", rs.getInt("age"));
//				session.setAttribute("Email", rs.getString("email"));
//				session.setAttribute("Password", rs.getString("password"));
				
				User user = new User();
				
			    user.setId(rs.getInt("id"));
			    user.setName(rs.getString("name"));
			    user.setAge(rs.getInt("age"));
			    user.setEmail(rs.getString("email"));
			    user.setPassword(rs.getString("password"));

			    userList.add(user);
				
			}
			
			req.setAttribute("userList", userList);
			RequestDispatcher rd = req.getRequestDispatcher("/allrecords.jsp");
			rd.include(req, resp);
			
			rs.close();
            out.close();
            
            
		}catch(Exception e) {
			
			e.printStackTrace();
		} 
	}
}










