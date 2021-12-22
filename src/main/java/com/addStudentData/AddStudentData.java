package com.addStudentData;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.database.*;
public class AddStudentData extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		String studentId= req.getParameter("studentId");
		String studentName = req.getParameter("studentName");
		String year = req.getParameter("year");
		String division = req.getParameter("division");
		int sub1 = Integer.parseInt(req.getParameter("sub1"));
		int sub2 = Integer.parseInt(req.getParameter("sub2"));
		int sub3 = Integer.parseInt(req.getParameter("sub3"));
		int sub4 = Integer.parseInt(req.getParameter("sub4"));
		int sub5 = Integer.parseInt(req.getParameter("sub5"));
		float percentage = (sub1+sub2+sub3+sub4+sub5)/5;
		System.out.println("in Add"+percentage);
		int i = 0;
		InsertData data = new InsertData();
		try {
			i = data.insertStudentData(studentName, studentId, year, division, sub1, sub2, sub3, sub4, sub5,percentage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);;
		}
		PrintWriter out = res.getWriter();
		if (i == 1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Student result has been created');");
			out.println("location='add_student.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something went wrong.... Try after again');");
			out.println("location='add_student.jsp';");
			out.println("</script>");
		}
	}
}
