package dbms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class changedetail extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String)(session.getAttribute("emailid"));
		
		if(email==null){
			response.sendRedirect("../login.html");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Change Details</title>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css'>");
        out.println("<link rel='stylesheet' type='text/css' href='../css/changedetails.css'>");

        
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='frame'>");
					
		out.println("<p class='idsignout'>"+email+"/<a href='signout'>SignOut</a></p>");
		
		out.println("<div id='container-fluid'>");
		out.println("<div class='row'>");
		out.println("<div class='col-md-4 col-md-offset-4'>");
		out.println("<form class='form-horizontal' role='form' action='changedetailconfirm' method='post'>");
		out.println("<fieldset style='margin-top:100px;'>");

		out.println("<legend>Details</legend>");
		
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label' for='textinput'>Name</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' name='name' id='name' placeholder='Name' class='form-control'>");	
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label' for='textinput'>Age</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' name='age' id='age' placeholder='Age' class='form-control'>");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label' for='textinput'>Address</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' name='addr' id='addr' placeholder='Address' class='form-control'>");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label' for='textinput'>City</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' name='city' id='city' placeholder='City' class='form-control'>");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<label class='col-sm-2 control-label' for='textinput'>State</label>");
		out.println("<div class='col-sm-4'>");
		out.println("<input type='text' name='state' id='state' placeholder='State' class='form-control'>");
		out.println("</div>");
		
        
        out.println("<label class='col-sm-2 control-label' for='textinput'>Postcode</label>");
		out.println("<div class='col-sm-4'>");
        out.println("<input type='text' name='postcode' id='postcode' placeholder='Post Code' class='form-control'>");
        out.println("</div>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<label class='col-sm-2 control-label' for='textinput'>Contact</label>");
        out.println("<div class='col-sm-10'>");
        out.println("<input type='text' name='contactnum' id='contactnum' placeholder='Phone number' class='form-control'>");
        out.println("</div>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<div class='col-sm-offset-2 col-sm-10'>");
        out.println("<div class='pull-right'>");
        out.println("<button type='submit' class='btn btn-default'>Cancel</button>");
        out.println("<button type='submit' onclick='return Function()' class='btn btn-primary'>Save</button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        out.println("</fieldset>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
        out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js'></script>");
        out.println("<script src='../js/changedetail.js'></script>");
        out.println("</body>");
        out.println("</html>");
                
		
        }

}
