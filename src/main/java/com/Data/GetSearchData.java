package com.Data;

import java.io.IOException;
import java.sql.SQLException;

import com.signup.Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class GetSearchData extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id = req.getParameter("studentId");
		String year = req.getParameter("year");
		String div = req.getParameter("division");
		
		Login login = new Login();
		try {
			String data[] = login.getSearchData(id,year,div);
			StringBuffer sb = new StringBuffer();
		      for(int i = 0; i < data.length; i++) {
		         sb.append(data[i]);
		         sb.append(",");
		      }
		      String str = sb.toString();
		      System.out.println(str);
			req.setAttribute("data", str);
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
			view.forward(req, res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
