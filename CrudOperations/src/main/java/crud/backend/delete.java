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

@WebServlet("/deleteUser")
public class delete extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String idstr = req.getParameter("id");
		int id = Integer.parseInt(idstr);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root", "mysql");
			
			PreparedStatement ps = con.prepareStatement("delete from UserData where id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			
			if(count > 0) 
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'> Delete Succesfully ! </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
				
			}else {
				
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> Error Occure ! </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
