package dbms;

import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

import dbms.DBInfo.*;

public class Login extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
		String s1 = req.getParameter("username");
		String s2 = req.getParameter("pass");
		
		String query = "select * from users where email=? and password=?";
		Connection con = DBInfo.con;
		PrintWriter pw = res.getWriter();

		int flag = 0;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,s1);
			ps.setString(2,s2);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				flag = 1;
				HttpSession session = req.getSession();
				session.setAttribute("emailid",s1);
				break;
			}
		}
		catch(Exception e){ e.printStackTrace();}
		
		if(flag==1){
			res.sendRedirect("changedetail");
		}
		else
			res.sendRedirect("../login.html");	
	}
}