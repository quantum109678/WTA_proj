package com.not4win.electro.api;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import com.google.gson.Gson;

public class Main {
    private static final String API_USER_ID = "ashwinna";
    private static final String API_KEY = "LJOUWBKDMRLOJPLY";
	private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
	private static final String JDBC_URL = "jdbc:derby:/home/ashwin/MyDB;create=true";

    public static void main(String[] args) {
        List<Product> products;

        Observable<ProductResponse> observable = RestApiFactory.getRestApi()
                .getWashingMachines(API_USER_ID, API_KEY);

        products = observable.blockingFirst().getProduct();

        for (Product product : products) {
                System.out.println(product);
            	String item=product.getBrand().toLowerCase()+" "+product.getModel().toLowerCase();
            	String section=product.getSection();
            	int noffers=product.getStores().size();
            	Gson gson = new Gson();
            	String stores=gson.toJson(product.getStores());
        	    try {
        		      Class.forName(DRIVER);
        		      Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");
        		      String query = "INSERT INTO cellphone (item, section,noffers,stores)" 
        		    		  + " VALUES(?, ?, ?, ?)";
        		      PreparedStatement preparedStmt = conn.prepareStatement(query);
        		      preparedStmt.setString (1, item);
        		      preparedStmt.setString (2, section);
        		      preparedStmt.setInt (3, noffers);
        		      preparedStmt.setString (4, stores);
        		      preparedStmt.execute();
        		      conn.close();
        		    }
        		    catch (SQLException | ClassNotFoundException e) {	
        		    	String msg;
        				if (e instanceof SQLException) {
        					msg = "Query failed!";
        				}
        				else {
        					msg = "Driver not found!";
        				}
        		    }
            
        }
    }
}
