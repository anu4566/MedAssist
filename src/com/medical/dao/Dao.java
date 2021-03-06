package com.medical.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dao {
	private static Connection conn = null;
	private static DaoI dao = null;
	private static Properties prop = new Properties();

	public static DaoI getInstance() {
		return dao;
	}

	static {
		dao = new MedicalDao();
		try {

			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}
	}

	public Connection getConnection() throws SQLException, URISyntaxException {
		URI dbUri = new URI("postgres://jelewisrldyrth:a9b6097a481766bce6e224157501ac76ed095299e4d98aa43b8e38189938436a@ec2-107-22-236-252.compute-1.amazonaws.com:5432/d2ores75b71fu8");
		String username= "jelewisrldyrth";
		String password="a9b6097a481766bce6e224157501ac76ed095299e4d98aa43b8e38189938436a";
		String dbUrl = "jdbc:postgresql://"+dbUri.getHost()+':'+dbUri.getPort()+dbUri.getPath();
		return DriverManager.getConnection(dbUrl,username,password);
		/*Connection con = null;
		try {

			String url = "jdbc:mysql://localhost/medicalsys";
			String uname = "root";
			String pass = "Anu@4566";
			con = DriverManager.getConnection(url, uname, pass);
			return con;
		} catch (Exception e) {
			System.out.println("Connection not opened!!!!");
		}
		return con;*/

	}



}
