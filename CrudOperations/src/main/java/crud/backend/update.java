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

@WebServlet("/UpdateOk")
public class update extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String Newname = req.getParameter("new_name");
		int NewAge = Integer.parseInt(req.getParameter("new_age"));
		String Newemail = req.getParameter("new_email");
		String NewPassword = req.getParameter("new_pass");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root", "mysql");
			
			PreparedStatement ps = con.prepareStatement("UPDATE UserData SET name=?, age=?, email=?, password=? WHERE id=?");
			ps.setString(1, Newname);
			ps.setInt(2, NewAge);
			ps.setString(3, Newemail);
			ps.setString(4, NewPassword);
			ps.setInt(5, id);
		
			int count =ps.executeUpdate();
			
			if(count > 0) 
				{
					resp.setContentType("text/html");
					out.print("<h3 style='color:green'>Update Succesfully ! </h3>");
					
					RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
					rd.include(req, resp);
					
				}else {
					
					resp.setContentType("text/html");
					out.print("<h3 style='color:red'> Error Occure ! </h3>");
					
					RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
					rd.include(req, resp);
					
				}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
}
