package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class getStudentData {
	
	public String[][] getStudent()
	{
		final String url = "jdbc:mysql://localhost/result_management_system";
		final String user = "root";
		final String pass = "";
		String[][] arr;
		// establish the connection
		try (Connection connection = DriverManager.getConnection(url, user, pass);

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from student")) 
		{
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            rs.next();
	            System.out.println(rs.getString(1));
	            arr = new String[rs.getRow()][9];
	            int i = 0;
	            do{
	                arr[i][0] = rs.getString(1);
	                arr[i][1] = rs.getString(2);
	                arr[i][2] = rs.getString(3);
	                arr[i][3] = rs.getString(4);
	                arr[i][4] = rs.getString(5);
	                arr[i][5] = rs.getString(6);
	                arr[i][6] = rs.getString(7);
	                arr[i][7] = rs.getString(8);
	                arr[i][8] = rs.getString(9);
	            }while(rs.next());
	            return arr;

	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		return null;
	}

}
