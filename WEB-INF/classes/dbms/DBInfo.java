package dbms;

import java.sql.*;
import java.io.*;

public class DBInfo{
	public static Connection con;
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
