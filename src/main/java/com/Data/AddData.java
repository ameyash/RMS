package com.Data;

import java.io.*;

public class AddData
{
	public AddData()
	{
		
	}
	public static String name ;
	public static String email;
	public static String password;
	public AddData(String name,String email,String password)
	{
		this.name= name;
		this.email = email;
		this.password = password;
		System.out.println("name="+name);
	}
}
