package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBconn {
	private static  String DB_Driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/hospital";
	private static String uname="root";
	private static String upwd="Upendra@123";
	
	private static Connection conn; 

	public static Connection getconn() throws SQLException, ClassNotFoundException {
		try {
		Class.forName(DB_Driver);
		conn=DriverManager.getConnection(url, uname, upwd);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	}

