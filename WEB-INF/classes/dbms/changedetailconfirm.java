package dbms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbms.DBInfo;
public class changedetailconfirm extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("emailid");
                
            if(email==null){
			     response.sendRedirect("../login.html");
		    }
			
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String address = request.getParameter("addr");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String postcode = request.getParameter("postcode");
            String contact = request.getParameter("contactnum");

			if(name == null || name == "")
				response.sendRedirect("signout");
			String query = "select * from userdetails where email=?";
			Connection con = DBInfo.con;

			
				try{
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,email);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
							query = "update userdetails set name='"+name+"',age="+Integer.parseInt(age)+",address='"+address+"',contact='"+contact+"',city='"+city+"',postcode='"+postcode+"',state='"+state+"' where email='"+email+"'";
                            
							ps = con.prepareStatement(query);
							int flag=ps.executeUpdate();
							if(flag==0)
                                response.sendRedirect("changedetail");
							
				    }
				    else{
						query = "insert into userdetails(email,name,age,contact,address,city,state,postcode) values(?,?,?,?,?,?,?,?);";
                        ps = con.prepareStatement(query);
                        ps.setString(1, email);
                        ps.setString(2, name);
				        ps.setInt(3, Integer.parseInt(age));
				        ps.setString(4, contact);
                        ps.setString(5, address);
				        ps.setString(6, city);
				        ps.setString(7, state);
				        ps.setString(8, postcode);
						int flag=ps.executeUpdate();
						if(flag==0)
                            response.sendRedirect("changedetail");
				    }
				}catch(Exception e){e.printStackTrace();}	
                
			
            response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>DBMS</title>");
		out.println("<script>");
        out.println("window.alert('Detail added');");
        out.println("document.location.href = 'signout';");
        out.println("</script>");
		out.println("</head>");
		out.println("<body>");
        out.println("</body>");
        out.println("</html>");
		
	}
}