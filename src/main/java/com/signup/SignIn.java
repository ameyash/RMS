package com.signup;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;

import com.Data.*;
public class SignIn extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		Login login = new Login();
		int count = 0;
		try {
			count = login.fetch(req.getParameter("email"), req.getParameter("password"));
		} catch (Exception e) {
			System.out.println(e);
		}

		PrintWriter out = res.getWriter();
		if (count == 1) {
			String name="";
			try {
				name = login.fetchName(req.getParameter("email"), req.getParameter("password"));
			} catch (Exception e) {
				System.out.println(e);
			}
			AddData data = new AddData(name,req.getParameter("email"),req.getParameter("password"));
			System.out.println(data);
			req.setAttribute("name", name);
			RequestDispatcher view = req.getRequestDispatcher("homePage.jsp");
			view.forward(req, res);
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid email or password');");
			out.println("location='SignIn.html';");
			out.println("</script>");
		}	
	}
}
