package com.offline;

import java.sql.*;



public class KddPaperData {

	
	public void getDataFromPost()
	{
		String url= "jdbc:postgresql://localhost:5432/kdd2013?user=postgres&password=1234&ssl=true";
		try {
			Connection conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
