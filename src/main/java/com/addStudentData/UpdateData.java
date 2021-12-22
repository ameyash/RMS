package com.addStudentData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.http.*;
import com.signup.*;
public class UpdateData extends HttpServlet
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
		int i = 0;
		System.out.println("In Update :" +year);
		Login data = new Login();
		try {
			i = data.updateStudentData(studentName, studentId, year, division, sub1, sub2, sub3, sub4, sub5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);;
		}
		PrintWriter out = res.getWriter();
		if (i == 1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Student data updated successfully');");
			out.println("location='student.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something went wrong.... Try again');");
			out.println("location='student.jsp';");
			out.println("</script>"); 
		}
	}
}
