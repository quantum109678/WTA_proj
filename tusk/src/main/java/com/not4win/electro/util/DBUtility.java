package com.not4win.electro.util;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.not4win.electro.model.Feedback;
import com.not4win.electro.model.User;


public class DBUtility {
	private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/ashwin/MyDB;create=true";
	
	private static final Logger LOGGER = Logger.getLogger(DBUtility.class.getSimpleName());
	
	public static boolean verifyLogin(String username, String password) {
		boolean verified = false;
		try {
			LOGGER.log(Level.INFO, username);
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");
		    Statement st = (Statement)conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT username, password FROM login");
            
            while(rs.next()) {
                if(rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
                    verified = true;
                    break;
                }
            }
            
            return verified;
		}
		catch(SQLException | ClassNotFoundException e) {
			String msg;
			if (e instanceof SQLException) {
				msg = "Query failed!";
			}
			else {
				msg = "Driver not found!";
			}
			LOGGER.log(Level.WARNING, msg, e);
			return false;
		}
	}
	
	public static boolean addUser(User user) {
	    try {
	      Class.forName(DRIVER);
	      Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");
	      String query = "INSERT INTO users (aadhar, fname, lname, address, gender, pno, username, password)" 
	    		  + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, user.getAadhar());
	      preparedStmt.setString (2, user.getFName());
	      preparedStmt.setString (3, user.getLName());
	      preparedStmt.setString (4, user.getAddress());
	      preparedStmt.setString (5, user.getGender());
	      preparedStmt.setString (6, user.getPno());
	      preparedStmt.setString (7, user.getUsername());
	      preparedStmt.setString (8, user.getPassword());
	      preparedStmt.execute();
	      conn.close();
	      return true;
	    }
	    catch (SQLException | ClassNotFoundException e) {	
	    	String msg;
			if (e instanceof SQLException) {
				msg = "Query failed!";
			}
			else {
				msg = "Driver not found!";
			}
			LOGGER.log(Level.WARNING, msg, e);
			return false;
	    }
	}
	
	public static boolean sendFeedback(Feedback feedback) {
	    try {
	      Class.forName(DRIVER);
	      Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");
	      String query = "INSERT INTO users (name, email, typeofissue, description)"
	        + " VALUES(?, ?, ?, ?)";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, feedback.getName());
	      preparedStmt.setString(2, feedback.getEmail());
	      preparedStmt.setString(3, feedback.getType_issue());
	      preparedStmt.setString(4, feedback.getDescription());
	      preparedStmt.execute();
	      conn.close();
	      return true;
	    }
	    catch (SQLException | ClassNotFoundException e) {	
	    	String msg;
			if (e instanceof SQLException) {
				msg = "Query failed!";
			}
			else {
				msg = "Driver not found!";
			}
			LOGGER.log(Level.WARNING, msg, e);
			return false;
	    }
	}
}
