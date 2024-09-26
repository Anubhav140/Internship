package pnb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pnb.Config.DatabaseConfig;
import pnb.entity.User;

public class UsersModel {
    public List<User> listuser() {
        List<User> listusers = new ArrayList<User>();
        Connection connect = DatabaseConfig.getConnection();
        
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM users";

        try {
            // Check if the connection is null
            if (connect == null) {
                throw new SQLException("Failed to establish a database connection");
            } else {
                stmt = connect.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    // Update this line to match the User constructor
                    listusers.add(new User(
                        rs.getString("CaseID"),
                        rs.getString("CaseType"), // Include caseType
                        rs.getString("Description"),
                        rs.getInt("Number_Of_Files")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in finally block to avoid memory leaks
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listusers;
    }

    public void addCase(User newCase) {
        Connection connect = null;
        PreparedStatement statement = null;
        try {
            connect = DatabaseConfig.getConnection();
            String CaseID = newCase.getCaseID();
            String CaseType = newCase.getCaseType(); // Include caseType
            String Description = newCase.getDescription();
            int Number_Of_Files = newCase.getNumber_Of_Files();
            String query = "INSERT INTO users (CaseID, CaseType, Description, Number_Of_Files) VALUES (?, ?, ?, ?)";
            statement = connect.prepareStatement(query);
            statement.setString(1, CaseID);
            statement.setString(2, CaseType); // Set caseType
            statement.setString(3, Description);
            statement.setInt(4, Number_Of_Files);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            try {
                if (statement != null) statement.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCase(User updateCase) {
        Connection connect = null;
        PreparedStatement statement = null;
        try {
            connect = DatabaseConfig.getConnection();
            String CaseID = updateCase.getCaseID();
            String CaseType = updateCase.getCaseType(); // Corrected method name
            String Description = updateCase.getDescription();
            int Number_Of_Files = updateCase.getNumber_Of_Files();
            String query = "UPDATE users SET CaseType=?, Description=?, Number_Of_Files=? WHERE CaseID=?";
            statement = connect.prepareStatement(query);
            statement.setString(1, CaseType); // Set new caseType
            statement.setString(2, Description); // Set new description
            statement.setInt(3, Number_Of_Files); // Set new number of files
            statement.setString(4, CaseID); // This specifies which row to update (where CaseID = ?)

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            try {
                if (statement != null) statement.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
