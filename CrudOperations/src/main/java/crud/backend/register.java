package crud.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newRegister")
public class register extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name1");
		String agePara = req.getParameter("age1");
		String email = req.getParameter("email1");
		String password = req.getParameter("pass1");
		
		int age = Integer.parseInt(agePara);
		
		try {				
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login_demo", "root", "mysql");
				
			PreparedStatement ps = con.prepareStatement("insert into UserData(name,age,email,password) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, email);
			ps.setString(4, password);
			
			int count = ps.executeUpdate();
			
			if(count > 0) {
				
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'> User Insertion Succesfully </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> User Insertion Fail </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> Exception Occure: "+e.getMessage()+" </h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
			
		}
	}
}
