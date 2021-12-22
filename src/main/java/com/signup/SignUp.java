package com.signup;

import jakarta.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//import com.database.InsertData;

public class SignUp extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		//InsertData data = new InsertData();
		Login login = new Login();
		String password = req.getParameter("password");
		String rPassword = req.getParameter("Rpassword");
		int flag = 0;
		PrintWriter out = res.getWriter();
		if(password.equals(rPassword))
		{
			try {
				if(login.getCount(req.getParameter("email"))>0)
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Email already Exist');");
					out.println("location='SignIn.html';");
					out.println("</script>");
				}
				else
				{
					try {
						login.insert(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"));
						flag=1;
					} catch (Exception e) {
						System.out.println(e);
					}
					if (flag == 1) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Profile created successfully');");
						out.println("location='SignIn.html';");
						out.println("</script>");
					} else {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Something went wrong.... Try after some time');");
						out.println("location='SignUp.html';");
						out.println("</script>");
					}
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password does not match');");
			out.println("location='SignUp.html';");
			out.println("</script>");
		}
		
	}
}