package com.jayjariwala.nightlife.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	
	final String serverURL="jdbc:mysql://127.7.77.130:3306/nightlife";
	final String ServerUserName="adminhVxMJ81";
	final String serverpass="QuBeRwRNIHMq";	
	
	public Connection openconnection()
	{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {

	
				Connection con=DriverManager.getConnection(serverURL,ServerUserName,serverpass);
				
				//final String url="jdbc:mysql://localhost/Voteitup";
			//	Connection con=DriverManager.getConnection(url,username,password);
				System.out.print("Connection successful!"); 
				return con;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
