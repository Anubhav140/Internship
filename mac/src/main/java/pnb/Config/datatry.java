package pnb.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Servlet implementation class datatry
 */
public class datatry {
	    
	    public static void main(String[] args) {
	        Connection connection = null;

	        try {
	            // Load MySQL JDBC Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish connection
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "As240618.");

	            if (connection != null) {
	                System.out.println("Database connected successfully!");
	            } else {
	                System.out.println("Failed to connect to the database.");
	            }

	        } catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC Driver not found.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Error connecting to the database.");
	            e.printStackTrace();
	        } finally {
	            // Close the connection
	            if (connection != null) {
	                try {
	                    connection.close();
	                    System.out.println("Connection closed.");
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}