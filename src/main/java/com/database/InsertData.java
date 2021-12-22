package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public int insert(String name,String email,String password){
		try {
	     // Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables
			final String url = "jdbc:mysql://localhost/result_management_system";
		      final String user = "root";
		      final String pass = "";

		      // establish the connection
		      Connection con = DriverManager.getConnection(url, user, pass);
		      Statement st = con.createStatement();
		      String INSERT_RECORD = "insert into signup(name,email,password) values(?,?,?)";
		      
		      PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
		      pstmt.setString(1, name);
		      pstmt.setString(2, email);
		      pstmt.setString(3, password);
		      pstmt.addBatch();
		      
		      // execute the batch
		      int[] updateCounts = pstmt.executeBatch();

		      checkUpdateCounts(updateCounts);
		      
		      // close JDBC connection
		      st.close();
		      con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	
	public int insertStudentData(String name,String id,String year,String div,int sub1,int sub2,int sub3,int sub4,int sub5,float per) throws SQLException
	{
		  final String url = "jdbc:mysql://localhost/result_management_system";
	      final String user = "root";
	      final String pass = "";

	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, pass);
	      Statement st = con.createStatement();
	      System.out.println(per);
	      String INSERT_RECORD = "insert into student(name,studentId,year,division,sub1,sub2,sub3,sub4,sub5,percentage) values(?,?,?,?,?,?,?,?,?,?)";
	      
	      PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
	      pstmt.setString(1, name);
	      pstmt.setString(2, id);
	      pstmt.setString(3, year);
	      pstmt.setString(4, div);
	      pstmt.setInt(5, sub1);
	      pstmt.setInt(6, sub2);
	      pstmt.setInt(7, sub3);
	      pstmt.setInt(8, sub4);
	      pstmt.setInt(9, sub5);
	      pstmt.setFloat(10, per);
	      pstmt.addBatch();
	      
	      // execute the batch
	      int[] updateCounts = pstmt.executeBatch();

	      checkUpdateCounts(updateCounts);
	      
	      // close JDBC connection
	      st.close();
	      con.close();
		return 1;
	}
	
	public static void checkUpdateCounts(int[] updateCounts) {
	    for (int i=0; i<updateCounts.length; i++) {
	        if (updateCounts[i] >= 0) {
	            System.out.println("OK; updateCount="+updateCounts[i]);
	        }
	        else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
	            System.out.println("OK; updateCount=Statement.SUCCESS_NO_INFO");
	        }
	        else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
	            System.out.println("Failure; updateCount=Statement.EXECUTE_FAILED");
	        }
	    }
	} 
	
	public int updateStudentData(String name,String id,String year,String div,int sub1,int sub2,int sub3,int sub4,int sub5) throws SQLException
	{
		  final String url = "jdbc:mysql://localhost/result_management_system";
	      final String user = "root";
	      final String pass = "";

	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, pass);
	      Statement st = con.createStatement();
	      String INSERT_RECORD = "update student set name=? , studentId=? ,year=? , division=? , sub1=? , sub2=? , sub3=? , sub4=? , sub5=? where , studentId=?";
	      
	      PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
	      pstmt.setString(1, name);
	      pstmt.setString(2, year);
	      pstmt.setString(3, div);
	      pstmt.setInt(4, sub1);
	      pstmt.setInt(5, sub2);
	      pstmt.setInt(6, sub3);
	      pstmt.setInt(7, sub4);
	      pstmt.setInt(8, sub5);
	      pstmt.setString(9, id);
	      pstmt.addBatch();
	      
	      // execute the batch
	      int[] updateCounts = pstmt.executeBatch();

	      checkUpdateCounts(updateCounts);
	      
	      // close JDBC connection
	      st.close();
	      con.close();
		return 1;
	}

}
