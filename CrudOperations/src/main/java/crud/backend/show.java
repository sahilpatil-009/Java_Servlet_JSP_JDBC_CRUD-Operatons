package crud.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateUser")
public class show extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
PrintWriter out = resp.getWriter();
		
		String idstr = req.getParameter("id");
		int id = Integer.parseInt(idstr);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root", "mysql");
			
			PreparedStatement ps = con.prepareStatement("select * from UserData where id=?");
			ps.setInt(1, id);
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				HttpSession session = req.getSession();
				session.setAttribute("Id", rs.getInt("id"));
				session.setAttribute("Name", rs.getString("name"));
				session.setAttribute("Age", rs.getInt("age"));
				session.setAttribute("Email", rs.getString("email"));
				session.setAttribute("Password", rs.getString("password"));
				
				RequestDispatcher rd = req.getRequestDispatcher("/show.jsp");
				rd.include(req, resp);
			}
//			if(count > 0) 
//			{
//				resp.setContentType("text/html");
//				out.print("<h3 style='color:green'> Delete Succesfully ! </h3>");
//				
//				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
//				rd.include(req, resp);
//				
//			}else {
//				
//				resp.setContentType("text/html");
//				out.print("<h3 style='color:red'> Error Occure ! </h3>");
//				
//				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
//				rd.include(req, resp);
//				
//			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
