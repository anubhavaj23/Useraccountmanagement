package dbms;

import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

import dbms.DBInfo.*;


public class Register extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
		PrintWriter pw = res.getWriter();
		
		String s1 = req.getParameter("fname").trim() + " " + req.getParameter("lname").trim();
		String s2 = req.getParameter("email");
		String s3 = req.getParameter("pass");

		
		String query = "select * from users where email=?";
		Connection con = DBInfo.con;
		int flag=0;
		PreparedStatement ps;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1,s2);
			ResultSet rs = ps.executeQuery();
			if(!(rs.next())){
				
				query = "insert into users(name,email,password) values(?,?,?)";
				ps = con.prepareStatement(query);
				ps.setString(1,s1);
				ps.setString(2,s2);
				ps.setString(3,s3);
				flag = ps.executeUpdate();

			}
			else{
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<script>");
				pw.println("alert('User already exists, try to login')");
				pw.println("</script>");
				pw.println("</body></html>");
				res.sendRedirect("../login.html");
				return;
			}
		}
		catch(Exception e){ e.printStackTrace();}
		if(flag!=0){
				pw.println("<html>");
				pw.println("<body>");				
				pw.println("<script>");
				pw.println("alert('Registration successful, login now')");
				pw.println("</script>");
				pw.println("</body></html>");
				res.sendRedirect("../login.html");

		}
		else{
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<script>");
				pw.println("alert('Registration unsuccessful, try again..')");
				pw.println("</script>");
				pw.println("</body></html>");
				res.sendRedirect("../register.html");
		}
	}
}