package com.not4win.electro.util;
import java.awt.font.NumericShaper.Range;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.not4win.electro.model.Feedback;
import com.not4win.electro.api.Store;
import com.not4win.electro.model.User;
import com.sun.tools.javac.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


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
	
	public static ArrayList<String> getData(String item){
		
		ArrayList<String> blist = new ArrayList<String>(4);
		String s1="";
		String s2="";
		String s3="";
		String s4="";
		try {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(JDBC_URL, "root", "root");
		statement = connection.createStatement();
		String QueryString = "select * from cellphone where item="+" '"+item +"' ";
		rs = statement.executeQuery(QueryString);
		 

		String price="";
		String image="";
		
		while (rs.next()) {
		String store1= rs.getString(1);
		String store2= rs.getString(2);
		String store3= rs.getString(3);
		String store4= rs.getString(4);
		Gson gson=new Gson();
		ArrayList<Store> stores=gson.fromJson(store4, new TypeToken<ArrayList<Store>>(){}.getType());
		for(Store store:stores) {
			s1+=store.getImage()+" ";
			s2+=store.getPrice()+" ";
			s3+=store.getUrl()+" ";
			s4+=store.getWebsite()+" ";
	
		}
		}
		blist.add(s1);
		blist.add(s2);
		blist.add(s3);
		blist.add(s4);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return blist;
	}
	public static boolean addtoDBCart(String user,String website,String item) {
		try {
		      Class.forName(DRIVER);
		      Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");
		      String query = "INSERT INTO DBCart (account,website,item)" 
		    		  + " VALUES(?, ?, ?)";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, user);
		      preparedStmt.setString (2, website);
		      preparedStmt.setString (3, item);
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
	
	public static boolean deletefromDBCart(String user,String item) {
		String query = "DELETE FROM DBCart WHERE item = ?";
		try {
		      Class.forName(DRIVER);
		      Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");
		      PreparedStatement pstmt = conn.prepareStatement(query);
		      pstmt.setString(1, item);
		      pstmt.executeUpdate();
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
