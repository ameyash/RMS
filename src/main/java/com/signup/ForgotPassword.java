package com.signup;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.*;

public class ForgotPassword extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		Login login = new Login();
		String password = req.getParameter("password");
		String rPassword = req.getParameter("Rpassword");
		int flag = 0;
		PrintWriter out = res.getWriter();
		if(password.equals(rPassword))
		{
			try {
				login.resetPass(req.getParameter("email"), req.getParameter("password"));
				flag=1;
			} catch (Exception e) {
				System.out.println(e);
			}
			if (flag == 1) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Password updated successfully');");
				out.println("location='SignIn.html';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong.... Try after some time');");
				out.println("location='forgotpassword.jsp';");
				out.println("</script>");
			}
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password does not match');");
			out.println("location='forgotpassword.jsp';");
			out.println("</script>");
		}
		
	}
}
