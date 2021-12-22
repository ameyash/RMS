package com.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;

import jakarta.servlet.RequestDispatcher;

public class Login {

	public int update(String name,String email,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		  final String url = "jdbc:mysql://localhost/result_management_system";
	      final String user = "root";
	      final String pass = "";
	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, pass);
	      Statement st = con.createStatement();
	      String UPDATE_RECORD = "update signup set name=?,email=?,password=? where email=?";
	      
	      PreparedStatement pstmt = con.prepareStatement(UPDATE_RECORD);
	      pstmt.setString(1, name);
	      pstmt.setString(2, email);
	      pstmt.setString(3, password);
	      pstmt.setString(4, email);

	      pstmt.addBatch();
	      
	      // execute the batch
	      int[] updateCounts = pstmt.executeBatch();

	      checkUpdateCounts(updateCounts);
	      
	      // close JDBC connection
	      st.close();
	      con.close();
	      return 1;
	}
	
	public void insert(String name,String email,String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";

		// establish the connection
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		String INSERT_RECORD = "insert into signup(name,email,password) values(?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
		// pstmt.setInt(1, id);
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
	
	public int fetch(String email,String password) throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";

		// establish the connection
		try (Connection connection = DriverManager.getConnection(url, user, pass);

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from signup where email = ? and password = ? ")) 
		{
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            rs.next();
	            return rs.getRow();

	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		return 0;
	}
	
	public String fetchName(String email,String password) throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";
		// establish the connection
		try (Connection connection = DriverManager.getConnection(url, user, pass);

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select name from signup where email = ? and password = ? ")) 
		{
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            rs.next();
	            System.out.println(rs.getString(1));
	            return rs.getString(1);

	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		return null;
	}

	public static void checkUpdateCounts(int[] updateCounts) {
		for (int i = 0; i < updateCounts.length; i++) {
			if (updateCounts[i] >= 0) {
				System.out.println("OK; updateCount=" + updateCounts[i]);
			} else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
				System.out.println("OK; updateCount=Statement.SUCCESS_NO_INFO");
			} else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
				System.out.println("Failure; updateCount=Statement.EXECUTE_FAILED");
			}
		}
	} 
	
	public String[][] getStudent() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";
		String[][] arr;
		// establish the connection
		Connection con = DriverManager.getConnection(url, user, pass);

        // Step 2:Create a statement using connection object
        //PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
		try
		{
			  Statement stmt = con.createStatement();
		      //Retrieving the data
			  ResultSet rs = stmt.executeQuery("select count(*) from student");
		      rs.next();
	            //System.out.println(preparedStatement);
	            //ResultSet rs = preparedStatement.executeQuery();
	            System.out.print(rs.getInt("count(*)"));
	            arr = new String[rs.getInt("count(*)")][9];
	            int i = 0;
	            rs = stmt.executeQuery("select * from student");
	            while(rs.next()) {
	                arr[i][0] = rs.getString("name");
	                arr[i][1] = rs.getString("studentId");
	                arr[i][2] = rs.getString("year");
	                arr[i][3] = rs.getString("division");
	                arr[i][4] = Integer.toString(rs.getInt("sub1"));
	                arr[i][5] = Integer.toString(rs.getInt("sub2"));
	                arr[i][6] = Integer.toString(rs.getInt("sub3"));
	                arr[i][7] = Integer.toString(rs.getInt("sub4"));
	                arr[i][8] = Integer.toString(rs.getInt("sub5"));
	                i++;
	            }
	            for(int k=0;k<rs.getRow();k++)
	            {
	            	for(int j=0;j<9;j++)
	            	{
	            		System.out.print(arr[k][j]+" ");
	            	}
	            	System.out.println();
	            }
	            return arr;
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		return null;
	}
	
	public int updateStudentData(String name,String id,String year,String div,int sub1,int sub2,int sub3,int sub4,int sub5) throws SQLException, ClassNotFoundException
	{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  final String url = "jdbc:mysql://localhost/result_management_system";
	      final String user = "root";
	      final String pass = "";
	      System.out.println(sub1+" "+year);
	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, pass);
	      Statement st = con.createStatement();
	      String INSERT_RECORD = "update student set name=? ,year=? , division=? , sub1=? , sub2=? , sub3=? , sub4=? , sub5=? where studentId=?";
	      
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
	
	public int getCount() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";
		// establish the connection
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from student");
	    rs.next();
	    return rs.getInt("count(*)");
	}
	
	public int getCount(String email) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";
		try (Connection connection = DriverManager.getConnection(url, user, pass);

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select count(*) from signup where email = ? ")) 
		{
	            preparedStatement.setString(1, email);
	            ResultSet rs = preparedStatement.executeQuery();
	            rs.next();

	            return rs.getInt("count(*)");

	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		return 0;
	}
	
	public int getPassCount() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";
		// establish the connection
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from student where percentage>34");
	    rs.next();
	    return rs.getInt("count(*)");
	}
	public static JsonArray recordsArray;
	public void getPercentage() throws ClassNotFoundException, SQLException
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";
		// establish the connection
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select percentage from student");
		String percentage = null;
		recordsArray = new JsonArray();
		int i=1;
		while (rs.next()) {
			if(rs.getString("percentage")==null)
			{
				JsonObject currentRecord = new JsonObject();
				currentRecord.add("ProductName",
						new JsonPrimitive(Integer.toString(i)));
				currentRecord.add("UnitsInStock",
						new JsonPrimitive("90"));
				recordsArray.add(currentRecord);
			}
			else
			{
				JsonObject currentRecord = new JsonObject();
				currentRecord.add("ProductName",
						new JsonPrimitive(rs.getString("percentage")));
				currentRecord.add("UnitsInStock",
						new JsonPrimitive(Integer.toString(i)));
				recordsArray.add(currentRecord);
			}
			i++;
		}
		}
		catch(Exception e)
		{
			
			System.out.println("in login "+e);
		}
	}
	
	public String[] getSearchData(String id,String year,String div) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";

		// establish the connection
		try (Connection connection = DriverManager.getConnection(url, user, pass);

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from student where studentId = ? and year = ? and division = ? ")) 
		{
	            preparedStatement.setString(1, id);
	            preparedStatement.setString(2, year);
	            preparedStatement.setString(3, div);

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            String data[] = new String[10];
	            while(rs.next())
	            {
	            	data[0] = rs.getString("name");
	            	data[1] = rs.getString("studentId");
	            	data[2] = rs.getString("year");
	            	data[3] = rs.getString("division");
	            	data[4] = Integer.toString(rs.getInt("sub1"));
	            	data[5] = Integer.toString(rs.getInt("sub2"));
	            	data[6] = Integer.toString(rs.getInt("sub3"));
	            	data[7] = Integer.toString(rs.getInt("sub4"));
	            	data[8] = Integer.toString(rs.getInt("sub5"));
	            	data[9] = Integer.toString(rs.getInt("percentage"));
	            }
	            
	            for(int i=0;i<10;i++)
	            {
	            	System.out.println(data[i]);
	            }
	            return data;
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		return null;
	}
	
	public void resetPass(String email,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		  final String url = "jdbc:mysql://localhost/result_management_system";
	      final String user = "root";
	      final String pass = "";
	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, pass);
	      Statement st = con.createStatement();
	      String UPDATE_RECORD = "update signup set password=? where email=?";
	      
	      PreparedStatement pstmt = con.prepareStatement(UPDATE_RECORD);
	      pstmt.setString(1, password);
	      pstmt.setString(2, email);
	      
	      pstmt.addBatch();
	      
	      // execute the batch
	      int[] updateCounts = pstmt.executeBatch();

	      checkUpdateCounts(updateCounts);
	      
	      // close JDBC connection
	      st.close();
	      con.close();
	}
	
}
