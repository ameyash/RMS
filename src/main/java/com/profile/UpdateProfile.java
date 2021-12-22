package com.profile;

import java.io.IOException;
import java.io.PrintWriter;

import com.Data.AddData;
import com.signup.Login;

import jakarta.servlet.http.*;

public class UpdateProfile extends HttpServlet
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
				login.update(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"));
				flag=1;
			} catch (Exception e) {
				System.out.println(e);
			}
			if (flag == 1) {
				AddData.email = req.getParameter("email");
				AddData.name = req.getParameter("name");
				AddData.password = req.getParameter("password");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Profile updated successfully');");
				out.println("location='updateProfile.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong.... Try after some time');");
				out.println("location='updateProfile.jsp';");
				out.println("</script>");
			}
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password does not mtach');");
			out.println("location='updateProfile.jsp';");
			out.println("</script>");
		}
	}
}
